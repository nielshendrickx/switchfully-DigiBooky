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
    private final Logger loggerBook = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Collection<BookDto> findAll() {
        loggerBook.info("Returning all books");
        return bookService.findAll();
    }

    @GetMapping(path = "/isbn/{ISBN}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByISBN(@PathVariable("ISBN") String ISBN) {
        loggerBook.info("Returning the book for given ISBN");
        return bookService.getBookByISBN(ISBN);
    }

    @GetMapping(path = "/id/{ID}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByID(@PathVariable("ID") String ID) {
        loggerBook.info("Returning the book for given ID");
        return bookService.getBookByID(ID);
    }

    @GetMapping(path = "/title/{title}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByTitle(@PathVariable("title") String title) {
        loggerBook.info("Returning the book for given title");
        return bookService.getBookByTitle(title);
    }

    @GetMapping(path = "/author/{author}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByAuthor(@PathVariable("author") String author) {
        loggerBook.info("Returning the book for given author");
        return bookService.getBookByAuthor(author);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto save(@RequestBody BookDto bookDto) {
        loggerBook.info("Creating a new book");
        return bookService.addBook(bookDto);
    }
}
