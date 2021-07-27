package com.schoolregistration.system.validation;

import java.util.List;

import com.schoolregistrationsystem.dto.CourseDto;

public class CourseValidation {
	
	public static boolean checkIfStudentRegistered (String courseName, List<CourseDto> coursesStudent) {
		boolean alreadyRegistered = false;
		for (CourseDto course : coursesStudent) {
			if (course.getName().equals(courseName)) {
				alreadyRegistered = true;
			}
		}
		return alreadyRegistered;
	}

}
