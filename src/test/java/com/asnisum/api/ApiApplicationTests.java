package com.asnisum.api;

import com.asnisum.api.member.dto.JoinRequest;
import com.asnisum.api.member.dto.JoinResponse;
import com.asnisum.api.member.entity.Member;
import com.asnisum.api.member.repository.MemberRepository;
import com.asnisum.api.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiApplicationTests {
    private MemberService userService;

    @Mock
    private MemberRepository memberRepository;

    private JoinRequest joinRequest;

    private Member member;

    @BeforeEach
    void setUp() {
        userService = new MemberService(memberRepository);

        member = MemberDummy.member();
        joinRequest = MemberDummy.join();
    }

    @Test
    @DisplayName("회원가입 성공")
    void 회원가입() {
        given(memberRepository.existsByEmail(member.getEmail())).willReturn(false);
        given(memberRepository.save(any())).willReturn(member);

        JoinResponse response = userService.createMember(joinRequest);

        assertThat(member.getMemberId()).isEqualTo(response.getMemberId());
        assertThat(member.getPhone()).isEqualTo(response.getPhone());
        assertThat(member.getEmail()).isEqualTo(response.getEmail());
    }
}
