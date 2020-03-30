package com.switchfully.javadocjuveniles.domain.fines;

import com.switchfully.javadocjuveniles.domain.borrow.Borrow;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OverdueFine implements FineType {

    private double fineAmount;
    public static final int START_AMOUNT = 5;
    public static final int AMOUNT_EXTRA_PER_WEEK = 2;
    private static final String message = "You received a fine for returning your item past due date.";

    @Override
    public void calculateFine(Borrow borrow) {
        fineAmount += START_AMOUNT + AMOUNT_EXTRA_PER_WEEK * (ChronoUnit.WEEKS.between(borrow.getEndDate(), borrow.getDueDate()));
    }

    @Override
    public double getFineAmount() {
        return fineAmount;
    }
}
