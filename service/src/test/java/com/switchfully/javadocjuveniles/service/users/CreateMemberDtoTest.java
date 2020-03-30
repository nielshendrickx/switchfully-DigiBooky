package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.fines.FineType;
import com.switchfully.javadocjuveniles.domain.user.Address;
import com.switchfully.javadocjuveniles.service.users.members.MemberDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static org.junit.jupiter.api.Assertions.*;

class CreateMemberDtoTest {
    @Test
    void creatingMemberDto_returnsCorrectValues() {
        Address address = addressBuilder().withStreet("street")
                .withStreetNumber("1A")
                .withPostalCode("1111")
                .withCity("city")
                .build();
        List<FineType> fines = new ArrayList<>();
        MemberDto memberDto = new MemberDto("id", "firstName", "lastName", "email", "password", "inss", address, fines);
        assertEquals("id", memberDto.getId());
        assertEquals("firstName", memberDto.getFirstName());
        assertEquals("lastName", memberDto.getLastName());
        assertEquals("email", memberDto.getEmail());
        assertEquals("inss", memberDto.getINSS());
    }
}