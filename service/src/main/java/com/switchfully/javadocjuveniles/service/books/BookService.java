package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.book.Author;
import com.switchfully.javadocjuveniles.domain.book.Book;
import com.switchfully.javadocjuveniles.domain.book.BookRepository;
import com.switchfully.javadocjuveniles.domain.book.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }
    public Collection<BookDto> findAll() {
        return bookMapper.toDto(bookRepository.getAllBooks());
    }

    public Book update(String id, Author author, String title, String summary, int numberOfCopies) {
         Item item = bookRepository.getBookById(id)
                .setTitle(title).setSummary(summary).setNumberOfCopies(numberOfCopies);
         Book book = (Book) item;
         return book.setAuthor(author);
    }

    public BookDto getBookByISBN(String ISBN){
        return bookMapper.toDto(bookRepository.getBookByISBN(ISBN));
    }
    public BookDto getBookByID(String ID){
        return bookMapper.toDto(bookRepository.getBookById(ID));
    }
}
