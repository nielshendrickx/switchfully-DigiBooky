package com.switchfully.javadocjuveniles.domain.item.book;

import com.switchfully.javadocjuveniles.domain.exceptions.FieldMustBeProvidedException;

import java.util.Objects;
import java.util.UUID;

public class Author {
    private final String ID;
    private String firstName;
    private String lastName;

    public Author(AuthorBuilder authorBuilder) {
        this.ID = UUID.randomUUID().toString();
        this.firstName = authorBuilder.firstName;
        this.lastName = authorBuilder.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getFirstName(), author.getFirstName()) &&
                Objects.equals(getLastName(), author.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    public static class AuthorBuilder{
        private String firstName;
        private String lastName;

        private AuthorBuilder(){}
        public static AuthorBuilder authorBuilder() {
            return new AuthorBuilder();
        }

        public Author build() {
            if (lastName == null) {
                throw new FieldMustBeProvidedException("Author's last name");
            }
            return new Author(this);
        }

        public AuthorBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public AuthorBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
    }
}
