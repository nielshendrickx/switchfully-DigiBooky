package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.exceptions.PersonalInfoException;
import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void creatingAdministrator_withoutFinishingProfile_returnsPersonalInfoException() {
        assertThrows(PersonalInfoException.class, () -> userBuilder().buildAdministrator());
        assertThat(new PersonalInfoException().getMessage()).isEqualTo("Your profile is not finished. We need some additional info.");

    }
}