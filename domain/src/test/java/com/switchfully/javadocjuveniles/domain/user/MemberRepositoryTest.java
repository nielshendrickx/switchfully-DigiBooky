package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    @Test
    void ifEmail_doesntExist_returnTrue() {
        //GIVEN
        MemberRepository memberRepository = new MemberRepository();
        Member member1 = UserBuilder.userBuilder()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@dead.com")
                .withPassWord("dead")
                .withINSS("63.07.13-123.45")
                .buildMember();
        memberRepository.registerNewMember(member1);
        //WHEN
        boolean emailChecked = memberRepository.isEmailAvailable("test@dgc.com");
        //THEN
        assertTrue(emailChecked);
    }

    @Test
    void ifEmail_doesExist_returnFalse() {
        //GIVEN
        MemberRepository memberRepository = new MemberRepository();
        Member member1 = UserBuilder.userBuilder()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@dead.com")
                .withPassWord("dead")
                .withINSS("63.07.13-123.45")
                .buildMember();
        memberRepository.registerNewMember(member1);
        //WHEN
        boolean emailChecked = memberRepository.isEmailAvailable("john.doe@dead.com");
        //THEN
        assertFalse(emailChecked);
    }

    @Test
    void ifRepo_isEmpty_shouldReturnTrue() {
        //GIVEN
        MemberRepository memberRepository = new MemberRepository();
        //WHEN
        boolean emailChecked = memberRepository.isEmailAvailable("test@dgc.com");
        //THEN
        assertTrue(emailChecked);
    }


}