package com.schoolregistrationsystem.converter;

import org.springframework.stereotype.Service;

import com.schoolregistrationsystem.domain.Format;
import com.schoolregistrationsystem.dto.FormatDto;

@Service
public class FormatConverter extends AppEntityConverter<Format, FormatDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
