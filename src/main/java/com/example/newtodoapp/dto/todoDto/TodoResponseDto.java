package com.example.newtodoapp.dto.todoDto;

import java.time.LocalDateTime;

import com.example.newtodoapp.entity.Member;
import com.example.newtodoapp.entity.Todo;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoResponseDto {

	private final Long id;

	private final String name;

	private final String title;

	private final String contents;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime createdDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime updatedDate;

	public static TodoResponseDto mapToTodoDto(Todo todo) {
		return new TodoResponseDto(
			todo.getId(),
			todo.getMember().getName(),
			todo.getTitle(),
			todo.getContents(),
			todo.getCreatedDate(),
			todo.getUpdatedDate()
		);
	}
}
