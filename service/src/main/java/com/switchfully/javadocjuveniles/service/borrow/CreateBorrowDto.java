package com.switchfully.javadocjuveniles.service.borrow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.javadocjuveniles.domain.item.Borrowable;
import com.switchfully.javadocjuveniles.service.users.members.MemberDto;

import java.time.LocalDate;

public class CreateBorrowDto {
    private final MemberDto member;
    private final Borrowable borrowable;
    private final LocalDate startDate;
    private final LocalDate dueDate;
    private final LocalDate endDate;

    @JsonCreator
    public CreateBorrowDto(@JsonProperty("member") MemberDto member, @JsonProperty("borrowable")Borrowable borrowable, @JsonProperty("startDate") LocalDate startDate, @JsonProperty("dueDate") LocalDate dueDate, @JsonProperty("endDate") LocalDate endDate) {
        this.member = member;
        this.borrowable = borrowable;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.endDate = endDate;
    }

    public MemberDto getMember() {
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
}
