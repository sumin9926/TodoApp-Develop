package com.example.newtodoapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@Column(nullable = false)
	private String name;

	@Setter
	@Column(nullable = false, unique = true)
	private String email;

	@Setter
	@Column(nullable = false)
	private String password;

	public Member() {}

	public Member(String name, String email, String password){
		this.name=name;
		this.email=email;
		this.password=password;
	}
}
