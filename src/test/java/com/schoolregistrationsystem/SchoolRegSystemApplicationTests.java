package com.schoolregistrationsystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.schoolregistrationsystem.data.CourseRepository;
import com.schoolregistrationsystem.data.StudentRepository;
import com.schoolregistrationsystem.service.StudentService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringTestConfiguration.class })
class SchoolRegSystemApplicationTests {
	

}
