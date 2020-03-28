package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.EmailNotValidException;
import com.switchfully.javadocjuveniles.domain.user.MemberRepository;
import com.switchfully.javadocjuveniles.service.users.*;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberControllerTest {

    MemberRepository memberRepository = new MemberRepository();
    MemberMapper memberMapper = new MemberMapper();
    MemberService memberService = new MemberService(memberRepository, memberMapper);
    MemberController memberController = new MemberController(memberService);

    @Test
    void whenRegister_ifGivenWrongMail_shouldThrowException() {
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "not_a_correct_email_address", null, null, null);
        assertThrows(EmailNotValidException.class, () -> memberController.register(createMemberDto));;

    }

    @Test
    void whenRegistering_withAlreadyExistingMail_shouldThrowError() {
        // Given
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@gmail.com", null, null, null);
        CreateMemberDto createMemberDto2 = new CreateMemberDto(null, null, "test@gmail.com", null, null, null);
        // When
        memberController.register(createMemberDto);
        // Then
        assertThrows(EmailAlreadyRegisteredException.class, () -> memberController.register(createMemberDto2));
    }

    @Test
    void whenAskingToGetAllMembers_shouldReturnAListOfAllRegisteredMembers() {
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@mail.com", null, null, null);
        // When
        String expectedId = memberController.register(createMemberDto).getId();
        List<String> actualId = memberController.getAllMembers().stream().map(UserDto::getId).collect(Collectors.toList());
        // Then
        assertThat(actualId).containsExactly(expectedId);
    }
}