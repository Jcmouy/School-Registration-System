package com.schoolregistrationsystem.dto;

import java.io.Serializable;

public class UserDto extends AppEntityDto<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String username;

	private final String password;

	public UserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", id=" + id + "]";
	}

}
