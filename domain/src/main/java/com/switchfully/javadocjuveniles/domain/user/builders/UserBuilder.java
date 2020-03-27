package com.switchfully.javadocjuveniles.domain.user.builders;

import com.switchfully.javadocjuveniles.domain.exceptions.PersonalInfoException;
import com.switchfully.javadocjuveniles.domain.user.Administrator;
import com.switchfully.javadocjuveniles.domain.user.Librarian;
import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

public class UserBuilder {
    private PersonalInfo personalInfo;

    protected UserBuilder() {
    }

    public static UserBuilder userBuilder() {
        return new UserBuilder();
    }

    public Librarian buildLibrarian(){
        if (!everythingIsFilledIn()) throw new PersonalInfoException();
        return new Librarian(this);
    }

    public Administrator buildAdministrator() {
        if (!everythingIsFilledIn()) throw new PersonalInfoException();
        return new Administrator(this);
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
