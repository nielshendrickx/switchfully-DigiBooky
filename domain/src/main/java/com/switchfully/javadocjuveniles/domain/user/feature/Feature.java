package com.switchfully.javadocjuveniles.domain.user.feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public enum Feature {
    REGISTER_NEW_ITEM(UserRole.LIBRARIAN, UserRole.ADMIN),
    VIEW_MEMBERS(UserRole.ADMIN),
    REGISTER_LIBRARIAN(UserRole.ADMIN),
    REGISTER_ADMIN(UserRole.ADMIN),
    LEND_AN_ITEM(UserRole.MEMBER);

    private UserRole[] roles;

    Feature(UserRole... roles) {this.roles = roles; }

    public List<UserRole> getRoles() {
        return newArrayList(roles);
    }

    public static List<Feature> getFeaturesForRoles(List<String> rolesOfUserAsString) {
        List<UserRole> rolesOfUser = rolesOfUserAsString.stream()
                .map(UserRole::valueOf)
                .collect(Collectors.toList());
        return Arrays.stream(Feature.values())
                .filter(feature -> !Collections.disjoint(feature.getRoles(), rolesOfUser))
                .collect(Collectors.toList());
    }
}
