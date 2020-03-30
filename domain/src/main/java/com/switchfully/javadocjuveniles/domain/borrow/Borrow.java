package com.switchfully.javadocjuveniles.domain.borrow;

import com.switchfully.javadocjuveniles.domain.item.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.Member;

import java.time.LocalDate;
import java.util.UUID;

public class Borrow {
    private final String id;
    private final Member member;
    private final Borrowable borrowable;
    private final LocalDate startDate;
    private final LocalDate dueDate;
    private final LocalDate endDate;

    public String getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Borrowable getBorrowable() {
        return borrowable;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Borrow(BorrowBuilder borrowBuilder) {
        id = UUID.randomUUID().toString();
        member = borrowBuilder.member;
        borrowable = borrowBuilder.borrowable;
        startDate = borrowBuilder.startDate;
        dueDate = borrowBuilder.dueDate;
        endDate = borrowBuilder.endDate;
    }

    public static class BorrowBuilder {
        private Member member;
        private Borrowable borrowable;
        private LocalDate startDate;
        private LocalDate dueDate;
        private LocalDate endDate;

        private BorrowBuilder() {

        }

        public static BorrowBuilder borrowBuilder() {
            return new BorrowBuilder();
        }

        public Borrow buildBorrow() {
            return new Borrow(this);
        }

        public BorrowBuilder withMember(Member member) {
            this.member = member;
            return this;
        }

        public BorrowBuilder withBorrowable(Borrowable borrowable) {
            this.borrowable = borrowable;
            return this;
        }

        public BorrowBuilder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public BorrowBuilder withDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public BorrowBuilder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }
    }

}
