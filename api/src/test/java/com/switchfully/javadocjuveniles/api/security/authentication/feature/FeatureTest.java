package com.switchfully.javadocjuveniles.api.security.authentication.feature;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class FeatureTest {

    @Test
    void getFeaturesForRoles_GivenFeatureContainsOneOfTheRoles_ThenReturnAllFeaturesContainingOneOfThoseRoles() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(UserRole.ADMIN.name()));

        Assertions.assertThat(actual).contains(Feature.VIEW_MEMBERS, Feature.REGISTER_NEW_ITEM);
        Assertions.assertThat(actual).doesNotContain(Feature.LEND_AN_ITEM);
    }

    @Test
    void getFeaturesForRoles_GivenNoRolesSupplied_ThenReturnNoFeatures() {

        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList());

        Assertions.assertThat(actual).isEmpty();
    }
}