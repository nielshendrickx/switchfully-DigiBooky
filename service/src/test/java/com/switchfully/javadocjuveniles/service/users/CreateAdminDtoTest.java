package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import com.switchfully.javadocjuveniles.service.users.users.AdminDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateAdminDtoTest {
    @Test
    void creatingAdminDto_returnsCorrectValues() {
        AdminDto adminDto = new AdminDto("id", "firstName", "lastName", "email", "password");
        assertEquals("id", adminDto.getId());
        assertEquals("firstName", adminDto.getFirstName());
        assertEquals("lastName", adminDto.getLastName());
        assertEquals("email", adminDto.getEmail());
        assertEquals(UserRole.ADMIN, adminDto.getRole());
    }
}