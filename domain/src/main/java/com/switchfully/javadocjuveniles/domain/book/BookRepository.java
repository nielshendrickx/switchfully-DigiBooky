package com.switchfully.javadocjuveniles.domain.book;

import java.util.concurrent.ConcurrentHashMap;

public class BookRepository {
    private final ConcurrentHashMap<String, Book> bookByISBN;

    public BookRepository() {
        this.bookByISBN = new ConcurrentHashMap<>();
    }

    public Book addBook() {
        return null; // return null for the moment only for it to go green, it will need to change
    }
}
