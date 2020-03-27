package com.switchfully.javadocjuveniles.domain.user.behavior;

import com.switchfully.javadocjuveniles.domain.user.feature.SecurityRole;
import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

public interface Informative {
    PersonalInfo getPersonalInfo();
    SecurityRole getRole();
}
