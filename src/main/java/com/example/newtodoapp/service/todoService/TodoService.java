package com.example.newtodoapp.service.todoService;

import java.util.List;

import com.example.newtodoapp.dto.todoDto.SaveTodoRequestDto;
import com.example.newtodoapp.dto.todoDto.TodoResponseDto;
import com.example.newtodoapp.dto.todoDto.UpdateTodoRequestDto;

public interface TodoService {

	TodoResponseDto saveTodo(SaveTodoRequestDto dto);

	List<TodoResponseDto> findAllTodo();

	TodoResponseDto findTodoById(Long id);

	TodoResponseDto putTodoById(Long id, UpdateTodoRequestDto dto);
}
