package com.switchfully.javadocjuveniles.api.placeholder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RemoveMeTest {

    @Test
    void justRemoveMe() {
        RemoveMe removeMe = new RemoveMe();
        assertThat(removeMe.justRemoveMe()).isEqualTo("Remove me");
    }
}