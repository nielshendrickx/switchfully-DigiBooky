package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.item.book.Author;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static org.junit.jupiter.api.Assertions.*;

class BookDtoTest {
    @Test
    void bookDto_returnsCorrectValues() {
        Author author = authorBuilder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .build();
        BookDto bookDto = new BookDto("1234", "5678", author, "title", "summary", 2, LocalDate.of(2020, 3, 29), 2);
        assertEquals("1234", bookDto.getID());
        assertEquals("5678", bookDto.getISBN());
        assertEquals(author, bookDto.getAuthor());
        assertEquals("title", bookDto.getTitle());
        assertEquals("summary", bookDto.getSummary());
        assertEquals(2, bookDto.getNumberOfCopies());
        assertEquals(LocalDate.of(2020, 3, 29), bookDto.getDateAdded());
        assertEquals(2, bookDto.getInitialPrice());
    }
}