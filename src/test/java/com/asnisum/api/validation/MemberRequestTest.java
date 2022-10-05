package com.asnisum.api.validation;

import com.asnisum.api.MemberDummy;
import com.asnisum.api.member.dto.JoinRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MemberRequestTest extends BeanValidationTest {

    private JoinRequest request;

    @BeforeEach
    void setUp() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        request = MemberDummy.join();
    }


    @Test
    @DisplayName("회원가입 실패 - 사용자 아이디를 입력하지 않는 경우")
    void 회원가입_실패_아이디_입력_X() {
        request.setMemberId(null);

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 성공 - 사용자 아이디가 4자리인 경우")
    void 회원가입_성공_아이디_4자() {
        request.setMemberId("love");

        isJoinTrue();
    }

    @Test
    @DisplayName("회원가입 실패 - 사용자 아이디가 3자리 이하인 경우")
    void 회원가입_실패_아이디_3자_이하() {
        request.setMemberId("cat");

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 성공 - 사용자 아이디가 20자리인 경우")
    void 회원가입_성공_아이디_20자() {
        request.setMemberId("testtest123456789102");

        isJoinTrue();
    }

    @Test
    @DisplayName("회원가입 실패 - 사용자 아이디가 20자리 이상인 경우")
    void 회원가입_실패_아이디_13자_이상() {
        request.setMemberId("testtest12345678910223");

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 실패 - 사용자 비밀번호를 입력하지 않는 경우")
    void 회원가입_실패_비밀번호_입력_X() {
        request.setPassword(null);

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 성공 - 사용자 비밀번호가 8자리인 경우(숫자 특수문자 포함)")
    void 회원가입_성공_비밀번호_8자_숫특() {
        request.setPassword("test123!");

        isJoinTrue();
    }

    @Test
    @DisplayName("회원가입 실패 - 사용자 비밀번호가 8자리인 경우(숫자 특수문자 X)")
    void 회원가입_실패_비밀번호_8자() {
        request.setPassword("testtest");

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 실패 - 사용자 비밀번호가 8자리 이하인 경우")
    void 회원가입_실패_비밀번호_7자리_이하() {
        request.setPassword("test");

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 성공 - 사용자 비밀번호가 13자리인 경우")
    void 회원가입_성공_비밀번호_13자() {
        request.setPassword("testtest1234!");

        isJoinTrue();
    }

    @Test
    @DisplayName("회원가입 실패 - 사용자 비밀번호가 20자리 이상인 경우")
    void 회원가입_실패_비밀번호_20자_이상() {
        request.setPassword("testtest1212345678910");

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 실패 - 사용자 이메일을 입력하지 않는 경우")
    void 회원가입_실패_이메일_입력_X() {
        request.setEmail(null);

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 성공 - 이메일 형식이 옳바른 경우")
    void 회원가입_성공_이메일_형식_옳바름() {
        request.setEmail("teset@example.com");

        isJoinTrue();
    }

    @Test
    @DisplayName("회원가입 실패 - 이메일 형식이 유효하지 않은 경우(앳 없음)")
    void 회원가입_실패_이메일_형식_앳_없음() {
        request.setEmail("teset");

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 실패 - 이메일 형식이 유효하지 않은 경우(앳만 있음)")
    void 회원가입_실패_이메일_형식_앳만_있음() {
        request.setEmail("teset@");

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 실패 - 사용자 전화번호를 입력하지 않는 경우")
    void 회원가입_실패_전화번호_입력_X() {
        request.setPhone(null);

        isJoinFalse();
    }

    @Test
    @DisplayName("회원가입 성공 - 전화번호 형식이 옳바른 경우")
    void 회원가입_성공_전화번호_형식_옳바름() {
        request.setPhone("010-1234-5678");

        isJoinTrue();
    }

    @Test
    @DisplayName("회원가입 실패 - 전화번호 형식이 옳바르지 않은 경우")
    void 회원가입_실패_전화번호_형식_옳바르지_않음() {
        request.setPhone("0101234-5678");
        isJoinFalse();

        request.setPhone("010-12345678");
        isJoinFalse();

        request.setPhone("01012345678");
        isJoinFalse();
    }

    private void isJoinTrue() {
        Set<ConstraintViolation<JoinRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty());
    }

    private void isJoinFalse() {
        Set<ConstraintViolation<JoinRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty());
    }
}
