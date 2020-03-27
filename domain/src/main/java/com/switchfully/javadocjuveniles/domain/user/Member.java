package com.switchfully.javadocjuveniles.domain.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.switchfully.javadocjuveniles.domain.item.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private final String inss;
    private final Address address;
    private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    @JsonCreator
    public Member(UserBuilder userBuilder) {
        super(userBuilder);
        this.inss = userBuilder.getInss();
        this.address = userBuilder.getAddress();
        itemsBorrowed = new ArrayList<>();
    }

    public String getInss() {
        return inss;
    }

    public String getFirstName() {
        return super.getFirstName();
    }

    public String getLastName() {
        return super.getLastName();
    }

    public String getEmail() {
        return super.getEmail();
    }

    public String getPassword() {
        return super.getPassWord();
    }

    public Address getAddress() {
        return address;
    }

    public String getId() {
        return super.getId();
    }

    public List<Borrowable> getBorrowedItems() {
        return itemsBorrowed;
    }
}