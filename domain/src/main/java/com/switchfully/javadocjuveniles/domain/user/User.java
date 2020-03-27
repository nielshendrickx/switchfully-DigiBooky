package com.switchfully.javadocjuveniles.domain.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;

import java.util.UUID;

public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email; //TODO implement format validation in the controller & unique
    private final UserRole role;
    private String passWord;

    @JsonCreator
    public User(UserBuilder userBuilder) {
        id = UUID.randomUUID().toString();
        firstName = userBuilder.getFirstName();
        lastName = userBuilder.getLastName();
        email = userBuilder.getEmail();
        role = userBuilder.getRole();
        passWord = userBuilder.getPassWord();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPassWord() {
        return passWord;
    }

    protected String getId() {
        return id;
    }
}