package com.switchfully.javadocjuveniles.domain.item.book;

import com.switchfully.javadocjuveniles.domain.exceptions.BookIsNotValidException;
import com.switchfully.javadocjuveniles.domain.exceptions.BookNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;

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
                .stream().filter(key -> checkIfKeywordExists(isbn, key))
                .findAny().orElse("Unknown ISBN");
        if(status.equals("Unknown ISBN")){
            throw new BookNotFoundException("ISBN");
        }
        return bookDatabase.get(status);
    }

    public Book getBookByTitle(String title){
        Book bookByTitle = bookDatabase.values()
                .stream().filter(object -> checkIfKeywordExists(title, object.getTitle()))
                .findAny().orElse(null);
        if(bookByTitle == null){
            throw new BookNotFoundException("Title");
        }
        return bookByTitle;
    }
    public Book getBookByAuthor(String author){
        Book bookByAuthor = bookDatabase.values()
                .stream().filter(object -> author.equals(object.getAuthor().getFirstName())
                        || author.equals(object.getAuthor().getLastName())
                        || author.equals(object.getAuthor().getFullName()))
                .findAny().orElse(null);

        if(bookByAuthor == null){
            throw new BookNotFoundException("Author");
        }
        return bookByAuthor;
    }

    public static boolean checkIfKeywordExists(String isbn, String input){
        return Pattern.compile(".*" + isbn +".*").matcher(input).find();
    }

    public Book getBookById(String id){
        Book book = bookDatabase.values().stream().filter(x -> id.equals(x.getID()))
                .findAny()
                .orElse(null);
        if (book == null) {
            throw new BookNotFoundException("ID");
        }
        return book;
    }

    private void createDefaultData(){
        Book book1 = bookBuilder().withTitle("War and Peace").withSummary("Summary").withNumberOfCopies(1)
                .withDateAdded(LocalDate.of(2020, 3, 25)).withISBN("9787166484100")
                .withAuthor(authorBuilder().withFirstName("Leo").withLastName("Tolstoy").build()).build();
        Book book2 = bookBuilder().withTitle("It").withSummary("Summary").withNumberOfCopies(1)
                .withDateAdded(LocalDate.of(2020, 3, 23)).withISBN("7787169484107")
                .withAuthor(authorBuilder().withFirstName("Stephen").withLastName("King").build()).build();
        Book book3 = bookBuilder().withTitle("1984").withSummary("Summary").withNumberOfCopies(1)
                .withDateAdded(LocalDate.of(2020, 3, 25)).withISBN("3387169484107")
                .withAuthor(authorBuilder().withFirstName("George").withLastName("Orwell").build()).build();
        addBook(book1);
        addBook(book2);
        addBook(book3);
    }
}
