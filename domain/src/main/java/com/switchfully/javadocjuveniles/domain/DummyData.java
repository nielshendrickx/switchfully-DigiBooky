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

        Book book1 = bookBuilder()
                .withAuthor(authorBuilder()
                        .withFirstName("Robert")
                        .withLastName("Martin")
                        .build()
                )
                .withInitialPrice(15)
                .withISBN("9781670066879")
                .withNumberOfCopies(1)
                .withSummary("Summary of a wonderful book")
                .withTitle("Clean Code: A Handbook for Beginners to Learn How to Become a Better Programmer")
                .build();

        defaultBooks.add(book1);

        Book book2 = bookBuilder()
                .withAuthor(authorBuilder()
                        .withFirstName("Robert")
                        .withLastName("Martin")
                        .build()
                )
                .withInitialPrice(15)
                .withISBN("9780137081073")
                .withNumberOfCopies(1)
                .withSummary("Summary of a wonderful book")
                .withTitle("The Clean Coder: A Code of Conduct for Professional Programmers")
                .build();

        defaultBooks.add(book2);

        Book book3 = bookBuilder()
                .withAuthor(authorBuilder()
                        .withFirstName("J.K.")
                        .withLastName("Rowling")
                        .build()
                )
                .withInitialPrice(7)
                .withISBN("9780439785969")
                .withNumberOfCopies(1)
                .withSummary("Summary of a wonderful book")
                .withTitle("Harry Potter and the Half-Blood Prince (Book 6)")
                .build();

        defaultBooks.add(book3);

        Book book4 = bookBuilder()
                .withAuthor(authorBuilder()
                        .withFirstName("George")
                        .withLastName("Orwell")
                        .build()
                )
                .withInitialPrice(5)
                .withISBN("9780451524935")
                .withNumberOfCopies(1)
                .withSummary("Everyone should have read this.")
                .withTitle("1984")
                .build();

        defaultBooks.add(book4);

        Book book5 = bookBuilder()
                .withAuthor(authorBuilder()
                        .withFirstName("Stephen")
                        .withLastName("King")
                        .build()
                )
                .withInitialPrice(5)
                .withISBN("9781501142970")
                .withNumberOfCopies(1)
                .withSummary("A well done summary.")
                .withTitle("It")
                .build();

        defaultBooks.add(book5);

        Member member = userBuilder()
                .withFirstName("John")
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

        Member member1 = userBuilder()
                .withFirstName("Eric")
                .withLastName("Schmidt")
                .withPassWord("root")
                .withINSS("10.10.10-101.10")
                .withEmail("eric.schmidt@fun.com")
                .withRole(UserRole.MEMBER)
                .setAddress(addressBuilder()
                        .withStreetNumber("12")
                        .withStreet("Cowlane")
                        .withPostalCode("1030")
                        .withCity("Schaerbeek")
                        .build())
                .buildMember();

        defaultMembers.add(member1);

        Member member2 = userBuilder()
                .withFirstName("Jane")
                .withLastName("Doe")
                .withPassWord("DEAD")
                .withINSS("10.10.10-101.10")
                .withEmail("jane.doe@dead.com")
                .withRole(UserRole.MEMBER)
                .setAddress(addressBuilder()
                        .withStreetNumber("42")
                        .withStreet("Piglane")
                        .withPostalCode("1030")
                        .withCity("Schaerbeek")
                        .build())
                .buildMember();

        defaultMembers.add(member2);

        Borrow borrow = Borrow.BorrowBuilder.borrowBuilder()
                .withBorrowable(book)
                .setDummyDate()
                .withMember(member)
                .buildOverdueBorrow();
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
