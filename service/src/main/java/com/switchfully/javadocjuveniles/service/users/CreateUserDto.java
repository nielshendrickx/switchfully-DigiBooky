package com.switchfully.javadocjuveniles.service.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import com.switchfully.javadocjuveniles.domain.user.interfaces.Createable;

public class CreateUserDto implements Createable {
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role;
    private String password;

    @JsonCreator
    public CreateUserDto(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("userRole") UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = userRole;
        this.password = password;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public UserRole getRole() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

}
