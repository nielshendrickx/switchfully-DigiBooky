package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;

import java.util.UUID;

public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String eMail;
    private UserRole role;
    private String passWord;

    protected User(UserBuilder userBuilder) {
        id = UUID.randomUUID().toString();
        firstName = userBuilder.getFirstName();
        lastName = userBuilder.getLastName();
        eMail = userBuilder.getEMail();
        role = userBuilder.getRole();
        passWord = userBuilder.getPassWord();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPassWord() {
        return passWord;
    }
}
