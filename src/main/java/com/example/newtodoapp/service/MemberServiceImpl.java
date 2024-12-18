package com.example.newtodoapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.newtodoapp.dto.memberDto.MemberRequestDto;
import com.example.newtodoapp.dto.memberDto.MemberResponseDto;
import com.example.newtodoapp.entity.Member;
import com.example.newtodoapp.entity.Todo;
import com.example.newtodoapp.repository.MemberRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	private final TodoService todoService;

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

	@Override
	public List<MemberResponseDto> findAllMembers() {

		return memberRepository.findAll()
			.stream()
			.map(MemberResponseDto::mapToMemberDto)
			.toList();
	}

	@Override
	public MemberResponseDto findMemberById(Long id) {

		Member member = memberRepository.findMemberByIdOrElseThrow(id);

		return new MemberResponseDto(
			member.getId(),
			member.getName(),
			member.getEmail(),
			member.getCreatedDate()
		);
	}

	@Override
	public void deleteMember(Long id) {

		Member member=memberRepository.findMemberByIdOrElseThrow(id);
		List<Todo> findTodo=todoService.findTodoByMemberId(id);

		for(Todo todo:findTodo){ //회원 삭제 전 회원이 생성한 모든 일정 삭제
			todoService.deleteTodo(todo.getId());
		}

		memberRepository.delete(member);
	}

	@Override
	public MemberResponseDto updateMemberById(Long id, MemberRequestDto dto) {
		return null;
	}
}
