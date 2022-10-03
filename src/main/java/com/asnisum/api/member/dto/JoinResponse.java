package com.asnisum.api.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoinResponse {

    private String userId;
    private String phone;
    private String email;
}