package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.user.behavior.Informative;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

public class Librarian implements Informative {
    private final PersonalInfo personalInfo;
    private final UserRole role;

    public Librarian(UserBuilder userBuilder) {
        personalInfo = userBuilder.getPersonalInfo();
        role = userBuilder.getRole();
    }

    @Override
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    @Override
    public UserRole getRole() {
        return role;
    }
}
