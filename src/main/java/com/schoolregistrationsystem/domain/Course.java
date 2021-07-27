package com.schoolregistrationsystem.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.schoolregistrationsystem.constants.GeneralConstants;

@Entity
@Table(name = "course", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class Course extends AppEntity<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	@NotNull(message = "{name.required}")
	private String name;

	@Column(name = "date_start")
	@NotNull(message = "{startdate.required}")
	@DateTimeFormat(pattern = GeneralConstants.DEFAULT_DATE_FORMAT)
	private LocalDate dateStart;

	@Column(name = "date_end")
	@NotNull(message = "{enddate.required}")
	@DateTimeFormat(pattern = GeneralConstants.DEFAULT_DATE_FORMAT)
	private LocalDate dateEnd;

	@ManyToMany(targetEntity = Student.class, cascade = CascadeType.PERSIST)
	@JoinTable(name = "student_course", joinColumns = {
			@JoinColumn(name = "course_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "student_id", referencedColumnName = "id") })
	private Set<Student> students = new HashSet<>();

	@ManyToMany(targetEntity = Format.class)
	@NotNull(message = "{course.format.minlength}")
	@JoinTable(name = "course_format", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "format_id") })
	private Set<Format> formats = new HashSet<>();

	public Course() {
		super();
	}

	public Course(Long id) {
		super();
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateStart() {
		return dateStart;
	}

	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Format> getFormats() {
		return formats;
	}

	public void setFormats(Set<Format> formats) {
		this.formats = formats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
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
		Course other = (Course) obj;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
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
		return "Course [name=" + name + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", students=" + students
				+ ", formats=" + formats + "]";
	}

}
