package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.book.Author;

import java.time.LocalDate;

public class BookDto {
    private String ID;
    private String ISBN;
    private Author author;
    private String title;
    private String summary;
    private int numberOfCopies;
    private LocalDate dateAdded;
    private float initialPrice;

    public BookDto(String ID, String ISBN, Author author, String title, String summary
            , int numberOfCopies, LocalDate dateAdded, float initialPrice) {
        this.ID = ID;
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.summary = summary;
        this.numberOfCopies = numberOfCopies;
        this.dateAdded = dateAdded;
        this.initialPrice = initialPrice;
    }


    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public float getInitialPrice() {
        return initialPrice;
    }

    public String getID() {
        return ID;
    }
}
