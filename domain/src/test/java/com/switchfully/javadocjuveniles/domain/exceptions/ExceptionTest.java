package com.switchfully.javadocjuveniles.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {
    @Test
    void InssException_returnsCorrectMessage() {
        assertEquals("The provided inss: 1234 is not valid, must match pattern: XX.XX.XX.XXX.XX", new InssNotValidException("1234").getMessage());
    }

    @Test
    void emailException_returnsCorrectMessage() {
        assertEquals("The provided email: test is not valid", new EmailNotValidException("test").getMessage());
    }

    @Test
    void inssAlreadyRegisteredException_returnsCorrectMessage() {
        assertEquals("The provided inss: 00.00.00.000.00 is already used", new InssAlreadyRegisteredException("00.00.00.000.00").getMessage());
    }

    @Test
    void memberNotFoundException_returnsCorrectMessage() {
        assertEquals("Could not find the user.", new MemberNotFoundException().getMessage());
    }

    @Test
    void bookNotFoundException_returnsCorrectMessage() {
        assertEquals("The book with given test is not found.", new BookNotFoundException("test").getMessage());
    }

    @Test
    void bookDoesNotExistException_returnsCorrectMessage() {
        assertEquals("The book does not exist", new BookDoesNotExistException().getMessage());
    }

    @Test
    void bookAlreadyExistException_returnsCorrectMessage() {
        assertEquals("The book is already in the database", new BookAlreadyExistsException().getMessage());
    }

    @Test
    void bookIsNotValidException_returnsCorrectMessage() {
        assertEquals("The book is not valid", new BookIsNotValidException().getMessage());
    }

    @Test
    void ISBNNotValidException_returnsCorrectMessage() {
        assertEquals("The provided ISBN is not valid", new ISBNNotValidException().getMessage());
    }

    @Test
    void NoMoreItemsAvailableException_returnsCorrectMessage() {
        assertEquals("No more items available!", new NoMoreItemsAvailableException().getMessage());
    }
}