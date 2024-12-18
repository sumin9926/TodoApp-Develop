package com.example.newtodoapp.dto.todoDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveTodoRequestDto {

	@NotBlank
	private final String name;

	@NotBlank
	@Size(max = 50, message = "Please keep the title within 50 characters.")
	private final String title;

	@NotBlank
	@Size(max = 200, message = "Please keep the contents within 200 characters.")
	private final String contents;

	@NotBlank
	@Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])+[.][a-zA-Z]{2,3}$", message = "Please check the email address format.")
	private final String email;

}
