package com.switchfully.javadocjuveniles.domain.user.userinfo;

import com.switchfully.javadocjuveniles.domain.user.builders.PersonalInfoBuilder;

import java.util.UUID;

public class PersonalInfo {
    protected final String email; //TODO implement format validation in the controller & unique
    protected final String id;
    protected final String firstName;
    protected final String lastName;
    protected String passWord;

    public PersonalInfo(PersonalInfoBuilder personalInfoBuilder) {
        email = personalInfoBuilder.getEmail();
        id = UUID.randomUUID().toString();
        firstName = personalInfoBuilder.getFirstName();
        lastName = personalInfoBuilder.getLastName();
        passWord = personalInfoBuilder.getPassWord();
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

    public String getPassWord() {
        return passWord;
    }
}
