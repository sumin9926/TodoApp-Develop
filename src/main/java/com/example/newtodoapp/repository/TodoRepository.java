package com.example.newtodoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newtodoapp.dto.todoDto.TodoResponseDto;
import com.example.newtodoapp.entity.Todo;
import com.example.newtodoapp.exceptionHandler.NoContentException;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	default Todo findByIdOrElseThrow(Long id) {

		return findById(id)
			.orElseThrow(() -> new NoContentException("No content exists."));
	}

	List<Todo> findByMember_Id(Long id);
}
