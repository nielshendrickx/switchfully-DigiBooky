package com.switchfully.javadocjuveniles.domain.item.book;

import com.switchfully.javadocjuveniles.domain.DummyData;
import com.switchfully.javadocjuveniles.domain.exceptions.BookAlreadyExistsException;
import com.switchfully.javadocjuveniles.domain.exceptions.BookNotFoundException;
import com.switchfully.javadocjuveniles.domain.exceptions.InputCanNotBeNullException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

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
        if(bookDatabase.keySet().contains(book.getISBN())){
            throw new BookAlreadyExistsException();
        }
        bookDatabase.put(book.getISBN(), book);
        return book;
    }

    public Collection<Book> getAllBooks(){
        return bookDatabase.values();
    } //TODO check if available

    public Book getBookByISBN(String isbn){
        checkIfInputNull(isbn);
        String status = bookDatabase.keySet()
                .stream().filter(key -> checkIfKeywordExists(isbn, key))
                .findAny()
                .orElseThrow(() -> new BookNotFoundException("ISBN"));
        return bookDatabase.get(status);
    }

    public Book getBookByTitle(String title){
        checkIfInputNull(title);
        Book bookByTitle = bookDatabase.values()
                .stream().filter(object -> checkIfKeywordExists(title, object.getTitle()))
                .findAny()
                .orElseThrow(() -> new BookNotFoundException("Title"));
        return bookByTitle;
    }
    public Book getBookByAuthor(String author){
        checkIfInputNull(author);
        Book bookByAuthor = bookDatabase.values()
                .stream().filter(object -> author.toLowerCase().equals(object.getAuthor().getFirstName().toLowerCase())
                        || author.toLowerCase().equals(object.getAuthor().getLastName().toLowerCase())
                        || author.toLowerCase().equals(object.getAuthor().getFullName().toLowerCase()))
                .findAny()
                .orElseThrow(() -> new BookNotFoundException("Author"));
        return bookByAuthor;
    }

    public Book getBookById(String ID){
        checkIfInputNull(ID);
        Book book = bookDatabase.values()
                .stream().filter(searchedBook -> ID.equals(searchedBook.getId()))
                .findAny()
                .orElseThrow(() -> new BookNotFoundException("ID"));
        return book;
    }

    public void deleteBook(String ID){ //TODO book.togleAvailabilty()
        checkIfInputNull(ID);
        deletedBooksDatabase.put(getBookById(ID).getISBN(), getBookById(ID));
        bookDatabase.remove(getBookById(ID).getISBN());
    }

    public Book restoreBook(String ID){
        checkIfInputNull(ID);
        Book book = deletedBooksDatabase.values().stream().filter(x -> ID.equals(x.getId()))
                .findAny()
                .orElseThrow(() -> new BookNotFoundException("ID"));
        bookDatabase.put(book.getISBN(), book);
        deletedBooksDatabase.remove(book.getISBN());
        return book;
    }

    public static <T>  void checkIfInputNull(T input){
        if (input == null){
            throw new InputCanNotBeNullException();
        }
    }

    public static boolean checkIfKeywordExists(String savedValue, String searchedValue){
        boolean bool = Pattern.compile(".*" + savedValue.toLowerCase() +".*").matcher(searchedValue.toLowerCase()).find();
        return bool;
    }

    private void addDefaultData() {
        for(Book book : dummyData.getDefaultBooks()) {
            this.addBook(book);
        }
    }
}
