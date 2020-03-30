package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateLibrarianDtoTest {
    @Test
    void creatingLibrarianDto_returnsCorrectValues() {
        LibrarianDto librarianDto = new LibrarianDto("id", "firstName", "lastName", "email", "password");
        assertEquals("id", librarianDto.getId());
        assertEquals("firstName", librarianDto.getFirstName());
        assertEquals("lastName", librarianDto.getLastName());
        assertEquals("email", librarianDto.getEmail());
        assertEquals(UserRole.LIBRARIAN, librarianDto.getRole());
    }
}