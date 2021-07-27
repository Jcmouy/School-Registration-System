package com.schoolregistrationsystem.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.schoolregistrationsystem.common.enums.ResultResponse;
import com.schoolregistrationsystem.common.exceptions.MessageDetail;

public class ResponseDto<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private T response;
	private ResultResponse result;
	private List<MessageDetail> messages;
	private Long total;

	public ResponseDto() {
		super();
		this.result = ResultResponse.OK;
		this.messages = new ArrayList<>();
		this.total = Long.valueOf(0);
	}

	public ResponseDto(T response) {
		super();
		this.response = response;
		this.result = ResultResponse.OK;
		this.messages = new ArrayList<>();
		this.total = Long.valueOf(0);

	}

	public ResponseDto(T response, Long total) {
		super();
		this.response = response;
		this.total = total;
		this.result = ResultResponse.OK;
		this.messages = new ArrayList<>();

	}

	public ResponseDto(T response, ResultResponse result, List<MessageDetail> messages) {
		super();
		this.response = response;
		this.result = result;
		this.messages = messages;
		this.total = Long.valueOf(0);
	}

	public ResponseDto(ResultResponse result, List<MessageDetail> messages) {
		super();
		this.result = result;
		this.messages = messages;
		this.total = Long.valueOf(0);
	}

	public ResponseDto(T response, List<MessageDetail> messages) {
		super();
		this.response = response;
		this.result = ResultResponse.OK;
		this.messages = messages;
		this.total = Long.valueOf(0);
	}

	public T getResponse() {
		return response;
	}

	public void setRespuesta(T response) {
		this.response = response;
	}

	public ResultResponse getResult() {
		return result;
	}

	public void setResult(ResultResponse result) {
		this.result = result;
	}

	public List<MessageDetail> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageDetail> messages) {
		this.messages = messages;
	}

	public void addMessage(MessageDetail message) {
		this.messages.add(message);
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ResponseDto [response=" + response + ", result=" + result + ", messages=" + messages
				+ ", totalItemsResponse=" + total + "]";
	}
}
