package com.switchfully.javadocjuveniles.domain.user.builders;

import com.switchfully.javadocjuveniles.domain.user.Address;
import com.switchfully.javadocjuveniles.domain.user.Member;

public class MemberBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String inss;
    private Address address;

    private MemberBuilder() {
    }

    /**
     * Static factory method
     */
    public static MemberBuilder memberBuilder() {
        return new MemberBuilder();
    }

    public Member build() {
        return new Member(this);
    }

    public MemberBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MemberBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MemberBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public MemberBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public MemberBuilder withINSS(String inss) {
        this.inss = inss;
        return this;
    }

    public MemberBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getInss() {
        return inss;
    }

    public Address getAddress() {
        return address;
    }
}