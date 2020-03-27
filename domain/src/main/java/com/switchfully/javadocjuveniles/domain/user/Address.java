package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder;

public class Address {

    private final String street;
    private final String streetNumber;
    private final String postalCode;
    private final String city;

    public Address(AddressBuilder addressBuilder) {
        street = addressBuilder.getStreet();
        streetNumber = addressBuilder.getStreetNumber();
        postalCode = addressBuilder.getPostalCode();
        city = addressBuilder.getCity();
    }
}