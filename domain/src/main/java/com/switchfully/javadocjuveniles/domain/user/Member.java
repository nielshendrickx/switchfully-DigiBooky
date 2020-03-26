package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.book.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder;
import com.switchfully.javadocjuveniles.domain.user.builders.MemberBuilder;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private final String inss;
    private final Address address;
    private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    public Member(UserBuilder userBuilder, MemberBuilder memberBuilder, AddressBuilder addressBuilder) {
        super(userBuilder);
        this.inss = memberBuilder.getInss();
        this.address = addressBuilder.build();
        itemsBorrowed = new ArrayList<>();
    }



}
