package com.schoolregistrationsystem.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.schoolregistrationsystem.constants.GeneralConstants;

@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class Student extends AppEntity<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	@NotNull(message = "{student.code.required}")
	private String code;

	@Column(name = "name")
	@NotNull(message = "{name.required}")
	private String name;

	@Column(name = "last_name")
	@NotNull(message = "{student.lastname.required}")
	private String lastName;

	@Column(name = "date_birth")
	@NotNull(message = "{student.birthdate.required}")
	@DateTimeFormat(pattern = GeneralConstants.DEFAULT_DATE_FORMAT)
	private LocalDate dateBirth;

	@Column(name = "city")
	@NotNull(message = "{student.city.required}")
	private String city;

	@Column(name = "country")
	@NotNull(message = "{student.country.required}")
	private String country;

	@ManyToMany(mappedBy = "students")
	private Set<Course> courses = new HashSet<>();

	public Student() {
		super();
	}

	public Student(String code, String name, String lastName, LocalDate dateBirth, String city, String country,
			Set<Course> courses) {
		super();
		this.code = code;
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.city = city;
		this.country = country;
		this.courses = courses;
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dateBirth == null) ? 0 : dateBirth.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (dateBirth == null) {
			if (other.dateBirth != null)
				return false;
		} else if (!dateBirth.equals(other.dateBirth))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + ", lastName=" + lastName + ", dateBirth=" + dateBirth
				+ ", city=" + city + ", country=" + country + ", courses=" + courses + "]";
	}

}
