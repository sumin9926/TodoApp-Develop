package com.example.newtodoapp.dto.todoDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveTodoRequestDto {

	private final String name;

	private final String title;

	private final String contents;

	private final String email;

}
