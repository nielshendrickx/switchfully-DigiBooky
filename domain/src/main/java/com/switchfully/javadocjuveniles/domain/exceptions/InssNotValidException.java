package com.switchfully.javadocjuveniles.domain.exceptions;

public class InssNotValidException extends RuntimeException {
    public InssNotValidException(String inss) {
        super("The provided inss: " + inss +  " is not valid, must match pattern: XX.XX.XX.XXX.XX");
    }
}
