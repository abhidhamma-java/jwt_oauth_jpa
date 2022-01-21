package com.bezkoder.spring.security.jwt.domain;

import com.bezkoder.spring.security.jwt.domain.security.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	@Id @GeneratedValue
	@Column(name = "member_id")
	private Long id;

	private String email;
	private String username;
	private String avatar;
	private String password;

	private String oAUth2Id;
	private String accessToken;
	private String refreshToken;

	@OneToMany(mappedBy = "member")
	private List<Diary> diaries = new ArrayList<>();

	@OneToMany(mappedBy = "member")
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy = "member")
	private List<Recommendation> recommendations = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public Member(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
