package com.schoolregistrationsystem.common.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat
public enum CommonMessagesImpl implements Messages {

	/* GENERAL_ERROR 0 a 999 */
	DEFAULT_MESSAGE(1, "An unexpected error has happened"),
	ENTITY_NOT_FOUND(2, "An error occurred when obtaining the database entity"),
	ERROR_ENTITY_EXISTS(3, "The entity is already inserted in the system."),
	ERROR_ENTITY_SAVE(4, "An error occurred while saving the database entity"),
	SUCCESS_ENTITY_OPERATION(6003, "Successful operation"),
	
	/* STUDENT_ERROR 50 a 100 */
	ERROR_STUDENT_MAX_COURSES(50, "This students is not allowed to register in more courses."),
	
	/* COURSE_ERROR 150 a 200 */
	ERROR_COURSES_MAX_STUDENTS(150, "No more students are allowed in this course."),
	ERROR_COURSES_STUDENT_REGISTERED(151, "Student already registered in this course.");

	protected int code;
	protected String message;

	CommonMessagesImpl(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	@JsonValue
	public String getMessage() {
		return message;
	}

	public static Messages getByValue(int code) {
		return Arrays.asList(values()).stream().filter(message -> code == message.getCode()).findAny().orElse(null);
	}
}
