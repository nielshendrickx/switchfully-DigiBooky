package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.user.behavior.Informative;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.SecurityRole;
import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

import static com.switchfully.javadocjuveniles.domain.user.feature.SecurityRole.LIBRARIAN;

public class Librarian implements Informative {
    private final PersonalInfo personalInfo;
    private final SecurityRole securityRole = LIBRARIAN;

    public Librarian(UserBuilder userBuilder) {
        personalInfo = userBuilder.getPersonalInfo();
    }

    @Override
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    @Override
    public SecurityRole getRole() {
        return securityRole;
    }
}
