package com.rocket.memberapi.controller;

import com.rocket.memberapi.dto.request.MemberSignUpDto;
import com.rocket.memberapi.dto.response.LevelResponseDto;
import com.rocket.memberapi.dto.response.MemberResponseDto;
import com.rocket.memberapi.service.LevelService;
import com.rocket.memberapi.service.impl.MemberServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/api")
public class MemberController {

    private final MemberServiceImpl memberService;

    private final LevelService levelService;

    @ApiOperation(value = "Id 중복 조회", notes = "Id를 통해서 해당 계정이 중복되었는지 조회합니다.")
    @GetMapping(value = "/exist/{email}")
    public ResponseEntity<Boolean> existById(@PathVariable String email) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.existById(email));
    }

    @ApiOperation(value = "회원가입", notes = "회원가입 처리를 진행합니다.")
    @PostMapping("/register")
    public ResponseEntity<Void> signUp(@RequestBody MemberSignUpDto dto) {
        memberService.memberSignUp(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "seq로 회원 조회", notes = "seq를 이용하여 회원을 조회합니다.")
    @GetMapping("/seq/{seq}")
    public ResponseEntity<MemberResponseDto> findByMemberSeq(@PathVariable Long seq) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findByMemberSeq(seq));
    }

    @ApiOperation(value = "email로 회원 조회", notes = "email를 이용하여 회원을 조회합니다.")
    @GetMapping("/email/{email}")
    public ResponseEntity<MemberResponseDto> findByEmail(@PathVariable String email) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findByEmail(email));
    }

    @ApiOperation(value = "멤버 수정", notes = "멤버를 수정합니다")
    @PatchMapping("/update/{seq}")
    public ResponseEntity<Void> updateMember(@PathVariable Long seq, @RequestBody MemberSignUpDto dto) {
        memberService.memberUpdate(seq, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "멤버 삭제", notes = "seq로 해당 멤버를 삭제합니다.")
    @DeleteMapping("/delete/{seq}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long seq) {
        memberService.memberDelete(seq);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "레벨 조회", notes = "멤버 seq로 해당 멤버의 레벨을 조회합니다.")
    @GetMapping("/level/{member_seq}")
    public ResponseEntity<LevelResponseDto> getLevel(@PathVariable Long member_seq) {
        return ResponseEntity.status(HttpStatus.OK).body(levelService.getLevel(member_seq));
    }

    @ApiOperation(value = "레벨 수정", notes = "멤버 seq, 레벨 seq를 받아 해당 멤버의 레벨을 수정합니다.")
    @PatchMapping("/level/update/{member_seq}/{level_seq}")
    public ResponseEntity<Void> updateLevel(@PathVariable Long member_seq, @PathVariable Long level_seq) {
        memberService.updateLevel(member_seq, level_seq);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
