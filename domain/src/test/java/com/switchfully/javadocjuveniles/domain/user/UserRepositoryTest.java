package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void ifEmail_doesntExist_returnTrue() {
        //GIVEN
        UserRepository userRepository = new UserRepository();
        User user1 = UserBuilder.userBuilder()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@dead.com")
                .withPassWord("dead")
                .withINSS("63.07.13-123.45")
                .buildMember();
        userRepository.registerNewUser(user1);
        //WHEN
        boolean emailChecked = userRepository.isEmailAvailable("test@dgc.com");
        //THEN
        assertTrue(emailChecked);
    }

    @Test
    void ifEmail_doesExist_returnFalse() {
        //GIVEN
        UserRepository userRepository = new UserRepository();
        User user1 = UserBuilder.userBuilder()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@dead.com")
                .withPassWord("dead")
                .withINSS("63.07.13-123.45")
                .buildMember();
        userRepository.registerNewUser(user1);
        //THEN
        assertThrows(EmailAlreadyRegisteredException.class, () -> userRepository.isEmailAvailable("john.doe@dead.com"));
    }

    @Test
    void ifRepo_isEmpty_shouldReturnTrue() {
        //GIVEN
        UserRepository userRepository = new UserRepository();
        //WHEN
        boolean emailChecked = userRepository.isEmailAvailable("test@dgc.com");
        //THEN
        assertTrue(emailChecked);
    }

}