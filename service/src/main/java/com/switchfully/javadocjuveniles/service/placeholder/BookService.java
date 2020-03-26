package com.switchfully.javadocjuveniles.service.placeholder;

import com.switchfully.javadocjuveniles.domain.book.BookRepository;
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

}
