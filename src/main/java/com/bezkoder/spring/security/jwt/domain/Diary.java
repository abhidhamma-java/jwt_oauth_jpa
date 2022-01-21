package com.bezkoder.spring.security.jwt.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {
    @Id @GeneratedValue
    @Column(name = "diary_id")
    private Long id;

    String content;
    int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "diary")
    private List<DiaryItem> diaryItem = new ArrayList<>();

    @OneToOne(mappedBy = "diary")
    @JoinColumn(name = "post_id")
    private Post post;
}
