package com.switchfully.javadocjuveniles.service.users;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {
    @Test
    void creatingUserDto_shouldContainId() {
        String givenId = "id";
        UserDto userDto = new UserDto(givenId, null, null, null, null, null);
        assertThat(userDto.getId()).isEqualTo(givenId);
    }
}