package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.item.book.Author;

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

    public BookDto() {
    }

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

    public String getID() {
        return ID;
    }

    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }


    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public String getTitle() {
        return title;
    }


    public String getSummary() {
        return summary;
    }


    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public float getInitialPrice() {
        return initialPrice;
    }
}
