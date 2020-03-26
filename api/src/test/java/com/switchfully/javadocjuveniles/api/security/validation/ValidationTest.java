package com.switchfully.javadocjuveniles.api.security.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    @Test
    void validEmail_shouldReturnTrue() {
        String email = "test@test.com";
        assertThat(Validation.isValidEmailAddress(email)).isTrue();
    }

    @Test
    void unvalidEmail_shouldReturnFalse() {
        String email = "not_a_correct_email_address";
        assertThat(Validation.isValidEmailAddress(email)).isFalse();
    }
}