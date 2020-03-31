package com.switchfully.javadocjuveniles.domain.user.feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public enum Feature {
    VIEW_MEMBERS(UserRole.ADMIN),
    REGISTER_ADMIN(UserRole.ADMIN),
    REGISTER_LIBRARIAN(UserRole.ADMIN),
    REGISTER_NEW_ITEM(UserRole.LIBRARIAN),
    UPDATE_ITEM(UserRole.LIBRARIAN),
    DELETE_ITEM(UserRole.LIBRARIAN),
    RESTORE_ITEM(UserRole.LIBRARIAN),
    LEND_AN_ITEM(UserRole.MEMBER),
    RETURN_AN_ITEM(UserRole.MEMBER),
    VIEW_LENT_ITEMS(UserRole.LIBRARIAN),
    VIEW_OVERDUE_ITEMS(UserRole.LIBRARIAN),
    VIEW_ITEM_DETAILS(UserRole.MEMBER),
    VIEW_ALL_DETAILS(UserRole.LIBRARIAN),
    CREATE_OVERDUE_FINE(UserRole.LIBRARIAN),
    CREATE_DAMAGE_FINE(UserRole.LIBRARIAN),
    VIEW_LENDING_HISTORY(UserRole.LIBRARIAN);

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
