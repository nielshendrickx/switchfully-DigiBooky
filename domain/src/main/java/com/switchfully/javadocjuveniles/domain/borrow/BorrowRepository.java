package com.switchfully.javadocjuveniles.domain.borrow;

import com.switchfully.javadocjuveniles.domain.exceptions.NoMoreItemsAvailableException;
import com.switchfully.javadocjuveniles.domain.fines.DamageFine;
import com.switchfully.javadocjuveniles.domain.fines.OverdueFine;
import com.switchfully.javadocjuveniles.domain.item.book.Author;
import com.switchfully.javadocjuveniles.domain.item.book.Book;
import com.switchfully.javadocjuveniles.domain.user.Address;
import com.switchfully.javadocjuveniles.domain.user.Member;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.switchfully.javadocjuveniles.domain.item.book.Author.AuthorBuilder.authorBuilder;
import static com.switchfully.javadocjuveniles.domain.item.book.Book.BookBuilder.bookBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;
import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;

@Repository
public class BorrowRepository {
    private final ConcurrentHashMap<String, Borrow> borrowDatabase;

    @Autowired
    public BorrowRepository() {
        this.borrowDatabase = new ConcurrentHashMap<>();
        createDefaultData();
    }

    public Borrow addBorrow(Borrow borrow) {
        if (borrow.getItem().getNumberOfCopies() <= getActiveBorrowsForItem(borrow.getItem().getId()).size()) {
            throw new NoMoreItemsAvailableException();
        }
        borrowDatabase.put(borrow.getId(), borrow);
        return borrow;
    }

    public Collection<Borrow> getActiveBorrowsForItem(String id) {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getItem().getId().equals(id))
                .filter(borrow -> borrow.getEndDate() == null)
                .collect(Collectors.toList());
    }

    public Collection<Borrow> getActiveBorrowsForMember(String id) {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getMember().getId().equals(id))
                .filter(borrow -> borrow.getEndDate() == null)
                .collect(Collectors.toList());
    }

    public Borrow endBorrow(String id) {
        return borrowDatabase.get(id).setEndDate();
    }

    public Collection<Borrow> getBorrowReportForItem(String id) {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getItem().getId().equals(id))
                .filter(borrow -> borrow.getEndDate() != null)
                .collect(Collectors.toList());
    }

    public Collection<Borrow> getOverdueBooks() {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getEndDate() == null)
                .filter(borrow -> LocalDate.now().isAfter(borrow.getDueDate()))
                .collect(Collectors.toList());
    }

    private void createDefaultData() {
        Borrow borrow1 = Borrow.BorrowBuilder.borrowBuilder()
                .withBorrowable(bookBuilder()
                        .withAuthor(authorBuilder()
                                .withFirstName("Eric")
                                .withLastName("Schmidt")
                                .build()
                        )
                        .withInitialPrice(10)
                        .withISBN("9781644450000")
                        .withNumberOfCopies(1)
                        .withSummary("Summary of a wonderful book")
                        .withTitle("Wonderful book")
                        .build()
                        )
                .setDummyDate()
                .withMember(userBuilder()
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
                        .buildMember()
                )
                .buildBorrow();
        borrowDatabase.put(borrow1.getId(), borrow1);
    }
}
