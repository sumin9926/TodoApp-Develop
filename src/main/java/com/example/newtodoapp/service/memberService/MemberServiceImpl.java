package com.example.newtodoapp.service.memberService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.newtodoapp.dto.memberDto.MemberRequestDto;
import com.example.newtodoapp.dto.memberDto.MemberResponseDto;
import com.example.newtodoapp.dto.memberDto.UpdateMemberRequestDto;
import com.example.newtodoapp.encoder.PasswordEncoder;
import com.example.newtodoapp.entity.Member;
import com.example.newtodoapp.repository.MemberRepository;
import com.example.newtodoapp.service.todoService.TodoService;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	private final TodoService todoService;
	private final PasswordEncoder passwordEncoder;

	@Override
	public MemberResponseDto signUp(MemberRequestDto dto) {

		String encodedPassword = passwordEncoder.encode(dto.getPassword());

		Member member = new Member(dto.getName(), dto.getEmail(), encodedPassword);
		Member savedMember = memberRepository.save(member);

		return MemberResponseDto.mapToMemberDto(member);
	}

	@Transactional(readOnly = true)
	@Override
	public List<MemberResponseDto> findAllMembers() {

		return memberRepository.findAll()
			.stream()
			.map(MemberResponseDto::mapToMemberDto)
			.toList();
	}

	@Transactional(readOnly = true)
	@Override
	public MemberResponseDto findMemberById(Long id) {

		Member member = memberRepository.findMemberByIdOrElseThrow(id);

		return MemberResponseDto.mapToMemberDto(member);
	}

	@Override
	public void deleteMember(Long id) {

		Member member = memberRepository.findMemberByIdOrElseThrow(id);

		memberRepository.delete(member);
	}

	@Transactional
	@Override
	public MemberResponseDto updateMemberById(Long id, UpdateMemberRequestDto dto) {

		Member member = memberRepository.findMemberByIdOrElseThrow(id);

		updateMemberInfo(dto, member);

		return MemberResponseDto.mapToMemberDto(member);
	}

	private void updateMemberInfo(UpdateMemberRequestDto dto, Member member) {
		Optional.ofNullable(dto.getName()).ifPresent(member::setName); //이름 수정
		Optional.ofNullable(dto.getEmail()).ifPresent(member::setEmail); //이메일 수정
		Optional.ofNullable(dto.getPassword()).ifPresent(password -> { //비밀번호 수정
			String encodedPassword = passwordEncoder.encode(password);
			member.setPassword(encodedPassword);
		});
	}
}
