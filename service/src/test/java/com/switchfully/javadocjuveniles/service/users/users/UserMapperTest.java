package com.switchfully.javadocjuveniles.service.users.users;

import com.switchfully.javadocjuveniles.domain.user.User;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;
import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    UserMapper userMapper = new UserMapper();

    @Test
    void mappingToUser_returnsUserWithSameValuesAsCreateUserDto() {
        User user = userMapper.toUser(new CreateUserDto("firstName", "lastName", "email", "password", UserRole.MEMBER));
        assertEquals("firstName", user.getFirstName());
        assertEquals("lastName", user.getLastName());
        assertEquals("email", user.getEmail());
        assertTrue(verifyHash("password", user.getPassword()));
        assertNull(user.getRole());
    }

    @Test
    void mappingToDto_returnsDtoWithSameValuesAsUserDto() {
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