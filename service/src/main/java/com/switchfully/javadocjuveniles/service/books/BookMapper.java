package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.book.Book;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Collection<BookDto> toDto(Collection<Book> bookCollection) {
        return bookCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public BookDto toDto(Book book) {
        return new BookDto(book.getID(), book.getISBN(), book.getAuthor(), book.getTitle()
                , book.getSummary(), book.getNumberOfCopies(), book.getDateAdded(), book.getInitialPrice());
    }

    public Book toBook(BookDto bookDto) {
        return new Book(bookDto.getTitle(), bookDto.getSummary(), bookDto.getNumberOfCopies(), bookDto.getDateAdded()
                , bookDto.getISBN(), bookDto.getAuthor());
    }
    public Book toExistingBook(BookDto bookDto) {
        return new Book(bookDto.getID(), bookDto.getTitle(), bookDto.getSummary()
                , bookDto.getNumberOfCopies(), bookDto.getDateAdded()
                , bookDto.getISBN(), bookDto.getAuthor());
    }
}
