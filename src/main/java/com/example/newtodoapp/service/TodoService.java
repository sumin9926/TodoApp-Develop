package com.example.newtodoapp.service;

import java.util.List;

import com.example.newtodoapp.dto.todoDto.TodoRequestDto;
import com.example.newtodoapp.dto.todoDto.TodoResponseDto;

public interface TodoService {

	TodoResponseDto saveTodo(TodoRequestDto dto);

	List<TodoResponseDto> findAllTodo();
}
