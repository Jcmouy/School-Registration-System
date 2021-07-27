package com.schoolregistrationsystem.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.schoolregistrationsystem.enums.FormatPeriod;
import com.schoolregistrationsystem.enums.FormatType;

@Entity
@Table(name = "format")
public class Format extends AppEntity<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "period", nullable = false)
	@Enumerated(EnumType.STRING)
	private FormatPeriod period;

	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private FormatType type;

	public FormatPeriod getFormatPeriod() {
		return period;
	}

	public void setFormatPeriod(FormatPeriod period) {
		this.period = period;
	}

	public FormatType getFormatType() {
		return type;
	}

	public void setFormatType(FormatType type) {
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
		if (!(obj instanceof Format)) {
			return false;
		}
		Format other = (Format) obj;
		return period == other.period && type == other.type;
	}

}
