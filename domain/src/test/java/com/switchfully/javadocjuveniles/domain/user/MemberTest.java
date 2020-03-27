package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.exceptions.PersonalInfoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.MemberBuilder.memberBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.PersonalInfoBuilder.personalInfoBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        assertEquals("299.18.02-10.08.1996", member.getInss());
    }

    @Test
    void creatingMember_withoutFinishingProfile_returnsPersonalInfoException() {
        assertThrows(PersonalInfoException.class, () -> memberBuilder().buildMember());
        assertThat(new PersonalInfoException().getMessage()).isEqualTo("Your profile is not finished. We need some additional info.");

    }
}