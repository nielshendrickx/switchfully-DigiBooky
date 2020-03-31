
package com.switchfully.javadocjuveniles.domain.user;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;
import static com.switchfully.javadocjuveniles.domain.user.feature.UserRole.ADMIN;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void createUser_shouldReturnCorrectValues() {
        User user = userBuilder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .withEmail("email")
                .withRole(ADMIN)
                .withPassWord("password")
                .buildUser();
        assertEquals("firstName", user.getFirstName());
        assertEquals("lastName", user.getLastName());
        assertEquals("email", user.getEmail());
        assertEquals(ADMIN, user.getRole());
        assertTrue(verifyHash("password", user.getPassword()));
        assertNotNull(user.getId());
    }

    public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}