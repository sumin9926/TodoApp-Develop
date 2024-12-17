package com.example.newtodoapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newtodoapp.dto.memberDto.MemberRequestDto;
import com.example.newtodoapp.dto.memberDto.MemberResponseDto;
import com.example.newtodoapp.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	/*회원 가입*/
	@PostMapping
	public ResponseEntity<MemberResponseDto> signUp(@RequestBody MemberRequestDto dto){

		MemberResponseDto memberResponseDto=memberService.signUp(dto);

		return new ResponseEntity<>(memberResponseDto, HttpStatus.CREATED);
	}

	/*전체 회원 조회*/
	@GetMapping
	public ResponseEntity<MemberResponseDto> findAllMembers(){

	}
}