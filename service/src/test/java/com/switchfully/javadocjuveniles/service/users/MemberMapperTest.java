package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.Address;
import com.switchfully.javadocjuveniles.domain.user.Member;
import com.switchfully.javadocjuveniles.service.users.members.CreateMemberDto;
import com.switchfully.javadocjuveniles.service.users.members.MemberDto;
import com.switchfully.javadocjuveniles.service.users.members.MemberMapper;
import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;
import static org.junit.jupiter.api.Assertions.*;

class MemberMapperTest {
    MemberMapper memberMapper = new MemberMapper();

    @Test
    void mappingToMember_returnsMemberWithSameValuesAsCreateMemberDto() {
        Address address = addressBuilder().withCity("city").withPostalCode("1111").withStreet("street").withStreetNumber("1A").build();
        Member member = memberMapper.toMember(new CreateMemberDto("firstName", "lastName", "email", "password", "inss", address));
        assertEquals("firstName", member.getFirstName());
        assertEquals("lastName", member.getLastName());
        assertEquals("email", member.getEmail());
        assertEquals("password", member.getPassword());
        assertEquals("inss", member.getINSS());
        assertEquals(address, member.getAddress());
    }

    @Test
    void mappingToDto_returnsDtoWithSameValuesAsMemberDto() {
        Address address = addressBuilder().withCity("city").withPostalCode("1111").withStreet("street").withStreetNumber("1A").build();
        Member member = userBuilder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .withEmail("email")
                .withPassWord("password")
                .withINSS("inss")
                .setAddress(address)
                .buildMember();
        MemberDto memberDto = memberMapper.toDto(member);
        assertEquals(member.getId(), memberDto.getId());
        assertEquals("firstName", memberDto.getFirstName());
        assertEquals("lastName", memberDto.getLastName());
        assertEquals("email", memberDto.getEmail());
        assertEquals("password", memberDto.getPassword());
        assertEquals("inss", memberDto.getINSS());
        assertEquals(address, memberDto.getAddress());
    }
}
