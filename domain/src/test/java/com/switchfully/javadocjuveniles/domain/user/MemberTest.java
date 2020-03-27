package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.user.builders.PersonalInfoBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.MemberBuilder.memberBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.PersonalInfoBuilder.personalInfoBuilder;

class MemberTest {

    @Test
    void createMember() {
        Member member = memberBuilder()
                .withPersonalInfo(personalInfoBuilder()
                        .withEmail("test@email.com")
                        .withFirstName("firstName")
                        .withLastName("lastName")
                        .withPassWord("password")
                        .build()
                ).setAddress(addressBuilder()
                        .withCity("Brussels")
                        .withPostalCode("1000")
                        .withStreet("Piglane")
                        .withStreetNumber("42")
                        .build()
                )
                .withINSS("299.18.02-10.08.1996")
                .buildMember();

        Assertions.assertEquals("299.18.02-10.08.1996", member.getInss());
    }

}