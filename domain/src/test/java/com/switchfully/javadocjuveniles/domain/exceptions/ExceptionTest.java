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
}