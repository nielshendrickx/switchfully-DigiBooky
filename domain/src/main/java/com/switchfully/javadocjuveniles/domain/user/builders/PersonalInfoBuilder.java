package com.switchfully.javadocjuveniles.domain.user.builders;

import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

public class PersonalInfoBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String passWord;

    protected PersonalInfoBuilder() {
    }

    public static PersonalInfoBuilder personalInfoBuilder() {
        return new PersonalInfoBuilder();
    }

    public PersonalInfo build() {
        return new PersonalInfo(this);
    }

    public PersonalInfoBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonalInfoBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonalInfoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonalInfoBuilder withPassWord(String passWord) {
        this.passWord = passWord;
        return this;
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
