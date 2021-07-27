package com.schoolregistrationsystem.common.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.schoolregistrationsystem.common.enums.Messages;

public class MessageDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("message")
	private String message;

	@JsonProperty("code")
	private Integer code;

	@JsonProperty("stackTrace")
	private String stackTrace;

	@JsonProperty("errors")
	private List<String> errors = new ArrayList<>();

	protected MessageDetail(String stackTrace, Messages errorMessage) {
		super();
		if (errorMessage != null) {
			this.message = errorMessage.getMessage();
			this.code = errorMessage.getCode();
		}
		this.stackTrace = stackTrace;

	}

	public MessageDetail(Messages message, String customMessage) {
		super();
		if (message != null) {
			this.message = message.getMessage();
			this.code = message.getCode();
			if (!customMessage.isEmpty())
				this.message = this.message + " - " + customMessage;
		}
	}

	public MessageDetail(Messages message, List<String> customMessages) {
		super();
		if (message != null) {
			this.message = message.getMessage();
			this.code = message.getCode();
			this.errors = customMessages;
		}
	}

	public MessageDetail(Messages message, String... arg1) {
		super();
		if (message != null) {
			this.message = String.format(message.getMessage(), arg1);
			this.code = message.getCode();
		}
	}

	public MessageDetail(Messages message) {
		super();
		if (message != null) {
			this.message = message.getMessage();
			this.code = message.getCode();
		}
	}

	public MessageDetail(String message, Integer code, String stackTrace) {
		super();
		this.message = message;
		this.code = code;
		this.stackTrace = stackTrace;
	}

	public String getMessage() {
		return this.message;
	}

	public Integer getCode() {
		return code;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setMessage(String errorMessage) {
		this.message = errorMessage;
	}

	public void setCode(Integer errorCode) {
		this.code = errorCode;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public MessageDetail() {

	}

}
