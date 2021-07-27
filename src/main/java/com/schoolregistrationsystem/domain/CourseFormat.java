package com.schoolregistrationsystem.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "course_format", uniqueConstraints = @UniqueConstraint(columnNames = { "course_id", "format_id" }))
public class CourseFormat extends AppEntity<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "format_id", nullable = false)
	private Format format;

	public CourseFormat() {
		super();
	}

	public CourseFormat(Course course, Format format) {
		super();
		this.course = course;
		this.format = format;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(course, format);
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
		if (!(obj instanceof CourseFormat)) {
			return false;
		}
		CourseFormat other = (CourseFormat) obj;
		return Objects.equals(course, other.course) && Objects.equals(format, other.format);
	}

}
