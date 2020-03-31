package com.switchfully.javadocjuveniles.domain.item.book;

import com.switchfully.javadocjuveniles.domain.exceptions.BookAlreadyExistsException;
import com.switchfully.javadocjuveniles.domain.exceptions.BookNotFoundException;
import com.switchfully.javadocjuveniles.domain.exceptions.InputCanNotBeNullException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;

@Repository
public class BookRepository {
    private final ConcurrentHashMap<String, Book> bookDatabase;
    private final ConcurrentHashMap<String, Book> deletedBooksDatabase;

    public BookRepository() {
        this.bookDatabase = new ConcurrentHashMap<>();
        this.deletedBooksDatabase = new ConcurrentHashMap<>();
        createDefaultData();
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

    public Collection<Book> getBookByTitle(String title){
        checkIfInputNull(title);
        List<Book> booksByTitle = bookDatabase.values()
                .stream().filter(object -> checkIfKeywordExists(title, object.getTitle()))
                .collect(Collectors.toList());
        if (booksByTitle.isEmpty())
                    throw new BookNotFoundException("Title");
        return booksByTitle;
    }
    public Collection<Book> getBookByAuthor(String author){
        checkIfInputNull(author);
        List<Book> books = bookDatabase.values()
                .stream().filter(object -> author.toLowerCase().equals(object.getAuthor().getFirstName().toLowerCase())
                        || author.toLowerCase().equals(object.getAuthor().getLastName().toLowerCase())
                        || author.toLowerCase().equals(object.getAuthor().getFullName().toLowerCase()))
                .collect(Collectors.toList());
        if (books.isEmpty()) throw new BookNotFoundException("Author");
        return books;
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
        return Pattern.compile(".*" + savedValue.toLowerCase() +".*").matcher(searchedValue.toLowerCase()).find();
    }

    private void createDefaultData(){
        Book book1 = bookBuilder().withTitle("War and Peace").withSummary("Summary").withNumberOfCopies(1)
                .withISBN("9780802148537").withInitialPrice(10)
                .withAuthor(authorBuilder().withFirstName("Leo").withLastName("Tolstoy").build()).build();
        Book book2 = bookBuilder().withTitle("It").withSummary("Summary").withNumberOfCopies(1).withInitialPrice(5)
                .withISBN("9780062941503")
                .withAuthor(authorBuilder().withFirstName("Stephen").withLastName("King").build()).build();
        Book book3 = bookBuilder().withTitle("1984").withSummary("Summary").withNumberOfCopies(1).withInitialPrice(3)
                .withISBN("9780805096606")
                .withAuthor(authorBuilder().withFirstName("George").withLastName("Orwell").build()).build();
        addBook(book1);
        addBook(book2);
        addBook(book3);
    }
}
