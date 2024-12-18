package com.example.newtodoapp.service.memberService;

import java.util.List;

import com.example.newtodoapp.dto.memberDto.MemberRequestDto;
import com.example.newtodoapp.dto.memberDto.MemberResponseDto;

public interface MemberService {

	MemberResponseDto signUp(MemberRequestDto dto);

	List<MemberResponseDto> findAllMembers();

	MemberResponseDto findMemberById(Long id);

	void deleteMember(Long id);

	MemberResponseDto updateMemberById(Long id, MemberRequestDto dto);

}
