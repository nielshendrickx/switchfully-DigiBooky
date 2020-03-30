package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.item.book.Author;
import com.switchfully.javadocjuveniles.domain.item.book.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;
import static org.junit.Assert.assertEquals;

class BookMapperTest {
    BookMapper bookMapper = new BookMapper();

    @Test
    void toBook_returnsBook_withSameValues_asBookDto() {
        Author author = authorBuilder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .build();
        BookDto bookDto = new BookDto("1234", "9783161484100", author, "title", "summary", 2, LocalDate.of(2020, 3, 29), 2);
        Book book = bookMapper.toBook(bookDto);
        assertEquals(bookDto.getISBN(), book.getISBN());
        assertEquals(bookDto.getAuthor(), book.getAuthor());
        assertEquals(bookDto.getTitle(), book.getTitle());
        assertEquals(bookDto.getSummary(), book.getSummary());
        assertEquals(bookDto.getNumberOfCopies(), book.getNumberOfCopies());
    }

    @Test
    void toDto_returnsBookDto_withSameValues_asBook() {
        Author author = authorBuilder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .build();
        Book book = bookBuilder()
                .withTitle("title")
                .withSummary("summary")
                .withNumberOfCopies(2)
                .withAuthor(author)
                .withISBN("9783161484100")
                .build();
        BookDto bookDto = bookMapper.toDto(book);
        assertEquals(book.getISBN(), bookDto.getISBN());
        assertEquals(book.getAuthor(), bookDto.getAuthor());
        assertEquals(book.getTitle(), bookDto.getTitle());
        assertEquals(book.getSummary(), bookDto.getSummary());
        assertEquals(book.getNumberOfCopies(), bookDto.getNumberOfCopies());
        assertEquals(book.getDateAdded(), bookDto.getDateAdded());
        assertEquals(book.getID(), bookDto.getID());
    }
}