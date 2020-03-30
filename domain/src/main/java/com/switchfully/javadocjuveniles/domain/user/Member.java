package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.fines.FineType;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member extends User {

    private final String INSS;
    private final Address address;
    private final List<FineType> fines;

    public Member(UserBuilder userBuilder) {
        super(userBuilder);
        this.INSS = userBuilder.getInss();
        this.address = userBuilder.getAddress();
        this.fines = new ArrayList<>();
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
        return super.getPassword();
    }

    public Address getAddress() {
        return address;
    }

    public String getId() {
        return super.getId();
    }

    public List<FineType> getFines() {
        return fines;
    }

    public void addFine(FineType fine) {
        fines.add(fine);
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