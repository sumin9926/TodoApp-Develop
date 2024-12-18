package com.example.newtodoapp.service.todoService;

import java.util.List;

import com.example.newtodoapp.dto.todoDto.SaveTodoRequestDto;
import com.example.newtodoapp.dto.todoDto.TodoResponseDto;
import com.example.newtodoapp.dto.todoDto.UpdateTodoRequestDto;
import com.example.newtodoapp.entity.Todo;

public interface TodoService {

	TodoResponseDto saveTodo(SaveTodoRequestDto dto);

	List<TodoResponseDto> findAllTodo();

	TodoResponseDto findTodoById(Long id);

	void deleteTodo(Long id);

	TodoResponseDto putTodoById(Long id, UpdateTodoRequestDto dto);

	List<Todo> findTodoByMemberId(Long id);

}
