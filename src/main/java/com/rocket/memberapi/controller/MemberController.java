package com.rocket.memberapi.controller;

import com.rocket.memberapi.dto.request.MemberSignUpDto;
import com.rocket.memberapi.dto.request.PositionRequestDto;
import com.rocket.memberapi.dto.request.PreferenceRequestDto;
import com.rocket.memberapi.dto.response.*;
import com.rocket.memberapi.service.LevelService;
import com.rocket.memberapi.service.PositionService;
import com.rocket.memberapi.service.PreferenceService;
import com.rocket.memberapi.service.RoleService;
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

    private final PreferenceService preferenceService;

    private final RoleService roleService;

    private final PositionService positionService;

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
    public ResponseEntity<MemberLoginResponseDto> findByEmail(@PathVariable String email) {
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

    @ApiOperation(value = "관심 분야 조회", notes = "멤버 seq로 해당 멤버의 관심 분야를 조회합니다.")
    @GetMapping("/preference/{member_seq}")
    public ResponseEntity<PreferenceResponseDto> getPreference(@PathVariable Long member_seq) {
        return ResponseEntity.status(HttpStatus.OK).body(preferenceService.getPreference(member_seq));
    }

    @ApiOperation(value = "관심 분야 등록", notes = "멤버 seq와 관심 분야 seq list를 받아 등록합니다.")
    @PostMapping("/preference/register/{member_seq}")
    public ResponseEntity<Void> registerPreference(@PathVariable Long member_seq, @RequestBody PreferenceRequestDto dto) {
        preferenceService.registerPreference(member_seq, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "관심 분야 삭제", notes = "멤버 seq와 관심 분야 seq를 입력받아 삭제합니다.")
    @DeleteMapping("/preference/delete/{member_seq}/{preference_seq}")
    public ResponseEntity<Void> deletePreference(@PathVariable Long member_seq, @PathVariable Long preference_seq) {
        preferenceService.deletePreference(member_seq, preference_seq);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "권한 조회", notes = "멤버 seq로 해당 멤버의 권한을 조회합니다.")
    @GetMapping("/role/{member_seq}")
    public ResponseEntity<RoleResponseDto> getRole(@PathVariable Long member_seq) {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.getRole(member_seq));
    }

    @ApiOperation(value = "권한 수정", notes = "멤버 seq와 권한 seq를 받아 해당 멤버의 권한을 수정합니다.")
    @PatchMapping("/role/update/{member_seq}/{role_seq}")
    public ResponseEntity<Void> updateRole(@PathVariable Long member_seq, @PathVariable Long role_seq) {
        memberService.updateRole(member_seq, role_seq);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "포지션 조회", notes = "멤버 seq를 받아 해당 멤버의 포지션을 조회합니다.")
    @GetMapping("/position/{member_seq}")
    public ResponseEntity<PositionResponseDto> getPosition(@PathVariable Long member_seq) {
        return ResponseEntity.status(HttpStatus.OK).body(positionService.getPosition(member_seq));
    }

    @ApiOperation(value = "포지션 등록", notes = "멤버 seq와 포지션 seq list를 받아 등록합니다.")
    @PostMapping("/position/register/{member_seq}")
    public ResponseEntity<Void> registerPosition(@PathVariable Long member_seq, @RequestBody PositionRequestDto dto) {
        positionService.registerPosition(member_seq, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "포지션 삭제", notes = "멤버 seq와 포지션 seq를 입력받아 해당 멤버의 포지션을 삭제합니다.")
    @DeleteMapping("/position/delete/{member_seq}/{position_seq}")
    public ResponseEntity<Void> deletePosition(@PathVariable Long member_seq, @PathVariable Long position_seq) {
        positionService.deletePosition(member_seq, position_seq);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
