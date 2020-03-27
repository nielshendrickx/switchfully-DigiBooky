package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.item.book.Author;
import com.switchfully.javadocjuveniles.domain.item.book.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;


class BookServiceTest {

    @Test
    void checkIfBookUpDated(){
        BookRepository bookRepository = new BookRepository();
        BookMapper bookMapper = new BookMapper();
        BookService bookService = new BookService(bookRepository, bookMapper);

        bookService.update(bookRepository.getBookByISBN("9787166484100").getID()
                , authorBuilder().withFirstName("Paulo").withLastName("Coelho").build(), "abc", "summary", 1);
        Assertions.assertEquals("abc", bookRepository.getBookByISBN("9787166484100").getTitle());
    }

}