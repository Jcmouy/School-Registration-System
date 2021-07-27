package com.schoolregistrationsystem.dto;

import java.util.Objects;

import com.schoolregistrationsystem.common.dto.EntityDto;
import com.schoolregistrationsystem.enums.FormatPeriod;
import com.schoolregistrationsystem.enums.FormatType;

import io.swagger.annotations.ApiModelProperty;

public class FormatDto extends EntityDto {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(allowableValues = "SEMESTRAL, ANUAL")
	private FormatPeriod period;
	@ApiModelProperty(allowableValues = "BLENDED, ONLINE, PRESENTIAL")
	private FormatType type;

	public FormatPeriod getPeriod() {
		return period;
	}

	public void setPeriod(FormatPeriod period) {
		this.period = period;
	}

	public FormatType getType() {
		return type;
	}

	public void setType(FormatType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(period, type);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof FormatDto)) {
			return false;
		}
		FormatDto other = (FormatDto) obj;
		return period == other.period && type == other.type;
	}

}
