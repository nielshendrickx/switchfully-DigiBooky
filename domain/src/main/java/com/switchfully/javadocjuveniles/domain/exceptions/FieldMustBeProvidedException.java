package com.switchfully.javadocjuveniles.domain.exceptions;

public class FieldMustBeProvidedException extends RuntimeException {
    public FieldMustBeProvidedException(String message) {
        super("The book must have at least" + message );
    }
}
