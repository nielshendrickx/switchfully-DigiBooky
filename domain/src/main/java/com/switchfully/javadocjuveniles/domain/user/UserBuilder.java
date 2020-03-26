package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;

import java.util.UUID;

public class UserBuilder {
    private String firstName;
    private String lastName;
    private String eMail;
    private UserRole role;
    private String passWord;

    private UserBuilder() {
    }

    public static UserBuilder userBuilder() {
        return new UserBuilder();
    }

    public User build() {
        return new User(this);
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withEMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public UserBuilder withRole(UserRole role) {
        this.role = role;
        return this;
    }

    public UserBuilder withPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEMail() {
        return eMail;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPassWord() {
        return passWord;
    }
}
