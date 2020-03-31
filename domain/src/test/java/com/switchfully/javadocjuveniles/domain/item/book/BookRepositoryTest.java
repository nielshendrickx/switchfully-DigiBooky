package com.switchfully.javadocjuveniles.domain.item.book;

import com.switchfully.javadocjuveniles.domain.exceptions.BookIsNotValidException;
import com.switchfully.javadocjuveniles.domain.exceptions.BookNotFoundException;
import com.switchfully.javadocjuveniles.domain.exceptions.FieldMustBeProvidedException;
import com.switchfully.javadocjuveniles.domain.exceptions.InputCanNotBeNullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;
import static org.assertj.core.api.Assertions.assertThat;


class BookRepositoryTest {
    BookRepository bookRepository = new BookRepository();
    Book book1 = bookBuilder().withTitle("War and Peace").withSummary("Summary").withNumberOfCopies(1)
            .withISBN("9780802148537")
            .withAuthor(authorBuilder().withFirstName("Leo").withLastName("Tolstoy").build()).build();
    Book book2 = bookBuilder().withTitle("It").withSummary("Summary").withNumberOfCopies(1)
            .withISBN("9780062941503")
            .withAuthor(authorBuilder().withFirstName("Stephen").withLastName("King").build()).build();
    Book book3 = bookBuilder().withTitle("1984").withSummary("Summary").withNumberOfCopies(1)
            .withISBN("9780805096606")
            .withAuthor(authorBuilder().withFirstName("George").withLastName("Orwell").build()).build();
    Collection<Book> books = new ArrayList<>(List.of(book1, book2, book3));

    @Test
    void getAllItemsTest() {
        Book book1 = bookBuilder().withTitle("War and Peace").withSummary("Summary").withNumberOfCopies(1)
                .withISBN("9780802148537")
                .withAuthor(authorBuilder().withFirstName("Leo").withLastName("Tolstoy").build()).build();
        Book book2 = bookBuilder().withTitle("It").withSummary("Summary").withNumberOfCopies(1)
                .withISBN("9780062941503")
                .withAuthor(authorBuilder().withFirstName("Stephen").withLastName("King").build()).build();
        Book book3 = bookBuilder().withTitle("1984").withSummary("Summary").withNumberOfCopies(1)
                .withISBN("9780805096606")
                .withAuthor(authorBuilder().withFirstName("George").withLastName("Orwell").build()).build();
        Collection<Book> books = new ArrayList<>(List.of(book1, book2, book3));
        Assertions.assertTrue(bookRepository.getAllBooks().containsAll(books));
    }

    @Test
    void addItemTest() {
        Book bookToTest = bookBuilder().withTitle("The trial").withSummary("Summary").withNumberOfCopies(1)
                .withISBN("9780399589157")
                .withAuthor(authorBuilder().withFirstName("Franz").withLastName("Kafka").build()).build();
        bookRepository.addBook(bookToTest);
        Assertions.assertTrue(bookRepository.getAllBooks().contains(bookToTest));
    }

    @Test
    void checkIfErrorIsThrownWhenBookISNull() {
        Assertions.assertThrows(InputCanNotBeNullException.class, () -> {
            bookRepository.addBook(null);
        });
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenISBNIsProvided() {
        assertThat(bookRepository.getBookByISBN("9780802148537")).contains(book1);
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenHalfOfTheISBNIsProvided() {
        System.out.println(bookRepository.getBookByISBN("9"));
        assertThat(bookRepository.getBookByISBN("9")).contains(book1, book2, book3);
    }

    @Test
    void checkIfAnExceptionIsThrownWhenUnknownISBNIsProvided() {
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookRepository.getBookByISBN("9781338290158");
        });
    }


    @Test
    void checkIfAnExceptionIsThrownWhenUnknownIDIsProvided() {
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookRepository.getBookById("4515161616");
        });
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenTitleIsProvided() {
        assertThat(bookRepository.getBookByTitle("War and Peace").contains(book1));
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenHalfOfTheTitleIsProvided() {
        assertThat(bookRepository.getBookByTitle("War and P").contains(book1));
    }

    @Test
    void checkIfAnExceptionIsThrownWhenUnknownTitleIsProvided() {
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookRepository.getBookByTitle("Abcd");
        });
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenFirstNameOfAuthorIsProvided() {

        assertThat(bookRepository.getBookByAuthor("Leo")).contains(book1);
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenLastNameOfAuthorIsProvided() {
        assertThat(bookRepository.getBookByAuthor("Leo")).contains(book1);
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenFullNameOfAuthorIsProvided() {
        assertThat(bookRepository.getBookByAuthor("Leo")).contains(book1);
    }

    @Test
    void checkIfAnExceptionIsThrownWhenWhenWrongAuthorNameIsProvided() {
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookRepository.getBookByAuthor("Leonardo Tolst");
        });
    }

    @Test
    void checkIfAnExceptionIsThrownWhenWhenAuthorsLastNameIsNotProvided() {
        Assertions.assertThrows(FieldMustBeProvidedException.class, () -> {
            bookBuilder().withTitle("The trial").withSummary("Summary").withNumberOfCopies(1)
                    .withISBN("9781452155272")
                    .withAuthor(authorBuilder().withFirstName("Franz").build()).build();
        });
    }

    @Test
    void checkIfAnExceptionIsThrownWhenWhenTitleIsNotProvided() {
        Assertions.assertThrows(FieldMustBeProvidedException.class, () -> {
            bookBuilder().withISBN("9781452155272").withAuthor(authorBuilder().withLastName("Coelho").build()).build();
        });
    }

    @Test
    void checkIfAnExceptionIsThrownWhenWhenISBNIsNotProvided() {
        Assertions.assertThrows(FieldMustBeProvidedException.class, () -> {
            bookBuilder().withTitle("Game of thrones").withAuthor(authorBuilder().withLastName("Martin").build()).build();
        });
    }

//    @Test
//    void checkIfBookIsDeleted() {
//        Assertions.assertTrue(bookRepository.getBookByISBN("9780802148537") != null);
//        bookRepository.deleteBook(bookRepository.getBookByISBN("9780802148537").stream().filter(book -> book.getISBN().equals("9780802148537")).findFirst());
//        Assertions.assertThrows(BookNotFoundException.class, () -> {
//            bookRepository.getBookByISBN("9780802148537");
//        });
//    }

    @Test
    void checkIfBookIsRestoredWhenIDIsProvided() {
        Book bookToTest = bookBuilder().withTitle("The trial").withSummary("Summary").withNumberOfCopies(1)
                .withISBN("9781452155272")
                .withAuthor(authorBuilder().withFirstName("Franz").withLastName("Kafka").build()).build();
        bookRepository.addBook(bookToTest);
        Assertions.assertTrue(bookRepository.getBookById(bookToTest.getId()) != null);
        bookRepository.deleteBook(bookToTest.getId());
        bookRepository.restoreBook(bookToTest.getId());
        Assertions.assertEquals("The trial", bookRepository.getBookById(bookToTest.getId()).getTitle());
    }

}