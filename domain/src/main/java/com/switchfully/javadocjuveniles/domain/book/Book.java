package com.switchfully.javadocjuveniles.domain.book;


public class Book extends Item {
    private String ISBN;
    private Author author;


    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public void toggleAvailability() {

    }

    @Override
    public String getDetails() {
        return "The book title is:" + getTitle() + " and his ISBN number is:" + getISBN() + " and his author is:" + getAuthor() + "\n Summary:" + getSummary();
    }
}
