package com.example.newtodoapp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.newtodoapp.encoder.PasswordEncoder;
import com.example.newtodoapp.entity.Member;
import com.example.newtodoapp.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public Member login(String email, String password) {

		Member member=memberRepository.findMemberByEmailOrElseThrow(email);

		//비밀번호 불일치
		if(!passwordEncoder.matches(password,member.getPassword())){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Wrong password.");
		}

		return member;
	}
}
