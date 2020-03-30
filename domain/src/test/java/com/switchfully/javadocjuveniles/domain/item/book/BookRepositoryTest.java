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


class BookRepositoryTest {
    BookRepository bookRepository = new BookRepository();
    @Test
    void getAllItemsTest(){
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
    void addItemTest(){
        Book bookToTest = bookBuilder().withTitle("The trial").withSummary("Summary").withNumberOfCopies(1)
                .withISBN("9780399589157")
                .withAuthor(authorBuilder().withFirstName("Franz").withLastName("Kafka").build()).build();
        bookRepository.addBook(bookToTest);
        Assertions.assertTrue(bookRepository.getAllBooks().contains(bookToTest));
    }

    @Test
    void checkIfErrorIsThrownWhenBookISNull(){
        Assertions.assertThrows(InputCanNotBeNullException.class, () -> {
            bookRepository.addBook(null);
        });
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenISBNIsProvided(){
        Assertions.assertEquals("War and Peace", bookRepository.getBookByISBN("9780802148537").getTitle());
    }
    @Test
    void checkIfTheCorrectBookIsReturnedWhenHalfOfTheISBNIsProvided(){
        Assertions.assertEquals("War and Peace" , bookRepository.getBookByISBN("97808021").getTitle());
    }

    @Test
    void checkIfAnExceptionIsThrownWhenUnknownISBNIsProvided(){
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookRepository.getBookByISBN("9781338290158");
        });
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenIDIsProvided(){
        String bookId = bookRepository.getBookByISBN("9780802148537").getID();
        Assertions.assertEquals("War and Peace", bookRepository.getBookById(bookId).getTitle());
    }

    @Test
    void checkIfAnExceptionIsThrownWhenUnknownIDIsProvided(){
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookRepository.getBookById("4515161616");
        });
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenTitleIsProvided(){
        Assertions.assertEquals("9780802148537" , bookRepository.getBookByTitle("War and Peace").getISBN());
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenHalfOfTheTitleIsProvided(){
        Assertions.assertEquals("9780802148537" , bookRepository.getBookByTitle("War and P").getISBN());
    }

    @Test
    void checkIfAnExceptionIsThrownWhenUnknownTitleIsProvided(){
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookRepository.getBookByTitle("Abcd");
        });
    }

    @Test
    void checkIfTheCorrectBookIsReturnedWhenFirstNameOfAuthorIsProvided(){
        Assertions.assertEquals("9780802148537" , bookRepository.getBookByAuthor("Leo").getISBN());
    }
    @Test
    void checkIfTheCorrectBookIsReturnedWhenLastNameOfAuthorIsProvided(){
        Assertions.assertEquals("9780802148537" , bookRepository.getBookByAuthor("Tolstoy").getISBN());
    }
    @Test
    void checkIfTheCorrectBookIsReturnedWhenFullNameOfAuthorIsProvided(){
        Assertions.assertEquals("9780802148537" , bookRepository.getBookByAuthor("Leo Tolstoy").getISBN());
    }
    @Test
    void checkIfAnExceptionIsThrownWhenWhenWrongAuthorNameIsProvided(){
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookRepository.getBookByAuthor("Leonardo Tolst");
        });
    }
    @Test
    void checkIfAnExceptionIsThrownWhenWhenAuthorsLastNameIsNotProvided(){
        Assertions.assertThrows(FieldMustBeProvidedException.class, () -> {
            bookBuilder().withTitle("The trial").withSummary("Summary").withNumberOfCopies(1)
                    .withISBN("9781452155272")
                    .withAuthor(authorBuilder().withFirstName("Franz").build()).build();
        });
    }
    @Test
    void checkIfAnExceptionIsThrownWhenWhenTitleIsNotProvided(){
        Assertions.assertThrows(FieldMustBeProvidedException.class, () -> {
            bookBuilder().withISBN("9781452155272").withAuthor(authorBuilder().withLastName("Coelho").build()).build();
        });
    }
    @Test
    void checkIfAnExceptionIsThrownWhenWhenISBNIsNotProvided(){
        Assertions.assertThrows(FieldMustBeProvidedException.class, () -> {
            bookBuilder().withTitle("Game of thrones").withAuthor(authorBuilder().withLastName("Martin").build()).build();
        });
    }

    @Test
    void checkIfBookIsDeleted(){
        Assertions.assertTrue(bookRepository.getBookByISBN("9780802148537") != null);
        bookRepository.deleteBook(bookRepository.getBookByISBN("9780802148537").getID());
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookRepository.getBookByISBN("9780802148537");
        });
    }

    @Test
    void checkIfBookIsRestoredWhenIDIsProvided(){
        Book bookToTest = bookBuilder().withTitle("The trial").withSummary("Summary").withNumberOfCopies(1)
                .withISBN("9781452155272")
                .withAuthor(authorBuilder().withFirstName("Franz").withLastName("Kafka").build()).build();
        bookRepository.addBook(bookToTest);
        Assertions.assertTrue(bookRepository.getBookById(bookToTest.getID()) != null);
        bookRepository.deleteBook(bookToTest.getID());
        bookRepository.restoreBook(bookToTest.getID());
        Assertions.assertEquals("The trial", bookRepository.getBookById(bookToTest.getID()).getTitle());
    }

}