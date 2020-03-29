package com.switchfully.javadocjuveniles.domain.exceptions;

public class InssAlreadyRegisteredException extends RuntimeException {
    public InssAlreadyRegisteredException(String inss) {
        super("The provided inss: " + inss +  " is already used");
    }
}
