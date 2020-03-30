package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.item.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.domain.user.interfaces.Createable;
import com.switchfully.javadocjuveniles.domain.user.interfaces.ExtraInformation;
import com.switchfully.javadocjuveniles.domain.user.interfaces.Identable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member extends User implements Createable, Identable, ExtraInformation {

    private final String INSS;
    private final Address address;
    //private final List<Fines> fines;

    public Member(UserBuilder userBuilder) {
        super(userBuilder);
        this.INSS = userBuilder.getInss();
        this.address = userBuilder.getAddress();
    }

    @Override
    public String getINSS() {
        return INSS;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(INSS, member.INSS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(INSS);
    }
}