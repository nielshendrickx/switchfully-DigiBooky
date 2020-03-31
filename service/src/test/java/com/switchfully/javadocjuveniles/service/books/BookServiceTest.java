package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.exceptions.BookNotFoundException;
import com.switchfully.javadocjuveniles.domain.item.book.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;


class BookServiceTest {

    @Test
    void checkIfBookUpDated(){
        BookRepository bookRepository = new BookRepository();
        BookMapper bookMapper = new BookMapper();
        BookService bookService = new BookService(bookRepository, bookMapper);

        bookService.updateBook(bookRepository.getBookByISBN("9780802148537").stream().filter(book -> book.getISBN().equals("9780802148537")).findFirst().orElseThrow(() -> new BookNotFoundException("ISBN")).getId()
                , authorBuilder().withFirstName("Paulo").withLastName("Coelho").build(), "abc", "summary", 1, 2);
        Assertions.assertEquals("abc", bookRepository.getBookByISBN("9780802148537").stream().filter(book -> book.getISBN().equals("9780802148537")).findFirst().orElseThrow(() -> new BookNotFoundException("ISBN")).getTitle());
    }
}