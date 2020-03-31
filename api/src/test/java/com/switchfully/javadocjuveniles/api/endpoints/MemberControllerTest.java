package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.api.security.validation.Validation;
import com.switchfully.javadocjuveniles.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.EmailNotValidException;
import com.switchfully.javadocjuveniles.domain.exceptions.InssAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.InssNotValidException;
import com.switchfully.javadocjuveniles.domain.user.MemberRepository;
import com.switchfully.javadocjuveniles.domain.user.UserRepository;
import com.switchfully.javadocjuveniles.service.users.members.CreateMemberDto;
import com.switchfully.javadocjuveniles.service.users.members.MemberMapper;
import com.switchfully.javadocjuveniles.service.users.services.MemberService;
import com.switchfully.javadocjuveniles.service.users.services.UserService;
import com.switchfully.javadocjuveniles.service.users.users.UserDto;
import com.switchfully.javadocjuveniles.service.users.users.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberControllerTest {

    MemberRepository memberRepository;
    MemberMapper memberMapper;
    MemberService memberService;
    UserRepository userRepository;
    UserMapper userMapper;
    UserService userService;
    MemberController memberController;

    @BeforeEach
    void init() {
        memberRepository = new MemberRepository();
        memberMapper = new MemberMapper();
        memberService = new MemberService(memberRepository, memberMapper);
        userRepository = new UserRepository();
        userMapper = new UserMapper();
        userService = new UserService(userRepository, userMapper);
        memberController = new MemberController(memberService, userService);
    }

    @Test
    void whenRegister_ifGivenWrongMail_shouldThrowException() {
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "not_a_correct_email_address", "password", null, null);
        assertThrows(EmailNotValidException.class, () -> memberController.register(createMemberDto));

    }

    @Test
    void whenRegistering_withAlreadyExistingMail_shouldThrowError() throws IOException {
        // Given
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@gmail.com", "password", "00.00.00-000.00", null);
        CreateMemberDto createMemberDto2 = new CreateMemberDto(null, null, "test@gmail.com", "password", "11.11.11-111.11", null);
        // When
        memberController.register(createMemberDto);
        // Then
        assertThrows(EmailAlreadyRegisteredException.class, () -> memberController.register(createMemberDto2));
    }

    @Test
    void whenAskingToGetAllMembers_shouldReturnAListOfAllRegisteredMembers() throws IOException {
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@mail.com", "password", "00.00.00-000.00", null);

        // When
        String expectedId = memberController.register(createMemberDto).getId();
        List<String> actualId = memberController.getAllMembers().stream().map(UserDto::getId).collect(Collectors.toList());
        // Then
        assertThat(actualId).contains(expectedId);
    }

    @Test
    void givenWrongInss_throwsException() {
        String givenInss = "wrong inss";
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@mail.com", "password", givenInss, null);
        assertThrows(InssNotValidException.class, () -> memberController.register(createMemberDto));
    }

    @Test
    void givenCorrectInss_returnsTrue() {
        String givenInss = "00.00.00-000.00";
        assertThat(Validation.isValidInss(givenInss)).isTrue();
    }

    @Test
    void whenRegistering_withAlreadyExistingInss_shouldThrowError() throws IOException {
        // Given
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@gmail.com", "password", "00.00.00-000.00", null);
        CreateMemberDto createMemberDto2 = new CreateMemberDto(null, null, "otheraddress@gmail.com", "password", "00.00.00-000.00", null);
        // When
        memberController.register(createMemberDto);
        // Then
        assertThrows(InssAlreadyRegisteredException.class, () -> memberController.register(createMemberDto2));
    }

    @Test
    void whenRegistering_withNewInss_shouldReturnTrue() throws IOException {
        // Given
        String inss1 = "00.00.00-000.00";
        CreateMemberDto createMemberDto = new CreateMemberDto(null, null, "test@gmail.com", "password", inss1, null);
        String inss2 = "11.11.11-111.11";
        // When
        memberController.register(createMemberDto);
        // Then
        assertThat(memberRepository.isInssAvailable(inss2)).isTrue();
    }
}