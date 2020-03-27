package com.switchfully.javadocjuveniles.domain.exceptions;

public class BookIDNotFoundException extends  RuntimeException{
        public BookIDNotFoundException() {
            super("The book with given ID is not found.");
        }
}
