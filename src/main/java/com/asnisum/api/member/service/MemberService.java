package com.asnisum.api.member.service;

import com.asnisum.api.error.exception.DuplicatedMemberIdException;
import com.asnisum.api.error.exception.MemberNotFoundException;
import com.asnisum.api.member.dto.JoinRequest;
import com.asnisum.api.member.dto.JoinResponse;
import com.asnisum.api.member.entity.Member;
import com.asnisum.api.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findByMemberIdx(Long idx) {
        Member user = memberRepository.findByIdx(idx);

        if (user == null) {
            throw new MemberNotFoundException("유저를 찾을 수 없습니다.");
        }

        return user;
    }

    public JoinResponse createMember(JoinRequest request) {
        if (isDuplicateMemberId(request.getMemberId())) {
            throw new DuplicatedMemberIdException("회원의 아이디가 이미 등록 되어있습니다..");
        }
        if (isDuplicateEmail(request.getEmail())) {
            throw new DuplicatedMemberIdException("회원의 이메일이 이미 등록 되어있습니다.");
        }

        Member member = Member.builder()
                .memberId(request.getMemberId())
                .password(request.getPassword())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();

        Member saveMember = memberRepository.save(member);

        return new JoinResponse(saveMember.getMemberId(), saveMember.getPhone(), saveMember.getEmail());
    }
    private boolean isDuplicateMemberId(String memberId) {
        return memberRepository.existsByMemberId(memberId);
    }

    private boolean isDuplicateEmail(String email) {
        return memberRepository.existsByEmail(email);
    }


}
