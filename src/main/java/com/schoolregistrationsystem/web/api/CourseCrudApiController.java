package com.schoolregistrationsystem.web.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolregistrationsystem.dto.CourseDto;
import com.schoolregistrationsystem.dto.ResponseDto;
import com.schoolregistrationsystem.dto.StudentDto;
import com.schoolregistrationsystem.service.AppEntityService;
import com.schoolregistrationsystem.service.CourseService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/courses", produces = "application/json")
@CrossOrigin(origins = "*")
public class CourseCrudApiController extends AppEntityController<CourseDto> {

	@Autowired
	CourseService courseService;

	@Override
	protected AppEntityService<? extends Serializable, CourseDto> getService() {
		return courseService;
	}
	
	@ApiOperation(value = "Get course by name", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/name/{courseName}", produces = "application/json")
	public ResponseEntity<ResponseDto<CourseDto>> getCourseByName(@PathVariable("courseName") String courseName) {
		return new ResponseEntity<>(courseService.getByName(courseName), HttpStatus.OK);
	}

	@ApiOperation(value = "Gets all courses", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(produces = "application/json")
	public ResponseEntity<ResponseDto<List<CourseDto>>> getAllCourses() {
		return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Count students per course", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/count/{name}", produces = "application/json")
	public ResponseEntity<ResponseDto<Long>> getNumberStudentsPerCourse(@PathVariable("name") String courseName) {
		return new ResponseEntity<>(courseService.countStudentsByCourse(courseName), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Course", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK") })
	@DeleteMapping("/{courseId}")
	public ResponseEntity<ResponseDto<CourseDto>> deleteCourse(@PathVariable("courseId") Long courseId) {
		boolean isRemoved = courseService.deleteById(courseId) != null;
		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
