package com.schoolregistrationsystem.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@MappedSuperclass
public abstract class AppEntity<T extends Serializable> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@GenericGenerator(name = "sequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY, value = "true"),
			@Parameter(name = SequenceStyleGenerator.OPT_PARAM, value = "pooled"),
			@Parameter(name = SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, value = "_ID_SEQ") })
	@Column(name = "id", unique = true, nullable = false)
	@Type(type = "long")
	protected T id;

	private LocalDateTime created;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@PrePersist
	void created() {
		this.created = LocalDateTime.now();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof AppEntity<?>))
			return false;
		AppEntity<T> entidad = (AppEntity<T>) obj;
		return Objects.equals(getId(), entidad.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).toHashCode();
	}

}
