package com.asnisum.api.member.dto;

import com.asnisum.api.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberInfoResponse {


    private String memberId;

    private String email;

    private String phone;

    public MemberInfoResponse(Member member) {
        this.memberId = member.getMemberId();
        this.email = member.getEmail();
        this.phone = member.getPhone();
    }
}
