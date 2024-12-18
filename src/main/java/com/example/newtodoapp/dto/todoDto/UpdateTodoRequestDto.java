package com.example.newtodoapp.dto.todoDto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateTodoRequestDto {

	@Size(max = 50, message = "Please keep the title within 50 characters.")
	private final String title;

	@Size(max = 200, message = "Please keep the contents within 200 characters.")
	private final String contents;
}
