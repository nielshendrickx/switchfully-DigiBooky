package com.switchfully.javadocjuveniles.domain.exceptions;

public class ISBNNotFoundException extends  RuntimeException{
        public ISBNNotFoundException() {
            super("The book with given ISBN Number is not found.");
        }
}
