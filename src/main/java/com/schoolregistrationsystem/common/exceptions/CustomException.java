package com.schoolregistrationsystem.common.exceptions;

import com.schoolregistrationsystem.common.enums.Messages;

public class CustomException extends AbstractException {

	private static final long serialVersionUID = -6673350939140529594L;
	private static final Integer SERVER_HTTP_STATUS_CODE = 500;

	public CustomException(Messages errorMessage) {
		super(SERVER_HTTP_STATUS_CODE);
		this.getErrorsDetail().add(new MessageDetail(errorMessage));
	}

	public CustomException(Integer httpStatusCode, Messages errorMessage) {
		super(httpStatusCode);
		this.getErrorsDetail().add(new MessageDetail(errorMessage));
	}

	public CustomException(Integer httpStatusCode, Messages errorMessage, String... arg1) {
		super(httpStatusCode);
		this.getErrorsDetail().add(new MessageDetail(errorMessage, arg1));
	}

	public CustomException(MessageDetail errorDetail, Integer statusCode) {
		super(statusCode);
		this.getErrorsDetail().add(errorDetail);
	}

	public CustomException(MessageDetail errorDetail) {
		super(SERVER_HTTP_STATUS_CODE);
		this.getErrorsDetail().add(errorDetail);
	}

}
