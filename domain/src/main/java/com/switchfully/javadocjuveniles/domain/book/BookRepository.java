package com.switchfully.javadocjuveniles.domain.book;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepository {
    private final ConcurrentHashMap<String, Book> bookByISBN;

    public BookRepository() {
        this.bookByISBN = new ConcurrentHashMap<>();
        createDefaultData();
    }

    public Book addBook(Book book) {
        bookByISBN.put(book.getISBN(), book);
        return book;
    }

    public Collection<Book> getAllBooks(){
        return bookByISBN.values();
    }

    public ConcurrentHashMap<String, Book> getBookByISBN() {
        return bookByISBN;
    }

    private void createDefaultData(){
        Book book1 = new Book("War and Peace", "Summary", 1
                , LocalDate.of(2020, 3, 25), "9787166484100", new Author("Leo", "Tolstoy"));
        Book book2 = new Book("It", "Summary", 1
                , LocalDate.of(2020, 3, 25),"7787169484107", new Author("Stephen", "King"));
        Book book3 = new Book("1984","Summary", 1
                , LocalDate.of(2020, 3, 25), "3387169484107",  new Author("George", "Orwell"));
        addBook(book1);
        addBook(book2);
        addBook(book3);
    }
}
