package com.example.newtodoapp.service.todoService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.newtodoapp.dto.todoDto.SaveTodoRequestDto;
import com.example.newtodoapp.dto.todoDto.TodoResponseDto;
import com.example.newtodoapp.dto.todoDto.UpdateTodoRequestDto;
import com.example.newtodoapp.entity.Member;
import com.example.newtodoapp.entity.Todo;
import com.example.newtodoapp.repository.MemberRepository;
import com.example.newtodoapp.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final MemberRepository memberRepository;
	private final TodoRepository todoRepository;

	@Transactional
	public TodoResponseDto saveTodo(SaveTodoRequestDto dto) {

		Member member = memberRepository.findMemberByEmailOrElseThrow(dto.getEmail());

		Todo todo = new Todo(dto.getTitle(), dto.getContents());
		todo.setMember(member);

		Todo savedTodo = todoRepository.save(todo);

		return TodoResponseDto.mapToTodoDto(savedTodo);
	}

	@Transactional(readOnly = true)
	@Override
	public List<TodoResponseDto> findAllTodo() {

		return todoRepository.findAll().stream().map(TodoResponseDto::mapToTodoDto).toList();
	}

	@Transactional(readOnly = true)
	@Override
	public TodoResponseDto findTodoById(Long id) {

		Todo todo = todoRepository.findByIdOrElseThrow(id);

		return TodoResponseDto.mapToTodoDto(todo);
	}

	public void deleteTodo(Long id) {

		todoRepository.findByIdOrElseThrow(id);
		todoRepository.deleteById(id);
	}

	@Transactional
	@Override
	public TodoResponseDto putTodoById(Long id, UpdateTodoRequestDto dto) {

		Todo todo = todoRepository.findByIdOrElseThrow(id);

		todo.setContents(dto.getContents());
		todo.setTitle(dto.getTitle());

		return TodoResponseDto.mapToTodoDto(todo);
	}
}
