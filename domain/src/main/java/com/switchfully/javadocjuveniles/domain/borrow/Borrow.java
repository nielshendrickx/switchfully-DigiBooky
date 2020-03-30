package com.switchfully.javadocjuveniles.domain.borrow;

import com.switchfully.javadocjuveniles.domain.item.Item;
import com.switchfully.javadocjuveniles.domain.user.Member;

import java.time.LocalDate;
import java.util.UUID;

public class Borrow {
    private final String id;
    private final Member member;
    private final Item item;
    private final LocalDate startDate;
    private final LocalDate dueDate;
    private LocalDate endDate;

    public String getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Item getItem() {
        return item;
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
        item = borrowBuilder.item;
        startDate = borrowBuilder.startDate;
        dueDate = borrowBuilder.dueDate;
    }

    public Borrow setEndDate() {
        this.endDate = LocalDate.now();
        return this;
    }

    public static class BorrowBuilder {
        private Member member;
        private Item item;
        private LocalDate startDate;
        private LocalDate dueDate;

        private BorrowBuilder() {

        }

        public static BorrowBuilder borrowBuilder() {
            return new BorrowBuilder();
        }

        public Borrow buildBorrow() {
            setStartDueDate();
            return new Borrow(this);
        }

        private void setStartDueDate() {
            this.startDate = LocalDate.now();
            this.dueDate = startDate.plusWeeks(3);
        }

        public BorrowBuilder withMember(Member member) {
            this.member = member;
            return this;
        }

        public BorrowBuilder withBorrowable(Item item) {
            this.item = item;
            return this;
        }
    }

}
