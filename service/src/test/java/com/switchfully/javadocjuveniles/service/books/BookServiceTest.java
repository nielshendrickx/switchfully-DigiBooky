package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.item.book.Author;
import com.switchfully.javadocjuveniles.domain.item.book.BookRepository;
import com.switchfully.javadocjuveniles.service.borrow.BorrowService;
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

        bookService.updateBook(bookRepository.getBookByISBN("9780802148537").getID()
                , authorBuilder().withFirstName("Paulo").withLastName("Coelho").build(), "abc", "summary", 1, 2);
        Assertions.assertEquals("abc", bookRepository.getBookByISBN("9780802148537").getTitle());
    }
}