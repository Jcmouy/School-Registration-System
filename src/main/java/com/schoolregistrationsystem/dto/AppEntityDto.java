package com.schoolregistrationsystem.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class AppEntityDto<T extends Serializable> {

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

}
