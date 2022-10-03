package com.asnisum.api.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="member")
public class Member extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Builder
    public Member(Long idx,String memberId, String password, String email, String phone) {
        this.idx = idx;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

}
