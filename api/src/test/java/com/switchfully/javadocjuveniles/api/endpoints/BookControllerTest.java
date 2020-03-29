package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.domain.item.book.Author;
import com.switchfully.javadocjuveniles.domain.item.book.Book;
import com.switchfully.javadocjuveniles.domain.item.book.BookRepository;
import com.switchfully.javadocjuveniles.service.books.BookDto;
import com.switchfully.javadocjuveniles.service.books.BookMapper;
import com.switchfully.javadocjuveniles.service.books.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;
import static org.assertj.core.api.Assertions.assertThat;

class BookControllerTest {
    BookRepository bookRepository = new BookRepository();
    BookMapper bookMapper = new BookMapper();
    BookService bookService = new BookService(bookRepository, bookMapper);
    BookController bookController = new BookController(bookService);
    Author author = authorBuilder().withFirstName("firstName").withLastName("lastName").build();
    Book book1 = bookBuilder()
            .withISBN("1234")
            .withTitle("book1")
            .withSummary("summary of book 1")
            .withAuthor(author)
            .withDateAdded(LocalDate.now())
            .withNumberOfCopies(1)
            .build();
    Book book2 = bookBuilder()
            .withISBN("5678")
            .withTitle("book2")
            .withSummary("summary of book 2")
            .withAuthor(author)
            .withDateAdded(LocalDate.now())
            .withNumberOfCopies(1)
            .build();
    BookDto bookDto1 = bookMapper.toDto(book1);
    BookDto bookDto2 = bookMapper.toDto(book2);

    @Test
    void verifyThatRepositoryContains3BooksToStartWith() {
        assertThat(bookController.findAll().size()).isEqualTo(3);
    }

    @Test
    void getBookByIsbn_shouldReturnCorrectBook() {
        bookController.save(bookDto1);
        assertThat(bookController.getBookByISBN(bookDto1.getISBN()).equals(bookDto1));
    }

    @Test
    void getBookByAuthor_shouldReturnCorrectBook() {
        bookController.save(bookDto1);
        assertThat(bookController.getBookByAuthor(bookDto1.getAuthor().getFullName()).equals(bookDto1));
    }
}