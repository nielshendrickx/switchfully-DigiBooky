package com.switchfully.javadocjuveniles.domain.exceptions;

public class PersonalInfoException extends RuntimeException {
    public PersonalInfoException() {
        super("Your profile is not finished. We need some additional info.");
    }
}
