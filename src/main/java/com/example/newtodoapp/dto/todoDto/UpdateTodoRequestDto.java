package com.example.newtodoapp.dto.todoDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateTodoRequestDto {

	private final String title;

	private final String contents;
}
