package com.switchfully.javadocjuveniles.service.users.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;

public class CreateLibrarianDto extends CreateUserDto {

        @JsonCreator
        public CreateLibrarianDto(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("email") String email, @JsonProperty("password") String password) {
            super(firstName, lastName, email, password, UserRole.LIBRARIAN);
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

    }
