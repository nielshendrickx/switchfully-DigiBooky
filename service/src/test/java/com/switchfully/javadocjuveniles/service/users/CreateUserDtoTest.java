package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import com.switchfully.javadocjuveniles.service.users.users.CreateUserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserDtoTest {
    @Test
    void creatingUserDto_returnsCorrectValues() {
        CreateUserDto createUserDto = new CreateUserDto("firstName", "lastName", "email", "password", UserRole.LIBRARIAN);
        assertEquals("firstName", createUserDto.getFirstName());
        assertEquals("lastName", createUserDto.getLastName());
        assertEquals("email", createUserDto.getEmail());
        assertEquals(UserRole.LIBRARIAN, createUserDto.getRole());
    }

}