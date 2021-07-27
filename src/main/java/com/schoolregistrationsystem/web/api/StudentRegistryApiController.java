package com.schoolregistrationsystem.web.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolregistration.system.validation.CourseValidation;
import com.schoolregistrationsystem.common.enums.CommonMessagesImpl;
import com.schoolregistrationsystem.common.enums.ResultResponse;
import com.schoolregistrationsystem.common.exceptions.MessageDetail;
import com.schoolregistrationsystem.constants.GeneralConstants;
import com.schoolregistrationsystem.converter.CourseConverter;
import com.schoolregistrationsystem.converter.StudentConverter;
import com.schoolregistrationsystem.domain.Course;
import com.schoolregistrationsystem.domain.Student;
import com.schoolregistrationsystem.dto.CourseDto;
import com.schoolregistrationsystem.dto.ResponseDto;
import com.schoolregistrationsystem.service.CourseService;
import com.schoolregistrationsystem.service.StudentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/student-registry", produces = "application/json")
@CrossOrigin(origins = "*")
public class StudentRegistryApiController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	private StudentConverter studentConverter;
	
	@Autowired
	private CourseConverter courseConverter;

	@ApiOperation(value = "Register to a course", response = Long.class)
	@PostMapping(path = "/{studentCode}/{courseName}", produces = "application/json")
	public ResponseEntity<ResponseDto<CourseDto>> register(@PathVariable("studentCode") String studentCode, @PathVariable("courseName") String courseName) {
		List<CourseDto> coursesStudent = courseService.findAllCoursesByStudent(studentCode).getResponse();
		int amountCoursesByStudent = coursesStudent.size(); 
		
		int amountStudentsByCourse = courseService.countStudentsByCourse(courseName).getResponse().intValue();
		
		if (amountCoursesByStudent < GeneralConstants.MAX_COURSES_PER_STUDENT && amountStudentsByCourse < GeneralConstants.MAX_STUDENTS_PER_COURSE) {
			
			if (CourseValidation.checkIfStudentRegistered(courseName, coursesStudent)) {
				ResponseDto response = new ResponseDto<>(ResultResponse.ERROR,
						Arrays.asList(new MessageDetail(CommonMessagesImpl.ERROR_COURSES_STUDENT_REGISTERED)));
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
			Student studentEntity = studentConverter.mapDtoToEntity(studentService.getByCode(studentCode).getResponse());
			Course courseEntity = courseConverter.mapDtoToEntity(courseService.getByName(courseName).getResponse());
			
			courseEntity.getStudents().add(studentEntity);
			ResponseDto response = courseService.update(courseConverter.mapEntityToDto(courseEntity));
			
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		} else if (amountStudentsByCourse >= GeneralConstants.MAX_STUDENTS_PER_COURSE) {
			ResponseDto response = new ResponseDto<>(ResultResponse.ERROR,
					Arrays.asList(new MessageDetail(CommonMessagesImpl.ERROR_COURSES_MAX_STUDENTS)));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			ResponseDto response = new ResponseDto<>(ResultResponse.ERROR,
					Arrays.asList(new MessageDetail(CommonMessagesImpl.ERROR_STUDENT_MAX_COURSES)));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	

}
