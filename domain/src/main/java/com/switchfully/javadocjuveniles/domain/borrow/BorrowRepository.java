package com.switchfully.javadocjuveniles.domain.borrow;

import com.switchfully.javadocjuveniles.domain.exceptions.NoMoreItemsAvailableException;
import com.switchfully.javadocjuveniles.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
        if (borrow.getItem().getNumberOfCopies() <= getActiveBorrowsForItem(borrow.getItem()).size()) {
            throw new NoMoreItemsAvailableException();
        }
        borrowDatabase.put(borrow.getId(), borrow);
        return borrow;
    }

    public Collection<Borrow> getActiveBorrowsForItem(Item item) {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getItem().getID().equals(item.getID()))
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

    public Borrow getBorrowById(String id) {
        return borrowDatabase.get(id);
    }

    public Collection<Borrow> getOverdueBooks() {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getEndDate() == null)
                .filter(borrow -> LocalDate.now().isAfter(borrow.getDueDate()))
                .collect(Collectors.toList());
    }
}
