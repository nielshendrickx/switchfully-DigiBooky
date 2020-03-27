package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.Member;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.switchfully.javadocjuveniles.domain.user.builders.MemberBuilder.memberBuilder;

@Component
public class MemberMapper {

    public Collection<MemberDto> toDto(Collection<Member> memberCollection) {
        return memberCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public MemberDto toDto(Member member) {
        return new MemberDto(member.getPersonalInfo(), member.getAddress(), member.getBorrowedItems());
    }

    public Member toMember(MemberDto memberDto) {
        return memberBuilder()
                .withPersonalInfo(memberDto.getPersonalInfo())
                .setAddress(memberDto.getAddress())
                .buildMember();
    }
}
