package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.item.book.Book;
import com.switchfully.javadocjuveniles.service.borrow.BorrowDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;

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
        return bookBuilder().withTitle(bookDto.getTitle()).withSummary(bookDto.getSummary())
                .withNumberOfCopies(bookDto.getNumberOfCopies())
                .withDateAdded(bookDto.getDateAdded()).withISBN(bookDto.getISBN())
                .withAuthor(bookDto.getAuthor()).build();
    }

    public BookDetailsDto toBookDetailsDto(Book book, Collection<BorrowDto> borrowDtoList) {
        return new BookDetailsDto(book.getID(), book.getISBN(), book.getAuthor(), book.getTitle()
                , book.getSummary(), book.getNumberOfCopies(), book.getDateAdded(), book.getInitialPrice(), borrowDtoList);
    }
}
