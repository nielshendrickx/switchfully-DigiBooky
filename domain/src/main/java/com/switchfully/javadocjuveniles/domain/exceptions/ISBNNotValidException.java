package com.switchfully.javadocjuveniles.domain.exceptions;

public class ISBNNotValidException extends RuntimeException {
    public ISBNNotValidException() {
        super("The provided ISBN is not valid");
    }
}
