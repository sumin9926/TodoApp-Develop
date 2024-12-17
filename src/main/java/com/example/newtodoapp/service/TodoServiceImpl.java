package com.example.newtodoapp.service;

import org.springframework.stereotype.Service;

import com.example.newtodoapp.dto.todoDto.TodoRequestDto;
import com.example.newtodoapp.dto.todoDto.TodoResponseDto;
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

	public TodoResponseDto saveTodo(TodoRequestDto dto) {

		Member member = memberRepository.findMemberByEmailOrElseThrow(dto.getEmail());

		Todo todo = new Todo(dto.getTitle(), dto.getContents());
		todo.setMember(member);

		Todo savedTodo = todoRepository.save(todo);
		return new TodoResponseDto(
			savedTodo.getId(),
			member.getName(),
			savedTodo.getTitle(),
			savedTodo.getContents(),
			savedTodo.getCreatedDate(),
			savedTodo.getUpdatedDate()
		);
	}
}
