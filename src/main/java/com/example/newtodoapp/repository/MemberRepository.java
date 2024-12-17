package com.example.newtodoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newtodoapp.entity.Member;
import com.example.newtodoapp.exceptionHandler.NoContentException;

public interface MemberRepository extends JpaRepository<Member, Long> {

	default Member findMemberByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(() -> new NoContentException("Dose not exist id: " + id));
	}
}
