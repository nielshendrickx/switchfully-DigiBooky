package com.switchfully.javadocjuveniles.domain.fines;

import com.switchfully.javadocjuveniles.domain.borrow.Borrow;

public interface FineType {
    void calculateFine(Borrow borrow);
}
