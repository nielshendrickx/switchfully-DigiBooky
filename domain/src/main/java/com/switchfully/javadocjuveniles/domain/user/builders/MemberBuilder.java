package com.switchfully.javadocjuveniles.domain.user.builders;

import com.switchfully.javadocjuveniles.domain.user.Address;
import com.switchfully.javadocjuveniles.domain.user.Member;

public class MemberBuilder {

    private String inss;
    private AddressBuilder addressBuilder;
    private UserBuilder userBuilder;

    private MemberBuilder() {
    }

    /**
     * Static factory method
     */
    public static MemberBuilder memberBuilder() {
        return new MemberBuilder();
    }

    public Member build() {
        return new Member(userBuilder, this, addressBuilder);
    }

    public MemberBuilder withINSS(String inss) {
        this.inss = inss;
        return this;
    }

    public String getInss() {
        return inss;
    }

}