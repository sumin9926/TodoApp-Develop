package com.example.newtodoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newtodoapp.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
