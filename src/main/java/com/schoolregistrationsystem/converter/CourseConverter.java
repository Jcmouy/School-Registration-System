package com.schoolregistrationsystem.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import com.schoolregistrationsystem.domain.Course;
import com.schoolregistrationsystem.domain.Format;
import com.schoolregistrationsystem.domain.Student;
import com.schoolregistrationsystem.dto.CourseDto;
import com.schoolregistrationsystem.dto.FormatDto;
import com.schoolregistrationsystem.dto.StudentDto;

@Service
public class CourseConverter extends AppEntityConverter<Course, CourseDto> {

	@Autowired
	private FormatConverter formatConverter;
	
	@Autowired
	private StudentConverter studentConverter;

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

	@Override
	public Course mapDtoToEntity(CourseDto dto) {
		Course entity = super.mapDtoToEntity(dto);
		entity.setStudents(loadStudentsDto(dto));
		entity.setFormats(loadFormatsDto(dto));
		return entity;
	}
	
	private Set<Student> loadStudentsDto(CourseDto entity) {
		Set<Student> students = new HashSet<>();
		entity.getStudents().stream().forEach(selstudent -> {
			Student student = studentConverter.mapDtoToEntity(selstudent);
			students.add(student);
		});
		return students;
	}
	
	private Set<Format> loadFormatsDto(CourseDto entity) {
		Set<Format> formats = new HashSet<>();
		entity.getFormats().stream().forEach(selformat -> {
			Format format = formatConverter.mapDtoToEntity(selformat);
			formats.add(format);
		});
		return formats;
	}

	@Override
	public CourseDto mapEntityToDto(Course entity) {
		CourseDto dto = super.mapEntityToDto(entity);
		dto.setStudents(loadStudentsEntity(entity));
		dto.setFormats(loadFormatsEntity(entity));
		return dto;
	}
	
	private Set<StudentDto> loadStudentsEntity(Course entity) {
		Set<StudentDto> students = new HashSet<>();
		entity.getStudents().stream().forEach(selstudent -> {
			StudentDto student = studentConverter.mapEntityToDto(selstudent);
			students.add(student);
		});
		return students;
	}
	
	private Set<FormatDto> loadFormatsEntity(Course entity) {
		Set<FormatDto> formats = new HashSet<>();
		entity.getFormats().stream().forEach(selformat -> {
			FormatDto format = formatConverter.mapEntityToDto(selformat);
			formats.add(format);
		});
		return formats;
	}
}
