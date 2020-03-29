package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {
    @Test
    void userDto_returnsCorrectValues() {
        UserDto userDto = new UserDto("id", "firstName", "lastName", "email", "password", UserRole.ADMIN);
        assertEquals("id", userDto.getId());
        assertEquals("firstName", userDto.getFirstName());
        assertEquals("lastName", userDto.getLastName());
        assertEquals("email", userDto.getEmail());
        assertEquals("password", userDto.getPassword());
        assertEquals(UserRole.ADMIN, userDto.getRole());
    }
}