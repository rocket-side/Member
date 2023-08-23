package com.rocket.memberapi.controller;

import com.rocket.memberapi.service.impl.MemberServiceImpl;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceImpl memberService;

    @GetMapping(value = "/member/exist/{seq}")
    public ResponseEntity<Boolean> existById(@PathVariable Long seq) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.existById(seq));
    }
}
