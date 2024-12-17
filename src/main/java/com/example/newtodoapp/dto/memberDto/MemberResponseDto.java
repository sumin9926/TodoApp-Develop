package com.example.newtodoapp.dto.memberDto;

import java.time.LocalDateTime;

import com.example.newtodoapp.entity.Member;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponseDto {

	private final Long id;

	private final String name;

	private final String email;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime createdDate;

	public static MemberResponseDto mapToMemberDto(Member member){
		return new MemberResponseDto(
			member.getId(),
			member.getName(),
			member.getEmail(),
			member.getCreatedDate()
		);
	}
}
