package com.switchfully.javadocjuveniles.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;

class MemberTest {

    @Test
    void createMember() {
        Member member = userBuilder()
                .withINSS("299.18.02-10.08.1996")
                .setAddress(addressBuilder()
                        .withCity("Brussels")
                        .withPostalCode("1000")
                        .withStreet("Piglane")
                        .withStreetNumber("42")
                        .build()
                )
                .withFirstName("FirstName")
                .withLastName("LastName")
                .withEmail("test@email.com")
                .withPassWord("aPassword")
                .buildMember();

        Assertions.assertEquals("299.18.02-10.08.1996", member.getINSS());
    }

}