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

import com.schoolregistrationsystem.dto.ResponseDto;
import com.schoolregistrationsystem.dto.StudentDto;
import com.schoolregistrationsystem.service.AppEntityService;
import com.schoolregistrationsystem.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/students", produces = "application/json")
@CrossOrigin(origins = "*")
public class StudentCrudApiController extends AppEntityController<StudentDto> {

	@Autowired
	StudentService studentService;

	@Override
	protected AppEntityService<? extends Serializable, StudentDto> getService() {
		return studentService;
	}

	@ApiOperation(value = "Get student by name and lastName", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/completeName/{name}/{lastName}", produces = "application/json")
	public ResponseEntity<ResponseDto<StudentDto>> getStudentByNameLastName(@PathVariable("name") String name,
			@PathVariable("lastName") String lastName) {
		return new ResponseEntity<>(studentService.getByNameLastName(name, lastName), HttpStatus.OK);
	}

	@ApiOperation(value = "Get student by code", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/code/{code}", produces = "application/json")
	public ResponseEntity<ResponseDto<StudentDto>> getStudentByCode(@PathVariable("code") String code) {
		return new ResponseEntity<>(studentService.getByCode(code), HttpStatus.OK);
	}

	@ApiOperation(value = "Gets all students", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(produces = "application/json")
	public ResponseEntity<ResponseDto<List<StudentDto>>> getAllStudents() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Student", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK") })
	@DeleteMapping("/{studentId}")
	public ResponseEntity<ResponseDto<StudentDto>> deleteStudent(@PathVariable("studentId") Long studentId) {
		boolean isRemoved = studentService.deleteById(studentId) != null;
		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
