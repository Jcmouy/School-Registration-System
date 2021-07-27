package com.schoolregistrationsystem.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolregistrationsystem.dto.CourseDto;
import com.schoolregistrationsystem.dto.ResponseDto;
import com.schoolregistrationsystem.dto.StudentDto;
import com.schoolregistrationsystem.service.CourseService;
import com.schoolregistrationsystem.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/report", produces = "application/json")
@CrossOrigin(origins = "*")
public class ReportApiController {

	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;

	@ApiOperation(value = "Finds all courses of Student", response = Long.class)
	@GetMapping(path = "/courses/{code}", produces = "application/json")
	public ResponseEntity<ResponseDto<List<CourseDto>>> findAllCoursesOfStudent(@PathVariable("code") String code) {
		return new ResponseEntity<>(courseService.findAllCoursesByStudent(code), HttpStatus.OK);
	}

	@ApiOperation(value = "Finds all students without courses", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/courses/empty/", produces = "application/json")
	public ResponseEntity<ResponseDto<List<StudentDto>>> findAllStudentWithoutCourses() {
		return new ResponseEntity<>(studentService.findAllStudentsWithoutCourses(), HttpStatus.OK);
	}

	@ApiOperation(value = "Finds all students of course", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/students/{name}", produces = "application/json")
	public ResponseEntity<ResponseDto<List<StudentDto>>> findAllStudentInCourse(@PathVariable("name") String name) {
		return new ResponseEntity<>(studentService.findAllStudentsByCourse(name), HttpStatus.OK);
	}

	@ApiOperation(value = "Finds all courses without students", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/students/empty/", produces = "application/json")
	public ResponseEntity<ResponseDto<List<CourseDto>>> findAllCoursesWithoutStudents() {
		return new ResponseEntity<>(courseService.findAllCoursesWithoutStudents(), HttpStatus.OK);
	}
}
