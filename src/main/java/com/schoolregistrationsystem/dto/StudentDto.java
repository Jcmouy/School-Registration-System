package com.schoolregistrationsystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.schoolregistrationsystem.common.dto.EntityDto;

public class StudentDto extends EntityDto {

	private static final long serialVersionUID = 1L;

	private String code;

	private String name;

	private String lastName;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dateBirth;

	private String city;

	private String country;
	
	public StudentDto() {
		super();
	}

	public StudentDto(Long id, LocalDateTime created) {
		super(id, created);
	}


	public StudentDto(Long id, LocalDateTime created, String code, String name, String lastName, LocalDate dateBirth, String city,
			String country) {
		super(id, created);
		this.code = code;
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.city = city;
		this.country = country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(city, code, country, dateBirth, lastName, name);
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
		if (!(obj instanceof StudentDto)) {
			return false;
		}
		StudentDto other = (StudentDto) obj;
		return Objects.equals(city, other.city) && Objects.equals(code, other.code)
				&& Objects.equals(country, other.country) && Objects.equals(dateBirth, other.dateBirth)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name);
	}

}
