package com.example.newtodoapp.dto.exceptionDto;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponseDto {

	private HttpStatusCode status;

	private String message;

}
