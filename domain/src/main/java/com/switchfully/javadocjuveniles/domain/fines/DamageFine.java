package com.switchfully.javadocjuveniles.domain.fines;

import com.switchfully.javadocjuveniles.domain.borrow.Borrow;

import java.time.LocalDate;

public class DamageFine implements FineType {

    private double fineAmount;
    public static final int START_AMOUNT = 1;
    public static final double ADD_ON_PERCENTAGE = 0.2;
    public static final int MINIMUM_FINE = 4;

    @Override
    public void calculateFine(Borrow borrow) {
        double fine = borrow.getBorrowable().getInitialPrice() * (START_AMOUNT - (LocalDate.now().getYear() - borrow.getBorrowable().getDateAdded().getYear() * ADD_ON_PERCENTAGE));
        if (fine < MINIMUM_FINE) {
            fine = 4;
        }
        fineAmount += fine;
    }
}
