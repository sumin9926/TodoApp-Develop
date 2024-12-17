package com.example.newtodoapp.service;

import com.example.newtodoapp.dto.memberDto.MemberRequestDto;
import com.example.newtodoapp.dto.memberDto.MemberResponseDto;

public interface MemberService {
	MemberResponseDto signUp(MemberRequestDto dto);
	MemberResponseDto findAllMembers();

}
