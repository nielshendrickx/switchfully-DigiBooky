package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.book.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.behavior.Informative;
import com.switchfully.javadocjuveniles.domain.user.builders.MemberBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.SecurityRole;
import com.switchfully.javadocjuveniles.domain.user.userinfo.Address;
import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.switchfully.javadocjuveniles.domain.user.feature.SecurityRole.MEMBER;

public class Member implements Informative {
    private final String id;
    private final String inss;
    private PersonalInfo personalInfo;
    private final Address address;
    private final SecurityRole securityRole = MEMBER;
    private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    public Member(MemberBuilder memberBuilder) {
        personalInfo = memberBuilder.getPersonalInfo();
        inss = memberBuilder.getInss();
        address = memberBuilder.getAddress();
        itemsBorrowed = new ArrayList<>();
        id = UUID.randomUUID().toString();
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
    public SecurityRole getRole() {
        return securityRole;
    }

    public List<Borrowable> getBorrowedItems() {
        return itemsBorrowed;
    }

}
