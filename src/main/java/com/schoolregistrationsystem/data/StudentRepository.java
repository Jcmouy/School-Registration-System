package com.schoolregistrationsystem.data;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.schoolregistrationsystem.domain.Course;
import com.schoolregistrationsystem.domain.Student;

@Repository
public interface StudentRepository extends AppEntityRepository<Student> {

	boolean existsByCode(String code);

	Optional<Student> findStudentByNameAndLastName(String studentname, String studentLastName);

	Optional<Student> findStudentByCode(String code);
	
    List<Student> findStudentsByCourses_Name(String coursename);

	List<Student> findByCoursesIsEmpty();

}
