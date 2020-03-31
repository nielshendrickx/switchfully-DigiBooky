package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.domain.exceptions.BookNotFoundException;
import com.switchfully.javadocjuveniles.domain.item.book.Author;
import com.switchfully.javadocjuveniles.domain.item.book.Book;
import com.switchfully.javadocjuveniles.domain.item.book.BookRepository;
import com.switchfully.javadocjuveniles.service.books.BookDto;
import com.switchfully.javadocjuveniles.service.books.BookMapper;
import com.switchfully.javadocjuveniles.service.books.BookService;
import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BookControllerTest {
    BookRepository bookRepository = new BookRepository();
    BookMapper bookMapper = new BookMapper();
    BookService bookService = new BookService(bookRepository, bookMapper);
    BookController bookController = new BookController(bookService, null);
    Author author = authorBuilder().withFirstName("firstName").withLastName("lastName").build();
    Book book1 = bookBuilder()
            .withISBN("9783161484100")
            .withTitle("book1")
            .withSummary("summary of book 1")
            .withAuthor(author)
            .withNumberOfCopies(1)
            .build();
    Book book2 = bookBuilder()
            .withISBN("9783161484100")
            .withTitle("book2")
            .withSummary("summary of book 2")
            .withAuthor(author)
            .withNumberOfCopies(1)
            .build();
    BookDto bookDto1 = bookMapper.toDto(book1);
    BookDto bookDto2 = bookMapper.toDto(book2);

    @Test
    void verifyThatRepositoryContains3BooksToStartWith() {
        assertThat(bookController.getAllBooksWithLimitedInfo().size()).isEqualTo(3);
    }

    @Test
    void getBookByIsbn_shouldReturnCorrectBook() {
        bookController.saveBook(bookDto1);
        assertThat(bookController.getBookByISBN(bookDto1.getISBN()).equals(bookDto1));
    }

    @Test
    void getBookByAuthor_shouldReturnCorrectBook() {
        bookController.saveBook(bookDto1);
        assertThat(bookController.getBookByAuthor(bookDto1.getAuthor().getFullName()).equals(bookDto1));
    }
    @Test
    void getBookByISBN_shouldReturnCorrectBook() {
        bookController.saveBook(bookDto1);
        assertThat(bookController.getBookByISBN(bookDto1.getISBN()).equals(bookDto1));
    }
    @Test
    void getBookByTitle_shouldReturnCorrectBook() {
        bookController.saveBook(bookDto1);
        assertThat(bookController.getBookByTitle(bookDto1.getTitle()).equals(bookDto1));
    }
    @Test
    void getBookByID_shouldReturnCorrectBook() {
        String id = bookController.saveBook(bookDto1).getId();
        assertThat(bookController.getBookByID(id).equals(bookDto1));
    }
    @Test
    void verifyThatRepositoryContainsSavedBook() {
        bookController.saveBook(bookDto1);
        assertThat(bookController.getAllBooksWithLimitedInfo().contains(bookDto1));
    }
    @Test
    void verifyThatBookIsDeletedFromRepository() {
        String id = bookController.saveBook(bookDto1).getId();
        assertThat(bookController.getBookByID(id));
        bookController.deleteBook(id);
        assertThatThrownBy(() -> bookController.getBookByID(id))
                .isInstanceOf(BookNotFoundException.class);
    }

    @Test
    void verifyThatDeletedBookIsRestored() {
        String id = bookController.saveBook(bookDto1).getId();
        assertThat(bookController.getBookByID(id));
        bookController.deleteBook(id);
        bookController.restoreBook(id);
        assertThat(bookController.getAllBooksWithLimitedInfo().contains(bookDto1));
    }

    @Test
    void verifyThatBookInfoIsUpdated() {
        String id = bookController.saveBook(bookDto1).getId();
        bookController.updateBook(bookDto2, id);
        assertThat(bookController.getBookByID(id).getTitle().equals("book2"));
    }

}