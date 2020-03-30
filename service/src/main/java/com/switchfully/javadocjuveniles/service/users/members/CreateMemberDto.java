package com.switchfully.javadocjuveniles.service.users.members;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.javadocjuveniles.domain.user.Address;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import com.switchfully.javadocjuveniles.service.users.users.CreateUserDto;

public class CreateMemberDto extends CreateUserDto {
    private final String INSS;
    private final Address address;
    //private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    @JsonCreator
    public CreateMemberDto(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("INSS") String INSS, @JsonProperty("address") Address address) {
        super(firstName, lastName, email, password, UserRole.MEMBER);
        this.INSS = INSS;
        this.address = address;
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

    public String getINSS() {
        return INSS;
    }


}
