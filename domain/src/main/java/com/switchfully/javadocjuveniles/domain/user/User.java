package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import com.switchfully.javadocjuveniles.domain.user.interfaces.Createable;
import com.switchfully.javadocjuveniles.domain.user.interfaces.Identable;

import java.util.UUID;

public class User implements Identable, Createable {
    private final String id = UUID.randomUUID().toString();
    private final String firstName;
    private final String lastName;
    private final String email;
    private final UserRole role;
    private String passWord;

    public User(UserBuilder userBuilder) {
        firstName = userBuilder.getFirstName();
        lastName = userBuilder.getLastName();
        email = userBuilder.getEmail();
        role = userBuilder.getRole();
        passWord = userBuilder.getPassWord();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public UserRole getRole() {
        return role;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getId() {
        return id;
    }
}