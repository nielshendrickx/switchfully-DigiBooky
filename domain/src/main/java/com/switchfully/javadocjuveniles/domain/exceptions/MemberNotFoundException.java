package com.switchfully.javadocjuveniles.domain.exceptions;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException() {
        super("Could not find the user.");
    }
}
