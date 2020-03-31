package com.switchfully.javadocjuveniles.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void createMember() {
        Address address = addressBuilder()
                .withCity("Brussels")
                .withPostalCode("1000")
                .withStreet("Piglane")
                .withStreetNumber("42")
                .build();
        Member member = userBuilder()
                .withINSS("299.18.02-10.08.1996")
                .setAddress(address)
                .withFirstName("FirstName")
                .withLastName("LastName")
                .withEmail("test@email.com")
                .withPassWord("aPassword")
                .buildMember();

        assertEquals("299.18.02-10.08.1996", member.getINSS());
        assertEquals(address, member.getAddress());
        assertEquals("FirstName", member.getFirstName());
        assertEquals("LastName", member.getLastName());
        assertEquals("test@email.com", member.getEmail());
        assertTrue(verifyHash("aPassword", member.getPassword()));
        assertNotNull(member.getId());
    }

    public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}