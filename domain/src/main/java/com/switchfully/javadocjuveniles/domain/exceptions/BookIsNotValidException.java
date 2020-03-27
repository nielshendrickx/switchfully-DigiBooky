package com.switchfully.javadocjuveniles.domain.exceptions;

public class BookIsNotValidException extends RuntimeException{
        public BookIsNotValidException() {
            super("The book is not valid");
        }
}
