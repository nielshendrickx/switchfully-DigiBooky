package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder;

import java.util.UUID;

public class Address {
    private final String id;
    private final String street;
    private final String streetNumber;
    private final String postalCode;
    private final String city;

    public Address(AddressBuilder addressBuilder) {
        id = UUID.randomUUID().toString();
        street = addressBuilder.getStreet();
        streetNumber = addressBuilder.getStreetNumber();
        postalCode = addressBuilder.getPostalCode();
        city = addressBuilder.getCity();
    }
}