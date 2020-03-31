package com.switchfully.javadocjuveniles.service.users.users;

import com.switchfully.javadocjuveniles.domain.user.Address;
import com.switchfully.javadocjuveniles.domain.user.User;
import com.switchfully.javadocjuveniles.service.users.members.MemberDto;
import com.switchfully.javadocjuveniles.service.users.members.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;
import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    UserMapper userMapper = new UserMapper();

    @Test
    void mappingToDto_returnsDtoWithSameValuesAsMemberDto() {
        User user = userBuilder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .withEmail("email")
                .withPassWord("password")
                .buildMember();
        UserDto userDto = userMapper.toDto(user);
        assertEquals(user.getId(), userDto.getId());
        assertEquals("firstName", userDto.getFirstName());
        assertEquals("lastName", userDto.getLastName());
        assertEquals("email", userDto.getEmail());
        assertTrue(verifyHash("password", userDto.getPassword()));
    }

    public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}