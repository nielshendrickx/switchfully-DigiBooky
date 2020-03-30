package com.switchfully.javadocjuveniles.domain.borrow;

import com.switchfully.javadocjuveniles.domain.exceptions.NoMoreItemsAvailableException;
import com.switchfully.javadocjuveniles.domain.item.Borrowable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class BorrowRepository {
    private final ConcurrentHashMap<String, Borrow> borrowDatabase;

    public BorrowRepository() {
        this.borrowDatabase = new ConcurrentHashMap<>();
    }

    public Borrow addBorrow(Borrow borrow) {
        if (borrow.getBorrowable().getNumberOfCopies() <= getActiveBorrowsForItem(borrow.getBorrowable()).size()) {
            throw new NoMoreItemsAvailableException();
        }
        borrowDatabase.put(borrow.getId(), borrow);
        return borrow;
    }

    public Collection<Borrow> getActiveBorrowsForItem(Borrowable borrowable) {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getBorrowable().equals(borrowable))
                .filter(borrow -> borrow.getEndDate() == null)
                .collect(Collectors.toList());
    }

    public Collection<Borrow> getActiveBorrowsForMember(String id) {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getMember().getINSS().equals(id))
                .filter(borrow -> borrow.getEndDate() == null)
                .collect(Collectors.toList());
    }

    public Borrow endBorrow(String id) {
        return borrowDatabase.get(id).setEndDate();
    }

    public Collection<Borrow> getOverdueBooks() {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getEndDate() == null)
                .collect(Collectors.toList());
    }
}
