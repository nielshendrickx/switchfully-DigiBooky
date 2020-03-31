package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.DummyData;
import com.switchfully.javadocjuveniles.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    DummyData dummyData = new DummyData();
    @Test
    void ifEmail_doesntExist_returnTrue() {
        //GIVEN
        MemberRepository memberRepository = new MemberRepository(dummyData);
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
        MemberRepository memberRepository = new MemberRepository(dummyData);
        Member member1 = UserBuilder.userBuilder()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@dead.com")
                .withPassWord("dead")
                .withINSS("63.07.13-123.45")
                .buildMember();
        memberRepository.registerNewMember(member1);
        //THEN
        assertThrows(EmailAlreadyRegisteredException.class, () -> memberRepository.isEmailAvailable("john.doe@dead.com"));
    }

    @Test
    void ifRepo_isEmpty_shouldReturnTrue() {
        //GIVEN
        MemberRepository memberRepository = new MemberRepository(dummyData);
        //WHEN
        boolean emailChecked = memberRepository.isEmailAvailable("test@dgc.com");
        //THEN
        assertTrue(emailChecked);
    }
}