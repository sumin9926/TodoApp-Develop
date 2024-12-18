package com.example.newtodoapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newtodoapp.dto.todoDto.SaveTodoRequestDto;
import com.example.newtodoapp.dto.todoDto.TodoResponseDto;
import com.example.newtodoapp.dto.todoDto.UpdateTodoRequestDto;
import com.example.newtodoapp.service.todoService.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;

	/*알정 생성*/
	@PostMapping("/save")
	public ResponseEntity<TodoResponseDto> saveTodo(@RequestBody SaveTodoRequestDto dto) {

		TodoResponseDto todoResponseDto = todoService.saveTodo(dto);

		return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
	}

	/*전체 일정 조회*/
	@GetMapping
	public ResponseEntity<List<TodoResponseDto>> findAllTodo() {

		return new ResponseEntity<>(todoService.findAllTodo(), HttpStatus.OK);
	}

	/*특정 일정 조회*/
	@GetMapping("/{id}")
	public ResponseEntity<TodoResponseDto> findTodoById(@PathVariable Long id) {

		return new ResponseEntity<>(todoService.findTodoById(id), HttpStatus.OK);
	}

	/*일정 수정*/
	@PutMapping("/{id}")
	public ResponseEntity<TodoResponseDto> putTodoById(@PathVariable Long id, @RequestBody UpdateTodoRequestDto dto){

		return new ResponseEntity<>(todoService.putTodoById(id,dto),HttpStatus.OK);
	}

	/*일정 삭제*/
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
