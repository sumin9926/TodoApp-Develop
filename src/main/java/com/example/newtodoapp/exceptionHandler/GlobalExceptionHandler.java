package com.example.newtodoapp.exceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.newtodoapp.dto.exceptionDto.ExceptionResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<ExceptionResponseDto> noContentException(NoContentException e) {

		ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(e.getStatus(), e.getMessage());

		return new ResponseEntity<>(exceptionResponseDto, e.getStatus());
	}

	/*Validation 예외처리 메세지 반환*/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException e) {

		List<String> errorMessagesList = e.getBindingResult()
			.getAllErrors()
			.stream()
			.map(ObjectError::getDefaultMessage)
			.collect(Collectors.toList());

		ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
			e.getStatusCode(),
			"Validation failed",
			errorMessagesList);

		return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);
	}
}
