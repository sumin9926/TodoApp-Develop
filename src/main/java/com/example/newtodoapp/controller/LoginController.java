package com.example.newtodoapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.newtodoapp.dto.LoginDto.LoginRequestDto;
import com.example.newtodoapp.entity.Member;
import com.example.newtodoapp.service.loginService.LoginService;
import com.example.newtodoapp.session.SessionConst;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<Void> login(@Validated @RequestBody LoginRequestDto dto, HttpServletRequest request){

		Member loginMember=loginService.login(dto.getEmail(), dto.getPassword());

		//로그인 성공 처리
		HttpSession session= request.getSession();
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
