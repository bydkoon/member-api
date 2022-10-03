package com.asnisum.api;

import com.asnisum.api.member.dto.JoinRequest;

public class MemberDummy {

    public static JoinRequest join() {
        return new JoinRequest(
                "testMember",
                "test1234!",
                "lee@example.com",
                "010-1234-5678"
        );
    }
}
