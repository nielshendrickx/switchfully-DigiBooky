package com.switchfully.javadocjuveniles.domain.borrow;

import com.switchfully.javadocjuveniles.domain.exceptions.InputCanNotBeNullException;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.switchfully.javadocjuveniles.domain.exceptions.NoMoreItemsAvailableException;
import com.switchfully.javadocjuveniles.domain.item.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.Member;
import org.springframework.stereotype.Repository;

@Repository
public class BorrowRepository {
    private final ConcurrentHashMap<String, Borrow> borrowDatabase;

    public BorrowRepository() {
        this.borrowDatabase = new ConcurrentHashMap<>();
    }

    public Borrow addBorrow(Borrow borrow) {
        if(borrow.getBorrowable().getNumberOfCopies() <= getActiveBorrowsForItem(borrow.getBorrowable()).size()) {
            throw new NoMoreItemsAvailableException();
        }
        borrowDatabase.put(borrow.getId(), borrow);
        return borrow;
    }

    public static <T>  void checkIfInputNull(T input){
        if (input == null){
            throw new InputCanNotBeNullException();
        }
    }

    public Collection<Borrow> getActiveBorrowsForItem(Borrowable borrowable) {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getBorrowable().equals(borrowable))
                .filter(borrow -> borrow.getEndDate()==null)
                .collect(Collectors.toList());
    }

    public Collection<Borrow> getActiveBorrowsForMember(Member member) {
        return borrowDatabase.values().stream()
                .filter(borrow -> borrow.getMember().equals(member))
                .filter(borrow -> borrow.getEndDate()==null)
                .collect(Collectors.toList());
    }

}
