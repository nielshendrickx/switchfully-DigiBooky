package com.switchfully.javadocjuveniles.domain.user.interfaces;

import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;

public interface Createable {
    String getFirstName();

    String getLastName();

    String getEmail();

    UserRole getRole();

    String getPassword();
}
