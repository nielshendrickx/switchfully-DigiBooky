package com.switchfully.javadocjuveniles.domain.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException {
    public EmailAlreadyRegisteredException(String email) {
        super("The provided email: " + email +  " is already used");
    }
}