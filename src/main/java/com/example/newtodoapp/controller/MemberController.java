package com.example.newtodoapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newtodoapp.dto.memberDto.MemberRequestDto;
import com.example.newtodoapp.dto.memberDto.MemberResponseDto;
import com.example.newtodoapp.dto.memberDto.UpdateMemberRequestDto;
import com.example.newtodoapp.exceptionHandler.NoContentException;
import com.example.newtodoapp.service.memberService.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	/*회원 가입*/
	@PostMapping("/signup")
	public ResponseEntity<MemberResponseDto> signUp(@Validated @RequestBody MemberRequestDto dto) {

		MemberResponseDto memberResponseDto = memberService.signUp(dto);

		return new ResponseEntity<>(memberResponseDto, HttpStatus.CREATED);
	}

	/*전체 회원 조회*/
	@GetMapping
	public ResponseEntity<List<MemberResponseDto>> findAllMembers() {

		List<MemberResponseDto> memberResponseDtoList = memberService.findAllMembers();

		if (memberResponseDtoList.isEmpty()) {
			throw new NoContentException("No member content exists.");
		}

		return new ResponseEntity<>(memberResponseDtoList, HttpStatus.OK);
	}

	/*단일 회원 조회*/
	@GetMapping("/{id}")
	public ResponseEntity<MemberResponseDto> findMemberById(@PathVariable Long id) {

		MemberResponseDto memberResponseDto = memberService.findMemberById(id);

		return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
	}

	/*회원 수정*/
	@PatchMapping("/{id}")
	public ResponseEntity<MemberResponseDto> updateMemberById(
		@PathVariable Long id,
		@Validated @RequestBody UpdateMemberRequestDto dto) {

		return new ResponseEntity<>(memberService.updateMemberById(id, dto), HttpStatus.OK);
	}

	/*회원 삭제*/
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMember(@PathVariable Long id) {

		memberService.deleteMember(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
