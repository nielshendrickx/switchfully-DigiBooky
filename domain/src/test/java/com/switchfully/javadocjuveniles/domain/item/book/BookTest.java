package com.switchfully.javadocjuveniles.domain.item.book;

import org.junit.jupiter.api.Test;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void bookReturnsCorrectValues() {
        Author author = authorBuilder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .build();
        Book book = bookBuilder()
                .withISBN("9783161484100")
                .withAuthor(author)
                .withNumberOfCopies(2)
                .withSummary("summary")
                .withTitle("title")
                .build();
        assertEquals("9783161484100", book.getISBN());
        assertEquals(author, book.getAuthor());
        assertEquals(2, book.getNumberOfCopies());
        assertEquals("summary", book.getSummary());
        assertEquals("title", book.getTitle());
        assertNotNull(book.getId());
    }
}