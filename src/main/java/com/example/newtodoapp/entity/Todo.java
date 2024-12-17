package com.example.newtodoapp.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "todo")
public class Todo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(length = 200)
	private String contents;

	@LastModifiedDate
	private LocalDateTime updatedDate;

	@Setter
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	public Todo() {}

	public Todo(String title, String contents){
		this.title=title;
		this.contents=contents;
	}

}
