package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.Member;
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

    public MemberDto getMemberByEmail(String email) {
        return memberMapper.toDto(memberRepository.getMemberByEmail(email));
    }

    public boolean isEmailAvailable(String email) {
        return memberRepository.isEmailAvailable(email);
    }

    public boolean isInssAvailable(String inss) { return memberRepository.isInssAvailable(inss); }

    public MemberDto register(CreateMemberDto newMember) {
        return memberMapper.toDto(memberRepository.registerNewMember(memberMapper.toMember(newMember)));
    }

    public MemberDto getDtoById(String id) {
        return memberMapper.toDto(memberRepository.getMemberById(id));
    }

    public Member getMemberById(String id) {
        return memberRepository.getMemberById(id);
    }

}
