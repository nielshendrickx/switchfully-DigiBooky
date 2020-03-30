package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.service.users.members.MemberDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateMemberDtoTest {
    @Test
    void creatingMemberDto_returnsCorrectValues() {
        MemberDto memberDto = new MemberDto("id", "firstName", "lastName", "email", "password", "inss", null);
        assertEquals("id", memberDto.getId());
        assertEquals("firstName", memberDto.getFirstName());
        assertEquals("lastName", memberDto.getLastName());
        assertEquals("email", memberDto.getEmail());
        assertEquals("inss", memberDto.getINSS());
    }
}