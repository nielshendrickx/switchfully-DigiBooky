package com.switchfully.javadocjuveniles.api.endpoints;

import com.fasterxml.jackson.annotation.JsonView;
import com.switchfully.javadocjuveniles.service.books.BookDto;
import com.switchfully.javadocjuveniles.service.books.BookService;
import com.switchfully.javadocjuveniles.service.books.View;
import com.switchfully.javadocjuveniles.service.users.members.MemberDto;
import io.swagger.annotations.ApiOperation;
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

    @GetMapping(path = "/allInfo", produces = "application/json")
    @ApiOperation(value = "Get all books", notes = "A list of all books with their full information will be returned" , response = BookDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<BookDto> findAllBooks() {
        logger.info("Returning all books");
        return bookService.findAll();
    }

    @GetMapping(path = "/isbn/{ISBN}", produces = "application/json")
    @ApiOperation(value = "Get book by ISBN", notes = "The book information will be returned when its ISBN is provided" , response = BookDto.class)
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByISBN(@PathVariable("ISBN") String ISBN) {
        logger.info("Returning the book for given ISBN");
        return bookService.getBookByISBN(ISBN);
    }

    @GetMapping(path = "/unlimited/{ID}", produces = "application/json")
    @ApiOperation(value = "Get book by ID", notes = "The book information will be returned when its ID is provided" , response = BookDto.class)
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByID(@PathVariable("ID") String ID) {
        logger.info("Returning the book for given ID");
        return bookService.getBookByID(ID);
    }

    @GetMapping(path = "/title/{title}", produces = "application/json")
    @ApiOperation(value = "Get book by title", notes = "The book information will be returned when its title is provided" , response = BookDto.class)
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByTitle(@PathVariable("title") String title) {
        logger.info("Returning the book for given title");
        return bookService.getBookByTitle(title);
    }

    @GetMapping(path = "/author/{author}", produces = "application/json")
    @ApiOperation(value = "Get book by author", notes = "The book information will be returned when its author is provided" , response = BookDto.class)
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByAuthor(@PathVariable("author") String author) {
        logger.info("Returning the book for given author");
        return bookService.getBookByAuthor(author);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Save book", notes = "The book will be saved" , response = BookDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto saveBook(@RequestBody BookDto bookDto) {
        logger.info("Creating a new book");
        return bookService.addBook(bookDto);
    }

    @PutMapping(path = "/update/{ID}", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Update book", notes = "The book will be updated" , response = BookDto.class)
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@RequestBody BookDto bookDto, @PathVariable("ID") String ID) {
        logger.info("Updating a book");
        BookDto bookToUpdate = bookService.updateBook(ID
                , bookDto.getAuthor(), bookDto.getTitle(), bookDto.getSummary()
                , bookDto.getNumberOfCopies(), bookDto.getInitialPrice());
        return bookToUpdate;
    }

    @DeleteMapping(path = "/delete/{ID}")
    @ApiOperation(value = "Delete book", notes = "The book will be deleted" , response = BookDto.class)
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable("ID") String ID) {
        logger.info("Deleting an existing book");
        bookService.deleteBook(ID);
    }

    @PutMapping (path = "/restore/{ID}")
    @ApiOperation(value = "Restore book", notes = "The deleted book will be restored" , response = BookDto.class)
    @ResponseStatus(HttpStatus.OK)
    public void restoreBook(@PathVariable("ID") String ID) {
        logger.info("Restoring a deleted book");
        bookService.restoreBook(ID);
    }

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Get all books", notes = "A list of all books with their ISBN, title and author info will be returned" , response = BookDto.class)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    public Collection<BookDto> getAllBooksWithLimitedInfo() {
        logger.info("Returning limited book information (for user)");
        return bookService.findAll();
    }

    @GetMapping(path = "/details/{ID}", produces = "application/json")
    @ApiOperation(value = "Get details of a book by ID", notes = "ISBN, title, author and summary of a book be returned" , response = BookDto.class)
    @ResponseStatus(HttpStatus.OK)
    @JsonView({View.PublicWithSummary.class})
    public BookDto getBookByID_forUser_withSummary(@PathVariable("ID") String ID) {
        logger.info("Returning detailed book information for given ID");
        return bookService.getBookByID(ID);
    }

}
