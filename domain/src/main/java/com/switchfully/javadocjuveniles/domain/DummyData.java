package com.switchfully.javadocjuveniles.domain;

import com.switchfully.javadocjuveniles.domain.borrow.Borrow;
import com.switchfully.javadocjuveniles.domain.item.book.Book;
import com.switchfully.javadocjuveniles.domain.user.Member;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;

@Component
public class DummyData {
    List<Member> defaultMembers = new ArrayList<>();
    List<Borrow> defaultBorrows = new ArrayList<>();
    List<Book> defaultBooks = new ArrayList<>();

    public DummyData() {
        Book book = bookBuilder()
                .withAuthor(authorBuilder()
                        .withFirstName("Leo")
                        .withLastName("Tolstoy")
                        .build()
                )
                .withInitialPrice(10)
                .withISBN("9780802148537")
                .withNumberOfCopies(1)
                .withSummary("Summary of a wonderful book")
                .withTitle("War and Peace")
                .build();

        defaultBooks.add(book);

        Member member = userBuilder()
                .withFirstName("Eric")
                .withLastName("Doe")
                .withPassWord("DEAD")
                .withINSS("10.10.10-101.10")
                .withEmail("john.doe@dead.com")
                .withRole(UserRole.MEMBER)
                .setAddress(addressBuilder()
                        .withStreetNumber("42")
                        .withStreet("Piglane")
                        .withPostalCode("1030")
                        .withCity("Schaerbeek")
                        .build())
                .buildMember();

        defaultMembers.add(member);

        Borrow borrow = Borrow.BorrowBuilder.borrowBuilder()
                .withBorrowable(book)
                .setDummyDate()
                .withMember(member)
                .buildBorrow();
        defaultBorrows.add(borrow);
    }

    public List<Member> getDefaultMembers() {
        return defaultMembers;
    }

    public List<Borrow> getDefaultBorrows() {
        return defaultBorrows;
    }

    public List<Book> getDefaultBooks() {
        return defaultBooks;
    }
}
