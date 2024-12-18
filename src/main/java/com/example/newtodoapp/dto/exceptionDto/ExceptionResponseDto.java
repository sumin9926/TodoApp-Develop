package com.example.newtodoapp.dto.exceptionDto;

import java.util.List;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponseDto {

	private HttpStatusCode status;

	private String message;

	private List<String> errorMessageList;

	public ExceptionResponseDto(HttpStatusCode status, String message) {
		this.message = message;
		this.status = status;
	}

}
