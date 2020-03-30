package com.switchfully.javadocjuveniles.domain.exceptions;

public class NoMoreItemsAvailableException extends RuntimeException {
    public NoMoreItemsAvailableException() {
        super("No more items available!");
    }
}
