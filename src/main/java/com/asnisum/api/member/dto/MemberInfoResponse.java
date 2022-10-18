package com.asnisum.api.member.dto;

import com.asnisum.api.member.entity.Member;
import com.asnisum.api.util.MemberEncrypt;
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
    public MemberInfoResponse(Member member) throws Exception {
        this.memberId = MemberEncrypt.decryptAES256(member.getMemberId());
        this.email = MemberEncrypt.decryptAES256(member.getEmail());
        this.phone = MemberEncrypt.decryptAES256(member.getPhone());
    }
}
