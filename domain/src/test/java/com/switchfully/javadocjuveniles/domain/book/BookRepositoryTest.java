package com.switchfully.javadocjuveniles.domain.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


class BookRepositoryTest {

    @Test
    void getAllItemsTest(){
        BookRepository bookRepository = new BookRepository();
        Book book1 = new Book("War and Peace", "Summary", 1
                , LocalDate.of(2020, 3, 25), "9787166484100", new Author("Leo", "Tolstoy"));
        Book book2 = new Book("It", "Summary", 1
                , LocalDate.of(2020, 3, 25),"7787169484107", new Author("Stephen", "King"));
        Book book3 = new Book("1984","Summary", 1
                , LocalDate.of(2020, 3, 25), "3387169484107",  new Author("George", "Orwell"));
        Collection<Book> books = new ArrayList<>(List.of(book1, book2, book3));
        Assertions.assertTrue(bookRepository.getAllBooks().containsAll(books));
    }

    @Test
    void addItemTest(){
        BookRepository bookRepository = new BookRepository();
        Book bookToTest = new Book("The trial", "Summary", 1
                , LocalDate.of(2020, 3, 25),"9783161484100", new Author("Franz", "Kafka"));
        bookRepository.addBook(bookToTest);
        Assertions.assertTrue(bookRepository.getBookByISBN().contains(bookToTest));
    }

}