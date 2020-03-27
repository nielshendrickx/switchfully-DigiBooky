package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.book.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.behavior.Informative;
import com.switchfully.javadocjuveniles.domain.user.builders.MemberBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import com.switchfully.javadocjuveniles.domain.user.userinfo.Address;
import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

import java.util.ArrayList;
import java.util.List;

public class Member implements Informative {
    private final String inss;
    private PersonalInfo personalInfo;
    private final Address address;
    private final UserRole role;
    private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    public Member(MemberBuilder memberBuilder) {
        personalInfo = memberBuilder.getPersonalInfo();
        inss = memberBuilder.getInss();
        address = memberBuilder.getAddress();
        role = memberBuilder.getRole();
        itemsBorrowed = new ArrayList<>();
    }

    public String getInss() {
        return inss;
    }

    @Override
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public UserRole getRole() {
        return role;
    }
}
