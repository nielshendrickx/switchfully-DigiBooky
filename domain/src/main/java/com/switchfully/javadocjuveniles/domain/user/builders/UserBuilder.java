package com.switchfully.javadocjuveniles.domain.user.builders;

import com.switchfully.javadocjuveniles.domain.user.Administrator;
import com.switchfully.javadocjuveniles.domain.user.Librarian;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

public class UserBuilder {
    private PersonalInfo personalInfo;
    private UserRole role;

    protected UserBuilder() {
    }

    public static UserBuilder userBuilder() {
        return new UserBuilder();
    }

    public Librarian buildLibrarian(){
        this.role = UserRole.LIBRARIAN;
        return new Librarian(this);
    }

    public Administrator buildAdministrator() {
        this.role = UserRole.ADMIN;
        return new Administrator(this);
    }

    public UserBuilder withPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
        return this;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public UserRole getRole() {
        return role;
    }
}
