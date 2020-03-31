package com.switchfully.javadocjuveniles.domain.borrow;

import com.switchfully.javadocjuveniles.domain.DummyData;
import com.switchfully.javadocjuveniles.domain.exceptions.NoMoreItemsAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class BorrowRepository {
    private final ConcurrentHashMap<String, Borrow> borrowDatabase;
    private final DummyData dummyData;

    @Autowired
    public BorrowRepository(DummyData dummyData) {
        this.borrowDatabase = new ConcurrentHashMap<>();
        this.dummyData = dummyData;
        addDefaultData();
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

    private void addDefaultData() {
        for(Borrow borrow : dummyData.getDefaultBorrows()) {
            this.addBorrow(borrow);
        }
    }
}
