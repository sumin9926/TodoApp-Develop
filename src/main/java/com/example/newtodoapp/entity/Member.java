package com.example.newtodoapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "member", uniqueConstraints = {
	@UniqueConstraint(name = "UniqueMemberEmail", columnNames = {"email"})})
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@Column(nullable = false)
	private String name;

	@Setter
	@Column(nullable = false)
	private String email;

	@Setter
	@Column(nullable = false)
	private String password;

	public Member() {}

	public Member(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
}
