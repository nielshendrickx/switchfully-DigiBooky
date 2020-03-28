package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.domain.exceptions.EmailNotValidException;
import com.switchfully.javadocjuveniles.domain.user.MemberRepository;
import com.switchfully.javadocjuveniles.service.users.CreateMemberDto;
import com.switchfully.javadocjuveniles.service.users.MemberMapper;
import com.switchfully.javadocjuveniles.service.users.MemberService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberControllerTest {
    MemberController memberController;

    {
        MemberRepository memberRepository = new MemberRepository();
        MemberMapper memberMapper = new MemberMapper();
        MemberService memberService = new MemberService(memberRepository, memberMapper);
        memberController = new MemberController(memberService);
    }

    @Test
    void whenRegister_ifGivenWrongMail_shouldReturnAnError() {

    }

    @Test
    void whenRegistering_withAlreadyExistingMail_shouldReturnFalse() {
        // Given
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@gmail.com", null, null, null);
        CreateMemberDto createMemberDto2 = new CreateMemberDto(null, null, "test@gmail.com", null, null, null);
        // When
        memberController.register(createMemberDto);
        // Then

    }
}