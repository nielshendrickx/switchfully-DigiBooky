package com.switchfully.javadocjuveniles.domain.fines;

import com.switchfully.javadocjuveniles.domain.borrow.Borrow;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.switchfully.javadocjuveniles.domain.borrow.Borrow.BorrowBuilder.borrowBuilder;
import static org.junit.jupiter.api.Assertions.*;

class OverdueFineTest {
    @Test
    void notAFullWeek_shouldReturn_fiveEuroFine() {
        // Given
        LocalDate endDate = LocalDate.now();
        LocalDate dueDate = endDate.minusDays(5);
//        Borrow borrow = borrowBuilder()
//                .withBorrowable(bookRepository)
        // When

        // Then

    }
}
