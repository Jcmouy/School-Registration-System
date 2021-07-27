package com.schoolregistrationsystem.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.schoolregistrationsystem.domain.Course;
import com.schoolregistrationsystem.domain.Student;
import com.schoolregistrationsystem.domain.StudentCourse;

@Repository
public interface StudentCourseRepository extends AppEntityRepository<StudentCourse> {

}
