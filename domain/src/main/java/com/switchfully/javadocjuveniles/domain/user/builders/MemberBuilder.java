package com.switchfully.javadocjuveniles.domain.user.builders;

import com.switchfully.javadocjuveniles.domain.exceptions.PersonalInfoException;
import com.switchfully.javadocjuveniles.domain.user.Member;
import com.switchfully.javadocjuveniles.domain.user.feature.SecurityRole;
import com.switchfully.javadocjuveniles.domain.user.userinfo.Address;
import com.switchfully.javadocjuveniles.domain.user.userinfo.PersonalInfo;

public class MemberBuilder {
    private PersonalInfo personalInfo;
    private String inss;
    private Address address;

    protected MemberBuilder() {
    }

    public static MemberBuilder memberBuilder() {
        return new MemberBuilder();
    }

    public Member buildMember() {
        if (!everythingIsFilledIn()) {
            throw new PersonalInfoException();
        }
        return new Member(this);
    }

    private boolean everythingIsFilledIn() {
        return inss != null &&
                personalInfo != null &&
                address != null;
    }

    public MemberBuilder withPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
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

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public String getInss() {
        return inss;
    }

    public Address getAddress() {
        return address;
    }
}
