package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.item.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private final String INSS;
    private final Address address;
    //private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    public Member(UserBuilder userBuilder) {
        super(userBuilder);
        this.INSS = userBuilder.getInss();
        this.address = userBuilder.getAddress();
    }

    public String getINSS() {
        return INSS;
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
}