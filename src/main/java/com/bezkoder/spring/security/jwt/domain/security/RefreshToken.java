package com.bezkoder.spring.security.jwt.domain.security;

import com.bezkoder.spring.security.jwt.domain.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

import javax.persistence.*;

@Entity
@Getter @Setter
public class RefreshToken {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @Column(nullable = false, unique = true)
  private String token;

  @Column(nullable = false)
  private Instant expiryDate;
}
