package com.switchfully.javadocjuveniles.domain.item.book;

import com.switchfully.javadocjuveniles.domain.exceptions.FieldMustBeProvidedException;
import com.switchfully.javadocjuveniles.domain.exceptions.ISBNNotValidException;
import com.switchfully.javadocjuveniles.domain.item.Item;
import org.apache.commons.validator.routines.ISBNValidator;

import java.time.LocalDate;
import java.util.Objects;

public class Book extends Item {
    private String ISBN;
    private Author author;

    public Book (BookBuilder bookBuilder){
        super(bookBuilder.title, bookBuilder.summary, bookBuilder.numberOfCopies
                , bookBuilder.initialPrice);
        this.ISBN = bookBuilder.ISBN;
        this.author = bookBuilder.author;
    }

    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getISBN().equals(book.getISBN()) &&
                getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getISBN(), getAuthor());
    }

    public static class BookBuilder {
        private String ISBN;
        private Author author;
        private String title;
        private String summary;
        private int numberOfCopies;
        private float initialPrice;

        private BookBuilder(){}
        public static BookBuilder bookBuilder() {
            return new BookBuilder();
        }

        public Book build() {
            if(title == null) {
                throw new FieldMustBeProvidedException("Title");
            } else if (ISBN == null){
                throw new FieldMustBeProvidedException("ISBN");
            }else if (author.getLastName() == null) {
                throw new FieldMustBeProvidedException("Author's last name");
            }
            return new Book(this);
        }

        public BookBuilder withISBN(String ISBN) {
            if(!validateISBN(ISBN)){
                throw new ISBNNotValidException();
            }
            this.ISBN = ISBN;
            return this;
        }

        private boolean validateISBN(String ISBN) {
            return new ISBNValidator().isValidISBN13(ISBN);
        }

        public BookBuilder withAuthor(Author author) {
            this.author = author;
            return this;
        }
        public BookBuilder withTitle(String  title) {
            this.title = title;
            return this;
        }
        public BookBuilder withSummary(String summary) {
            this.summary = summary;
            return this;
        }
        public BookBuilder withNumberOfCopies(int numberOfCopies) {
            this.numberOfCopies = numberOfCopies;
            return this;
        }

        public BookBuilder withInitialPrice(float initialPrice) {
            this.initialPrice = initialPrice;
            return this;
        }
    }
}
