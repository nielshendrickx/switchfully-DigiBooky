package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.Address;
import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static org.junit.jupiter.api.Assertions.*;

class MemberDtoTest {
    @Test
    void memberDto_returnsCorrectValues() {
        Address address = addressBuilder().withStreet("street")
                .withStreetNumber("1A")
                .withPostalCode("1111")
                .withCity("city")
                .build();
        MemberDto memberDto = new MemberDto("id", "firstName", "lastName", "email", "password", "inss", address);
        assertEquals("id", memberDto.getId());
        assertEquals("firstName", memberDto.getFirstName());
        assertEquals("lastName", memberDto.getLastName());
        assertEquals("email", memberDto.getEmail());
        assertEquals("password", memberDto.getPassword());
        assertEquals("inss", memberDto.getINSS());
        assertEquals(address, memberDto.getAddress());
    }

}