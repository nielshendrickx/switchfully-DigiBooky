package com.switchfully.javadocjuveniles.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.MemberBuilder.memberBuilder;

class MemberTest {

    @Test
    void createMember() {
        Member member = memberBuilder()
                .withFirstName("FirstName")
                .withLastName("LastName")
                .withEmail("test@email.com")
                .withPassword("aPassword")
                .withINSS("299.18.02-10.08.1996")
                .setAddress(addressBuilder()
                        .withCity("Brussels")
                        .withPostalCode("1000")
                        .withStreet("Piglane")
                        .withStreetNumber("42")
                        .build()
                )
                .build();

        Assertions.assertEquals("299.18.02-10.08.1996", member.getInss());
    }

}