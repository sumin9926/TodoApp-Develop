package com.example.newtodoapp.service.todoService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.newtodoapp.dto.todoDto.SaveTodoRequestDto;
import com.example.newtodoapp.dto.todoDto.TodoResponseDto;
import com.example.newtodoapp.dto.todoDto.UpdateTodoRequestDto;
import com.example.newtodoapp.entity.Member;
import com.example.newtodoapp.entity.Todo;
import com.example.newtodoapp.repository.MemberRepository;
import com.example.newtodoapp.repository.TodoRepository;

import jakarta.transaction.Transactional;
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
		return new TodoResponseDto(
			savedTodo.getId(),
			member.getName(),
			savedTodo.getTitle(),
			savedTodo.getContents(),
			savedTodo.getCreatedDate(),
			savedTodo.getUpdatedDate()
		);
	}

	@Override
	public List<TodoResponseDto> findAllTodo() {

		return todoRepository.findAll().stream().map(TodoResponseDto::mapToTodoDto).toList();
	}

	@Override
	public TodoResponseDto findTodoById(Long id) {

		Todo todo = todoRepository.findByIdOrElseThrow(id);

		return new TodoResponseDto(
			todo.getId(),
			todo.getMember().getName(),
			todo.getTitle(),
			todo.getContents(),
			todo.getCreatedDate(),
			todo.getUpdatedDate()
		);
	}

	@Override
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

		return new TodoResponseDto(
			todo.getId(),
			todo.getMember().getName(),
			todo.getTitle(),
			todo.getContents(),
			todo.getCreatedDate(),
			todo.getUpdatedDate()
		);
	}

	@Override
	public List<Todo> findTodoByMemberId(Long id) {
		return todoRepository.findByMember_Id(id);
	}
}
