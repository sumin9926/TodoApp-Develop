package com.example.newtodoapp.dto.memberDto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateMemberRequestDto {

	@Size(max = 10, message = "Name cannot exceed 10 characters.")
	private final String name;

	@Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])+[.][a-zA-Z]{2,3}$", message = "Please check the email address format.")
	private final String email;

	private final String password;
}
