package com.example.newtodoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newtodoapp.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
