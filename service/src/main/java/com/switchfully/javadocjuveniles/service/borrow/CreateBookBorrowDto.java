package com.switchfully.javadocjuveniles.service.borrow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBookBorrowDto {
    private final String memberId;
    private final String bookISBN;

    @JsonCreator
    public CreateBookBorrowDto(@JsonProperty("memberId") String memberId, @JsonProperty("bookISBN")String bookISBN) {
        this.memberId = memberId;
        this.bookISBN = bookISBN;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBookISBN() {
        return bookISBN;
    }

}
