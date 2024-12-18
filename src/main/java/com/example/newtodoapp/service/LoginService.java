package com.example.newtodoapp.service;

import com.example.newtodoapp.entity.Member;

public interface LoginService {
	Member login(String email, String password);
}
