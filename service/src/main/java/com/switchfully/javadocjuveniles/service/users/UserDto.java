package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;

public class UserDto {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email; //TODO implement format validation in the controller & unique
    private final UserRole role;
    private String passWord;

    public UserDto(String id, String firstName, String lastName, String email, String password, UserRole userRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = userRole;
        this.passWord = password;
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

    public String getPassWord() {
        return passWord;
    }
}
