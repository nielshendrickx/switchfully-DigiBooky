package com.switchfully.javadocjuveniles.domain.book;

import java.util.UUID;

public class Author {
    private final String ID;
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.ID = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
