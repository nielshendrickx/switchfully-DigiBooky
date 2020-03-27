package com.switchfully.javadocjuveniles.domain.book;

import com.switchfully.javadocjuveniles.domain.exceptions.BookIDNotFoundException;
import com.switchfully.javadocjuveniles.domain.exceptions.BookIsNotValidException;
import com.switchfully.javadocjuveniles.domain.exceptions.ISBNNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

@Repository
public class BookRepository {
    private final ConcurrentHashMap<String, Book> bookDatabase;

    public BookRepository() {
        this.bookDatabase = new ConcurrentHashMap<>();
        createDefaultData();
    }

    public Book addBook(Book book) {
        if(book == null) {
            throw new BookIsNotValidException();
        }
        bookDatabase.put(book.getISBN(), book);
        return book;
    }

    public Collection<Book> getAllBooks(){
        return bookDatabase.values();
    }

    public Book getBookByISBN(String isbn){
        String status = bookDatabase.keySet()
                .stream().filter(key -> checkIfISBNExists(isbn, key))
                .findAny().orElse("Unknown ISBN");

        if(status.equals("Unknown ISBN")){
            throw new ISBNNotFoundException();
        }
        return bookDatabase.get(isbn);
    }

    public static boolean checkIfISBNExists(String isbn, String input){
        boolean bool = Pattern.compile(".*" + isbn +".*").matcher(input).find();
        return bool;
    }

    public Book getBookById(String id){
        Book book = bookDatabase.values().stream().filter(x -> id.equals(x.getID()))
                .findAny()
                .orElse(null);
        if (book == null) {
            throw new BookIDNotFoundException();
        }
        return book;
    }

    private void createDefaultData(){
        Book book1 = new Book("War and Peace", "Summary", 1
                , LocalDate.of(2020, 3, 25), "9787166484100", new Author("Leo", "Tolstoy"));
        Book book2 = new Book("It", "Summary", 1
                , LocalDate.of(2020, 3, 25),"7787169484107", new Author("Stephen", "King"));
        Book book3 = new Book("1984","Summary", 1
                , LocalDate.of(2020, 3, 25), "3387169484107",  new Author("George", "Orwell"));
        addBook(book1);
        addBook(book2);
        addBook(book3);
    }
}
