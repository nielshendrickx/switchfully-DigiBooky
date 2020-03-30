package com.switchfully.javadocjuveniles.service.users.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;

public class CreateUserDto {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

}
