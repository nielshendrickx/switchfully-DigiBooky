package com.switchfully.javadocjuveniles.domain.item.book;

import com.switchfully.javadocjuveniles.domain.item.Item;

import java.time.LocalDate;
import java.util.Objects;

public class Book extends Item {
    private String ISBN;
    private Author author;

    public Book(String title, String summary, int numberOfCopies, LocalDate dateAdded, String ISBN, Author author) {
        super(title, summary, numberOfCopies, dateAdded);
        this.ISBN = ISBN;
        this.author = author;
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
    public String getDetails() {
        return "The book title is:" + getTitle() + " and his ISBN number is:" + getISBN() + " and his author is:" + getAuthor() + "\n Summary:" + getSummary();
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
}
