package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.api.security.validation.Validation;
import com.switchfully.javadocjuveniles.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.EmailNotValidException;
import com.switchfully.javadocjuveniles.domain.exceptions.InssAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.InssNotValidException;
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
        assertThrows(EmailNotValidException.class, () -> memberController.register(createMemberDto));

    }

    @Test
    void whenRegistering_withAlreadyExistingMail_shouldThrowError() {
        // Given
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@gmail.com", null, "00.00.00.000.00", null);
        CreateMemberDto createMemberDto2 = new CreateMemberDto(null, null, "test@gmail.com", null, "11.11.11.111.11", null);
        // When
        memberController.register(createMemberDto);
        // Then
        assertThrows(EmailAlreadyRegisteredException.class, () -> memberController.register(createMemberDto2));
    }

    @Test
    void whenAskingToGetAllMembers_shouldReturnAListOfAllRegisteredMembers() {
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@mail.com", null, "00.00.00.000.00", null);
        // When
        String expectedId = memberController.register(createMemberDto).getId();
        List<String> actualId = memberController.getAllMembers().stream().map(UserDto::getId).collect(Collectors.toList());
        // Then
        assertThat(actualId).containsExactly(expectedId);
    }

    @Test
    void givenWrongInss_throwsException() {
        String givenInss = "wrong inss";
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@mail.com", null, givenInss, null);
        assertThrows(InssNotValidException.class, () -> memberController.register(createMemberDto));
    }

    @Test
    void givenCorrectInss_returnsTrue() {
        String givenInss = "00.00.00.000.00";
        assertThat(Validation.isValidInss(givenInss)).isTrue();
    }

    @Test
    void whenRegistering_withAlreadyExistingInss_shouldThrowError() {
        // Given
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@gmail.com", null, "00.00.00.000.00", null);
        CreateMemberDto createMemberDto2 = new CreateMemberDto(null, null, "otheraddress@gmail.com", null, "00.00.00.000.00", null);
        // When
        memberController.register(createMemberDto);
        // Then
        assertThrows(InssAlreadyRegisteredException.class, () -> memberController.register(createMemberDto2));
    }

    @Test
    void whenRegistering_withNewInss_shouldReturnTrue() {
        // Given
        String inss1 = "00.00.00.000.00";
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@gmail.com", null, inss1, null);
        String inss2 = "11.11.11.111.11";
        // When
        memberController.register(createMemberDto);
        // Then
        assertThat(memberRepository.isInssAvailable(inss2)).isTrue();
    }
}