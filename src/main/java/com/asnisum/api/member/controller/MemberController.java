package com.asnisum.api.member.controller;


import com.asnisum.api.member.dto.JoinRequest;
import com.asnisum.api.member.dto.JoinResponse;
import com.asnisum.api.member.dto.MemberInfoResponse;
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

        @PostMapping(value = "/signup")
        public ResponseEntity<JoinResponse> create(@RequestBody JoinRequest request) throws Exception {
            return ResponseEntity
                    .status(CREATED)
                    .body(memberService.createMember(request));
        }

        @GetMapping("/{idx}")
        public ResponseEntity<MemberInfoResponse> info(@PathVariable Long idx) throws Exception {
            return ResponseEntity
                    .ok(new MemberInfoResponse(memberService.findByMemberIdx(idx)));
        }



}
