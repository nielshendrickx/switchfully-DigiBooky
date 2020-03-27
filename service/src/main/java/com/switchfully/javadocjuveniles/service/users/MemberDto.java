package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.book.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.userinfo.Address;
import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

import java.util.List;

public class MemberDto {
    private PersonalInfo personalInfo;
    private final Address address;
    private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    public MemberDto(PersonalInfo personalInfo, Address address, List<Borrowable> itemsBorrowed) {
        this.personalInfo = personalInfo;
        this.address = address;
        this.itemsBorrowed = itemsBorrowed;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public Address getAddress() {
        return address;
    }

}
