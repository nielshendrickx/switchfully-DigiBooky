package com.switchfully.javadocjuveniles.service.borrow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBorrowDto {
    private final String memberId;
    private final String borrowableId;

    @JsonCreator
    public CreateBorrowDto(@JsonProperty("memberId") String memberId, @JsonProperty("borrowableId")String borrowableId) {
        this.memberId = memberId;
        this.borrowableId = borrowableId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBorrowableId() {
        return borrowableId;
    }

}
