package com.switchfully.javadocjuveniles.service.books;

import com.switchfully.javadocjuveniles.domain.item.book.Author;
import com.switchfully.javadocjuveniles.domain.item.book.Book;
import com.switchfully.javadocjuveniles.domain.item.book.BookRepository;
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

    public BookDto updateBook(String id, Author author, String title, String summary, int numberOfCopies, double initialPrice) {
        Book item = (Book) bookRepository.getBookById(id)
                .setTitle(title).setSummary(summary).setNumberOfCopies(numberOfCopies).setInitialPrice(initialPrice);
        item.setAuthor(author);
        return bookMapper.toDto(item);
    }

    public BookDto getBookByISBN(String ISBN){
        return bookMapper.toDto(bookRepository.getBookByISBN(ISBN));
    }

    public BookDto getBookByID(String ID){
        return bookMapper.toDto(bookRepository.getBookById(ID));
    }

    public BookDto getBookByTitle(String title){
        return bookMapper.toDto(bookRepository.getBookByTitle(title));
    }

    public BookDto getBookByAuthor(String name){
        return bookMapper.toDto(bookRepository.getBookByAuthor(name));
    }

    public BookDto addBook(BookDto bookDto){
        return bookMapper.toDto(bookRepository.addBook(bookMapper.toBook(bookDto)));
    }

    public void deleteBook(String ID){
        bookRepository.deleteBook(ID);
    }

    public void restoreBook(String ID){
        bookRepository.restoreBook(ID);
    }

}
