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
import com.schoolregistrationsystem.converter.StudentConverter;
import com.schoolregistrationsystem.data.AppEntityRepository;
import com.schoolregistrationsystem.data.CourseRepository;
import com.schoolregistrationsystem.data.StudentRepository;
import com.schoolregistrationsystem.domain.Course;
import com.schoolregistrationsystem.domain.Student;
import com.schoolregistrationsystem.dto.CourseDto;
import com.schoolregistrationsystem.dto.ResponseDto;
import com.schoolregistrationsystem.dto.StudentDto;

@Transactional
@Service("StudentService")
public class StudentService extends AppEntityService<Student, StudentDto> {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private StudentConverter studentConverter;

	@Override
	public AppEntityRepository<Student> getEntityRepository() {
		return studentRepo;
	}

	@Override
	public AppEntityConverter<Student, StudentDto> getEntityConverter() {
		return studentConverter;
	}

	public ResponseDto<StudentDto> getByCode(String code) {
		Optional<Student> studentEntity = studentRepo.findStudentByCode(code);
		if (!studentEntity.isPresent()) {
			return new ResponseDto<>();
		}
		return new ResponseDto<>(getEntityConverter().mapEntityToDto(studentEntity.get()));
	}

	public ResponseDto<StudentDto> getByNameLastName(String name, String lastName) {
		Optional<Student> studentEntity = studentRepo.findStudentByNameAndLastName(name, lastName);
		if (!studentEntity.isPresent()) {
			return new ResponseDto<>();
		}
		return new ResponseDto<>(getEntityConverter().mapEntityToDto(studentEntity.get()));
	}

	public ResponseDto<List<StudentDto>> getAllStudents() {
		try {
			List<Student> responseStudent = studentRepo.findAll();
			if (!responseStudent.isEmpty()) {
				return new ResponseDto<>(studentConverter.mapListEntityToListDto(responseStudent),
						Long.valueOf(responseStudent.size()));
			}
			return new ResponseDto<>(new ArrayList<>());
		} catch (Exception e) {
			return new ResponseDto<>(ResultResponse.ERROR,
					Arrays.asList(new MessageDetail(e.getMessage(), 500, Arrays.toString(e.getStackTrace()))));
		}
	}

	@Override
	protected Boolean checkIfEntityExistsByLogicKey(StudentDto entityDto) {
		return studentRepo.existsByCode(entityDto.getCode());
	}

	public ResponseDto<List<StudentDto>> findAllStudentsWithoutCourses() {
		try {
			List<Student> responseStudent = studentRepo.findByCoursesIsEmpty();
			if (responseStudent != null && !responseStudent.isEmpty()) {
				return new ResponseDto<>(studentConverter.mapListEntityToListDto(responseStudent),
						Long.valueOf(responseStudent.size()));
			}
			return new ResponseDto<>(new ArrayList<>());
		} catch (Exception e) {
			return new ResponseDto<>(ResultResponse.ERROR,
					Arrays.asList(new MessageDetail(e.getMessage(), 500, Arrays.toString(e.getStackTrace()))));
		}
	}

	public ResponseDto<List<StudentDto>> findAllStudentsByCourse(String courseName) {
		try {
			List<Student> responseStudent = studentRepo.findStudentsByCourses_Name(courseName);
			if (responseStudent != null && !responseStudent.isEmpty()) {
				return new ResponseDto<>(studentConverter.mapListEntityToListDto(responseStudent),
						Long.valueOf(responseStudent.size()));
			}
			return new ResponseDto<>(new ArrayList<>());
		} catch (Exception e) {
			return new ResponseDto<>(ResultResponse.ERROR,
					Arrays.asList(new MessageDetail(e.getMessage(), 500, Arrays.toString(e.getStackTrace()))));
		}
	}
}
