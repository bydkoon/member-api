package com.asnisum.api.member.controller;


import com.asnisum.api.member.dto.JoinRequest;
import com.asnisum.api.member.dto.JoinResponse;
import com.asnisum.api.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

        private final MemberService memberService;


        @Autowired
        public MemberController(MemberService memberService) {
            this.memberService = memberService;
        }

//        @Operation(summary = "로그인", description = "아이디와 비밀번호를 이용하여 로그인을 진행합니다.")
//        @ApiResponse(responseCode = "200", description = "로그인 성공")
        @PostMapping(value = "/signup")
        public ResponseEntity<JoinResponse> create(@RequestBody JoinRequest request) {
            return ResponseEntity
                    .status(CREATED)
                    .body(memberService.createMember(request));
        }




}
