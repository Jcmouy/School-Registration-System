package com.schoolregistrationsystem.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schoolregistrationsystem.common.enums.ResultResponse;
import com.schoolregistrationsystem.common.exceptions.MessageDetail;
import com.schoolregistrationsystem.converter.AppEntityConverter;
import com.schoolregistrationsystem.converter.CourseConverter;
import com.schoolregistrationsystem.data.AppEntityRepository;
import com.schoolregistrationsystem.data.CourseRepository;
import com.schoolregistrationsystem.data.StudentRepository;
import com.schoolregistrationsystem.domain.Course;
import com.schoolregistrationsystem.domain.Student;
import com.schoolregistrationsystem.dto.CourseDto;
import com.schoolregistrationsystem.dto.ResponseDto;
import com.schoolregistrationsystem.dto.StudentDto;
import com.schoolregistrationsystem.common.enums.CommonMessagesImpl;

@Transactional
@Service("CourseService")
public class CourseService extends AppEntityService<Course, CourseDto> {

	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CourseConverter courseConverter;

	@Override
	public AppEntityRepository<Course> getEntityRepository() {
		return courseRepo;
	}

	@Override
	public AppEntityConverter<Course, CourseDto> getEntityConverter() {
		return courseConverter;
	}
	
	public ResponseDto<CourseDto> getByName(String courseName) {
		Optional<Course> courseEntity = courseRepo.findCourseByName(courseName);
		if (!courseEntity.isPresent()) {
			return new ResponseDto<>();
		}
		return new ResponseDto<>(getEntityConverter().mapEntityToDto(courseEntity.get()));
	}

	public ResponseDto<List<CourseDto>> getAllCourses() {
		try {
			List<Course> responseCourse = courseRepo.findAll();
			if (!responseCourse.isEmpty()) {
				return new ResponseDto<>(courseConverter.mapListEntityToListDto(responseCourse),
						Long.valueOf(responseCourse.size()));
			}
			return new ResponseDto<>(new ArrayList<>());
		} catch (Exception e) {
			return new ResponseDto<>(ResultResponse.ERROR,
					Arrays.asList(new MessageDetail(e.getMessage(), 500, Arrays.toString(e.getStackTrace()))));
		}

	}
	
	public ResponseDto<Long> countStudentsByCourse(String coursename) {
		Optional<Course> courseEntity = courseRepo.findCourseByName(coursename);
		long numberStudents = courseEntity.get().getStudents().size();
		return new ResponseDto<>(numberStudents, Arrays.asList(new MessageDetail(CommonMessagesImpl.SUCCESS_ENTITY_OPERATION)));
	}

	@Override
	protected Boolean checkIfEntityExistsByLogicKey(CourseDto entidadDto) {
		return false;
	}
	
	public ResponseDto<List<CourseDto>> findAllCoursesByStudent(String code) {
		try {
			List<Course> responseCourse = courseRepo.findCoursesByStudents_Code(code);
			if (responseCourse != null && !responseCourse.isEmpty()) {
				return new ResponseDto<>(courseConverter.mapListEntityToListDto(responseCourse),
						Long.valueOf(responseCourse.size()));
			}
			return new ResponseDto<>(new ArrayList<>());
		} catch (Exception e) {
			return new ResponseDto<>(ResultResponse.ERROR,
					Arrays.asList(new MessageDetail(e.getMessage(), 500, Arrays.toString(e.getStackTrace()))));
		}
	}

	public ResponseDto<List<CourseDto>> findAllCoursesWithoutStudents() {
		try {
			List<Course> responseCourse = courseRepo.findByStudentsIsEmpty();
			if (responseCourse != null && !responseCourse.isEmpty()) {
				return new ResponseDto<>(courseConverter.mapListEntityToListDto(responseCourse),
						Long.valueOf(responseCourse.size()));
			}
			return new ResponseDto<>(new ArrayList<>());
		} catch (Exception e) {
			return new ResponseDto<>(ResultResponse.ERROR,
					Arrays.asList(new MessageDetail(e.getMessage(), 500, Arrays.toString(e.getStackTrace()))));
		}
	}
}
