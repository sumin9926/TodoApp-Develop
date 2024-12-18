package com.example.newtodoapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.newtodoapp.entity.Member;
import com.example.newtodoapp.exceptionHandler.NoContentException;

public interface MemberRepository extends JpaRepository<Member, Long> {

	default Member findMemberByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(() -> new NoContentException("Dose not exist id: " + id));
	}

	default Member findMemberByEmailOrElseThrow(String email) {
		return findMemberByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,
			"Dose not exist email: " + email));
	}

	Optional<Member> findMemberByEmail(String email);
}
