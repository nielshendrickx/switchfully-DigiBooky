package com.switchfully.javadocjuveniles.domain.user.builders;

import com.switchfully.javadocjuveniles.domain.exceptions.PersonalInfoException;
import com.switchfully.javadocjuveniles.domain.user.User;
import com.switchfully.javadocjuveniles.domain.user.feature.SecurityRole;
import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

public class UserBuilder {
    private PersonalInfo personalInfo;
    private SecurityRole securityRole;

    protected UserBuilder() {
    }

    public static UserBuilder userBuilder() {
        return new UserBuilder();
    }

    public User buildLibrarian(){
        if (!everythingIsFilledIn()) throw new PersonalInfoException();
        securityRole = SecurityRole.LIBRARIAN;
        return new User(this);
    }

    public User buildAdministrator() {
        if (!everythingIsFilledIn()) throw new PersonalInfoException();
        securityRole = SecurityRole.ADMIN;
        return new User(this);
    }

    private boolean everythingIsFilledIn() {
        return personalInfo != null;
    }

    public UserBuilder withPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
        return this;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }
}
