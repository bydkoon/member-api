package com.asnisum.api.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequest {

    @Pattern(regexp = "^[A-Za-z0-9]{4,20}$", message = "아이디는 4~20자리로 입력해주세요.")
    private String memberId;

    @Pattern(regexp = "^(?!((?:[A-Za-z]+)|(?:[~!@#$%^&*()_+=]+)|(?:[0-9]+))$)[A-Za-z\\d~!@#$%^&*()_+=]{8,20}$",
            message = "비밀번호는 8자리 이상 20자리 이하여야 하며 영대소문자, 숫자와 특수문자를 두가지이상 반드시 포함해야 합니다.")
    private String password;

    @Email(message = "이메일이 형식이 유효하지 않습니다.")
    private String email;

    @Pattern(regexp = "^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$", message = "전화번호 형식이 유효하지 않습니다.")
    private String phone;

}