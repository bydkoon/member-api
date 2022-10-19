package com.asnisum.api.member.controller;


import com.asnisum.api.member.dto.JoinRequest;
import com.asnisum.api.member.dto.JoinResponse;
import com.asnisum.api.member.dto.MemberInfoResponse;
import com.asnisum.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {
        private final MemberService memberService;
        @PostMapping(value = "/signup")
        public ResponseEntity<JoinResponse> create(@RequestBody @Valid JoinRequest request) throws Exception {
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
