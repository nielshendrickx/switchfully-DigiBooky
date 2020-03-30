package com.switchfully.javadocjuveniles.api.security.authentication;

import com.switchfully.javadocjuveniles.domain.user.User;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class AuthenticationService {

    private List<User> usersList = newArrayList(
            UserBuilder.userBuilder()
                    .withFirstName("Adrien")
                    .withLastName("Hélin")
                    .withPassWord("funfunfun")
                    .withEmail("adrien.helin@gmail.com")
                    .withINSS("88.10.07-363.84")
                    .withRole(UserRole.ADMIN)
                    .buildUser(),
            UserBuilder.userBuilder()
                    .withFirstName("Sven")
                    .withLastName("De Potter")
                    .withPassWord("looser")
                    .withEmail("im.a.looser@gmail.com")
                    .withINSS("88.01.01-123.45")
                    .withRole(UserRole.LIBRARIAN)
                    .buildUser()
    );

    public User getUser(String firstName, String password) {
        return usersList.stream()
                .filter(externalAuthentication -> externalAuthentication.getFirstName().equals(firstName))
                .filter(externalAuthentication -> externalAuthentication.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
