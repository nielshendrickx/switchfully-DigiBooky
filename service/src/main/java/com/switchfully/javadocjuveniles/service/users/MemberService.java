package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    private MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public Collection<MemberDto> getAllMembers() {
        return memberMapper.toDto(memberRepository.getAllMembers());
    }

}