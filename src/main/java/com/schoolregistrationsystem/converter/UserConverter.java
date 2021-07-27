package com.schoolregistrationsystem.converter;

import org.springframework.stereotype.Service;

import com.schoolregistrationsystem.domain.User;
import com.schoolregistrationsystem.dto.UserDto;

@Service
public class UserConverter extends AppEntityConverter<User, UserDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
