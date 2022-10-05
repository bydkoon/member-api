package com.asnisum.api;

import com.asnisum.api.member.dto.JoinRequest;
import com.asnisum.api.member.entity.Member;

public class MemberDummy {

    public static Member member() {
        return Member.builder()
                .memberId("testsfes")
                .password("test1234!")
                .email("lee@example.com")
                .phone("010-1234-5678")
                .build();
    }


    public static JoinRequest join() {
        return new JoinRequest(
                "testMember",
                "test1234!",
                "lee@example.com",
                "010-1234-5678"
        );
    }
}
