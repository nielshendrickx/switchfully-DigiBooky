package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.service.books.BookDto;
import com.switchfully.javadocjuveniles.service.books.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = BookController.BOOK_RESOURCE_PATH)
public class BookController {

    public static final String BOOK_RESOURCE_PATH = "/books";
    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Collection<BookDto> findAll() {
        logger.info("Returning all books");
        return bookService.findAll();
    }

    @GetMapping(path = "/{ISBN}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByISBN(@PathVariable("ISBN") String ISBN) {
        logger.info("Returning the book for given ISBN");
        return bookService.getBookByISBN(ISBN);
    }

    @GetMapping(path = "/{ID}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByID(@PathVariable("ID") String ID) {
        logger.info("Returning the book for given ID");
        return bookService.getBookByID(ID);
    }
}
