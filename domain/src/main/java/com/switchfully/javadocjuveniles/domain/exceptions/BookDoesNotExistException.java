package com.switchfully.javadocjuveniles.domain.exceptions;

public class BookDoesNotExistException extends RuntimeException {
    public BookDoesNotExistException() {
        super("The book does not exist");
    }
}
