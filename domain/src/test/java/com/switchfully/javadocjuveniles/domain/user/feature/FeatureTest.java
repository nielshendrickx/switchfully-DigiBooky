package com.switchfully.javadocjuveniles.domain.user.feature;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

class FeatureTest {
    @Test
    void getFeaturesForRoles_GivenFeatureContainsOneOfTheRoles_ThenReturnAllFeaturesContainingOneOfThoseRoles() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(UserRole.ADMIN.name()));

        assertThat(actual).contains(Feature.VIEW_MEMBERS, Feature.REGISTER_ADMIN, Feature.REGISTER_LIBRARIAN);
        assertThat(actual).doesNotContain(Feature.LEND_AN_ITEM);
    }

    @Test
    void getFeaturesForRoles_GivenNoRolesSupplied_ThenReturnNoFeatures() {

        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList());

        assertThat(actual).isEmpty();
    }

}