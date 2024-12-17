package com.example.newtodoapp.service;

import org.springframework.stereotype.Service;

import com.example.newtodoapp.dto.memberDto.MemberRequestDto;
import com.example.newtodoapp.dto.memberDto.MemberResponseDto;
import com.example.newtodoapp.entity.Member;
import com.example.newtodoapp.repository.MemberRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	@Override
	public MemberResponseDto signUp(MemberRequestDto dto) {

		Member member = new Member(dto.getName(), dto.getEmail(), dto.getPassword());

		Member savedMember = memberRepository.save(member);

		return new MemberResponseDto(
			savedMember.getId(),
			savedMember.getName(),
			savedMember.getEmail(),
			savedMember.getCreatedDate()
		);
	}
}
