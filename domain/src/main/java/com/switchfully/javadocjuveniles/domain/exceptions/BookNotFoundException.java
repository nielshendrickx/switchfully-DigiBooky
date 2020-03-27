package com.switchfully.javadocjuveniles.domain.exceptions;

public class BookNotFoundException extends  RuntimeException{
        public BookNotFoundException(String message) {
            super("The book with given " + message + " is not found.");
        }
}

