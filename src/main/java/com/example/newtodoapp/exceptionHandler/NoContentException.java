package com.example.newtodoapp.exceptionHandler;

import org.springframework.http.HttpStatus;

public class NoContentException extends RuntimeException {

	public NoContentException(String message) {
		super(message);
	}

	public HttpStatus getStatus() {
		return HttpStatus.OK;
	}
}
