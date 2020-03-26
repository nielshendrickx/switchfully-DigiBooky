package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.book.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder;
import com.switchfully.javadocjuveniles.domain.user.builders.MemberBuilder;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private final String inss;
    private final Address address;
    private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    public Member(MemberBuilder memberBuilder) {
        super(memberBuilder.getFirstName(), memberBuilder.getLastName(), memberBuilder.getEmail(), UserRole.MEMBER, memberBuilder.getPassword());
        this.inss = memberBuilder.getInss();
        this.address = memberBuilder.getAddress();
        itemsBorrowed = new ArrayList<>();
    }

    public String getInss() {
        return inss;
    }


}
