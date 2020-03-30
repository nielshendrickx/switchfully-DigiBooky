package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;

@Component
public class MemberMapper {

    public Collection<MemberDto> toDto(Collection<Member> memberCollection) {
        return memberCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public MemberDto toDto(Member member) {
        return new MemberDto(member.getId(), member.getFirstName(), member.getLastName(), member.getEmail(), member.getPassword(), member.getINSS(), member.getAddress());
    }

    public Member toMember(CreateMemberDto createMemberDto) {
        return userBuilder()
                .withFirstName(createMemberDto.getFirstName())
                .withLastName(createMemberDto.getLastName())
                .withEmail(createMemberDto.getEmail())
                .withPassWord(createMemberDto.getPassword())
                .withINSS(createMemberDto.getINSS())
                .setAddress(createMemberDto.getAddress())
                .buildMember();
    }
}

