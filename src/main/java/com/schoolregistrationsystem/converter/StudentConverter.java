package com.schoolregistrationsystem.converter;

import org.springframework.stereotype.Service;

import com.schoolregistrationsystem.domain.Student;
import com.schoolregistrationsystem.dto.StudentDto;

@Service
public class StudentConverter extends AppEntityConverter<Student, StudentDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
