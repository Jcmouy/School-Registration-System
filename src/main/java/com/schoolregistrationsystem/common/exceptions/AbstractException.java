package com.schoolregistrationsystem.common.exceptions;

import java.util.ArrayList;
import java.util.List;

public class AbstractException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private List<MessageDetail> errorsDetail;
	private Integer httpStatusCode;

	public AbstractException(Integer httpStatusCode) {
		this.errorsDetail = new ArrayList<>();
		this.httpStatusCode = httpStatusCode;
	}

	public List<MessageDetail> getErrorsDetail() {
		return errorsDetail;
	}

	public void setErrorsDetail(List<MessageDetail> errorsDetail) {
		this.errorsDetail = errorsDetail;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
}
