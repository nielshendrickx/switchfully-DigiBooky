package com.switchfully.javadocjuveniles.domain.user.feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public enum Feature {
    REGISTER_NEW_ITEM(SecurityRole.LIBRARIAN, SecurityRole.ADMIN),
    VIEW_MEMBERS(SecurityRole.ADMIN),
    LEND_AN_ITEM(SecurityRole.MEMBER);

    private SecurityRole[] roles;

    Feature(SecurityRole... roles) {this.roles = roles; }

    public List<SecurityRole> getRoles() {
        return newArrayList(roles);
    }

    public static List<Feature> getFeaturesForRoles(List<String> rolesOfUserAsString) {
        List<SecurityRole> rolesOfUser = rolesOfUserAsString.stream()
                .map(SecurityRole::valueOf)
                .collect(Collectors.toList());
        return Arrays.stream(Feature.values())
                .filter(feature -> !Collections.disjoint(feature.getRoles(), rolesOfUser))
                .collect(Collectors.toList());
    }
}
