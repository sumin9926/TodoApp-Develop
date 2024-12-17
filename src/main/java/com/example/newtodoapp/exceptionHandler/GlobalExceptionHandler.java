package com.example.newtodoapp.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.newtodoapp.dto.exceptionDto.ExceptionResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<ExceptionResponseDto> noContentException(NoContentException e) {

		ExceptionResponseDto exceptionResponseDto=new ExceptionResponseDto(e.getStatus(), e.getMessage());

		return new ResponseEntity<>(exceptionResponseDto, e.getStatus());
	}
}
