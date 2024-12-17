package com.example.newtodoapp.dto.memberDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequestDto {

	private final String name;

	private final String email;

	private final String password;

}