package com.switchfully.javadocjuveniles.service.borrow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.javadocjuveniles.domain.item.Item;
import com.switchfully.javadocjuveniles.service.users.members.MemberDto;

import java.time.LocalDate;

public class BorrowDto {
    private final String id;
    private final MemberDto member;
    private final Item item;
    private final LocalDate startDate;
    private final LocalDate dueDate;
    private final LocalDate endDate;

    @JsonCreator
    public BorrowDto(@JsonProperty("id") String id, @JsonProperty("member") MemberDto member, @JsonProperty("item")Item item, @JsonProperty("startDate") LocalDate startDate, @JsonProperty("dueDate") LocalDate dueDate, @JsonProperty("endDate") LocalDate endDate) {
        this.id = id;
        this.member = member;
        this.item = item;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public MemberDto getMember() {
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
}
