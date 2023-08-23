package com.rocket.memberapi.service.impl;

import com.rocket.memberapi.dto.request.MemberSignUpDto;
import com.rocket.memberapi.dto.response.MemberResponseDto;
import com.rocket.memberapi.entity.Level;
import com.rocket.memberapi.entity.Member;
import com.rocket.memberapi.entity.Role;
import com.rocket.memberapi.repository.LevelRepository;
import com.rocket.memberapi.repository.MemberRepository;
import com.rocket.memberapi.repository.RoleRepository;
import com.rocket.memberapi.repository.impl.MemberRepositoryImpl;
import com.rocket.memberapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final LevelRepository levelRepository;

    private final RoleRepository roleRepository;

    @Override
    public Boolean existById(String email) {
        return memberRepository.existById(email);
    }

    @Override
    public void memberSignUp(MemberSignUpDto dto) {
        Member member = toEntity(dto);
        memberRepository.save(member);
    }

    @Override
    public MemberResponseDto findByMemberSeq(Long seq) {
        Member member = memberRepository.findByMemberSeq(seq).orElseThrow();
        return toDto(member);
    }

    @Override
    public MemberResponseDto findByEmail(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow();
        return toDto(member);
    }

    @Override
    @Transactional
    public void memberUpdate(Long id, MemberSignUpDto dto) {
        Member member = memberRepository.findById(id).orElseThrow(() ->{
            return new IllegalArgumentException("수정 실패");
        });
        if(dto.getRoleSeq() != null) {
            Role role = roleRepository.findById(dto.getRoleSeq()).orElseThrow();
        }
        if(dto.getLevelSeq() != null) {
            Level level = levelRepository.findById(dto.getLevelSeq()).orElseThrow();
        }

        member = Member.builder()
                .memberSeq(member.getMemberSeq())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .lastAccessAt(dto.getLastAccessAt())
                .nickname(dto.getNickname())
                .phoneNumber(dto.getPhoneNumber())
                .info(dto.getInfo())
                .isOnline(dto.getIsOnline())
                .githubLink(dto.getGithubLink())
                .build();

        memberRepository.save(member);
    }

    @Override
    public void updateLevel(Long memberSeq, Long levelSeq) {
        Member member = memberRepository.findById(memberSeq).orElseThrow();
        Level level = levelRepository.findById(levelSeq).orElseThrow();

        member.updateLevel(level);
        memberRepository.save(member);
    }

    @Override
    public void memberDelete(Long seq) {
        memberRepository.deleteById(seq);
    }

    public Member toEntity(MemberSignUpDto dto) {
        Role role = roleRepository.findById(dto.getRoleSeq()).orElseThrow();
        Level level = levelRepository.findById(dto.getLevelSeq()).orElseThrow();

        return Member.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .phoneNumber(dto.getPhoneNumber())
                .lastAccessAt(LocalDateTime.now())
                .info(dto.getInfo())
                .isOnline(dto.getIsOnline())
                .githubLink(dto.getGithubLink())
                .level(level)
                .role(role)
                .build();
    }

    public MemberResponseDto toDto(Member member) {
        return MemberResponseDto.builder()
                .memberSeq(member.getMemberSeq())
                .email(member.getEmail())
                .githubLink(member.getGithubLink())
                .info(member.getInfo())
                .lastAccessAt(member.getLastAccessAt())
                .level(member.getLevel())
                .nickname(member.getNickname())
                .phoneNumber(member.getPhoneNumber())
                .role(member.getRole())
                .build();
    }
}
