package com.schoolregistrationsystem;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.schoolregistrationsystem.converter.StudentConverter;
import com.schoolregistrationsystem.data.CourseRepository;
import com.schoolregistrationsystem.data.StudentRepository;
import com.schoolregistrationsystem.dto.ResponseDto;
import com.schoolregistrationsystem.dto.StudentDto;
import com.schoolregistrationsystem.service.StudentService;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SchoolRegSystemApplication.class)
@AutoConfigureMockMvc
class StudentTest {
	
	@Mock
    private CourseRepository courseRepository;
	
	@Mock
    private StudentRepository studentRepository;
	
	@Autowired
	private StudentConverter studentConverter;

	@Autowired
    private StudentService studentService;
    
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
    	ResponseDto<List<StudentDto>> test2 = studentService.getAllStudents();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	formatter = formatter.withLocale(Locale.US);
    	LocalDate date = LocalDate.parse("2005-05-12", formatter);
    	
    	String str = "2021-07-26 10:00"; 
    	DateTimeFormatter formatterLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
    	LocalDateTime dateTime = LocalDateTime.parse(str, formatterLocalDateTime);
    	
    	StudentDto test = new StudentDto(null, null, "TTSSU15052005", "TestTest", "TestLastName", date, "Los Angeles", "USA");
    	test.setId((long) 1);
    	test.setCreated(dateTime);
        ResponseDto<StudentDto> found = studentService.createEntity(test);
     
         assertThat(found.getResponse().getName())
          .isEqualTo(test.getName());
     }

}


