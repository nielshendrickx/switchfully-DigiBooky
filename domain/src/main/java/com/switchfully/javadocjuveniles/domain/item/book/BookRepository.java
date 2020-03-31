package com.switchfully.javadocjuveniles.domain.item.book;

import com.switchfully.javadocjuveniles.domain.DummyData;
import com.switchfully.javadocjuveniles.domain.exceptions.BookAlreadyExistsException;
import com.switchfully.javadocjuveniles.domain.exceptions.BookNotFoundException;
import com.switchfully.javadocjuveniles.domain.exceptions.InputCanNotBeNullException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Repository
public class BookRepository {
    private final ConcurrentHashMap<String, Book> bookDatabase;
    private final ConcurrentHashMap<String, Book> deletedBooksDatabase;
    private final DummyData dummyData;

    public BookRepository(DummyData dummyData) {
        this.bookDatabase = new ConcurrentHashMap<>();
        this.deletedBooksDatabase = new ConcurrentHashMap<>();
        this.dummyData = dummyData;
        addDefaultData();
    }

    public Book addBook(Book book) {
        checkIfInputNull(book);
        if (bookDatabase.keySet().contains(book.getISBN())) {
            throw new BookAlreadyExistsException();
        }
        bookDatabase.put(book.getISBN(), book);
        return book;
    }

    public Collection<Book> getAllBooks() {
        return bookDatabase.values();
    } //TODO check if available

    public Collection<Book> getBookByISBN(String isbn) {
        checkIfInputNull(isbn);
        List<Book> books = bookDatabase.values()
                .stream().filter(value -> checkIfKeywordExists(isbn, value.getISBN()))
                .collect(Collectors.toList());
        if (books.isEmpty()) throw new BookNotFoundException("ISBN");
        return books;
    }

    public Collection<Book> getBookByTitle(String title){
        checkIfInputNull(title);
        List<Book> booksByTitle = bookDatabase.values()
                .stream().filter(object -> checkIfKeywordExists(title, object.getTitle()))
                .collect(Collectors.toList());
        if (booksByTitle.isEmpty())
                    throw new BookNotFoundException("Title");
        return booksByTitle;
    }

    public Collection<Book> getBookByAuthor(String author) {
        checkIfInputNull(author);
        List<Book> books = bookDatabase.values()
                .stream().filter(object -> author.toLowerCase().equals(object.getAuthor().getFirstName().toLowerCase())
                        || author.toLowerCase().equals(object.getAuthor().getLastName().toLowerCase())
                        || author.toLowerCase().equals(object.getAuthor().getFullName().toLowerCase()))
                .collect(Collectors.toList());
        if (books.isEmpty()) throw new BookNotFoundException("Author");
        return books;
    }

    public Book getBookById(String ID) {
        checkIfInputNull(ID);
        Book book = bookDatabase.values()
                .stream().filter(searchedBook -> ID.equals(searchedBook.getId()))
                .findAny()
                .orElseThrow(() -> new BookNotFoundException("ID"));
        return book;
    }

    public void deleteBook(String ID) { //TODO book.togleAvailabilty()
        checkIfInputNull(ID);
        deletedBooksDatabase.put(getBookById(ID).getISBN(), getBookById(ID));
        bookDatabase.remove(getBookById(ID).getISBN());
    }

    public Book restoreBook(String ID) {
        checkIfInputNull(ID);
        Book book = deletedBooksDatabase.values().stream().filter(x -> ID.equals(x.getId()))
                .findAny()
                .orElseThrow(() -> new BookNotFoundException("ID"));
        bookDatabase.put(book.getISBN(), book);
        deletedBooksDatabase.remove(book.getISBN());
        return book;
    }

    public static <T> void checkIfInputNull(T input) {
        if (input == null) {
            throw new InputCanNotBeNullException();
        }
    }

    public static boolean checkIfKeywordExists(String savedValue, String searchedValue) {
        return Pattern.compile(".*" + savedValue.toLowerCase() + ".*").matcher(searchedValue.toLowerCase()).find();
    }

    private void addDefaultData() {
        for(Book book : dummyData.getDefaultBooks()) {
            this.addBook(book);
        }
    }
}
