package com.example.newtodoapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.newtodoapp.dto.todoDto.TodoRequestDto;
import com.example.newtodoapp.dto.todoDto.TodoResponseDto;
import com.example.newtodoapp.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;

	/*알정 생성*/
	@PostMapping("/save")
	public ResponseEntity<TodoResponseDto> saveTodo(@RequestBody TodoRequestDto dto) {

		TodoResponseDto todoResponseDto = todoService.saveTodo(dto);

		return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
	}

	/*전체 일정 조회*/
	@GetMapping
	public ResponseEntity<List<TodoResponseDto>> findAllTodo() {

		return new ResponseEntity<>(todoService.findAllTodo(), HttpStatus.OK);
	}

}
