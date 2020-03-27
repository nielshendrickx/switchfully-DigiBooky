package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.book.Author;
import com.switchfully.javadocjuveniles.domain.book.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BookServiceTest {

    @Test
    void checkIfBookUpDated(){
        BookRepository bookRepository = new BookRepository();
        BookMapper bookMapper = new BookMapper();
        BookService bookService = new BookService(bookRepository, bookMapper);

        bookService.update(bookRepository.getBookByISBN("9787166484100").getID()
                , new Author("Paulo", "Coelho"), "abc", "summary", 1);
        Assertions.assertEquals("abc", bookRepository.getBookByISBN("9787166484100").getTitle());
    }

}