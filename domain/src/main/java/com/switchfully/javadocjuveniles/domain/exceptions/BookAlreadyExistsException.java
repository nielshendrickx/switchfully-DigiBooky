package com.switchfully.javadocjuveniles.domain.exceptions;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException() {
        super("The book is already in the database");
    }
}
