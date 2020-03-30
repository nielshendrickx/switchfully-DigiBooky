package com.switchfully.javadocjuveniles.domain.borrow;

import com.switchfully.javadocjuveniles.domain.exceptions.InputCanNotBeNullException;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

@Repository
public class BorrowRepository {
    private final ConcurrentHashMap<String, Borrow> borrowDatabase;

    public BorrowRepository() {
        this.borrowDatabase = new ConcurrentHashMap<>();
    }

    public Borrow addBorrow(Borrow borrow) {
        //TODO check if numberOfCopies available > 0
        // TODO add borrow to user
        borrowDatabase.put(borrow.getId(), borrow);
        return borrow;
    }

    public static <T>  void checkIfInputNull(T input){
        if (input == null){
            throw new InputCanNotBeNullException();
        }
    }
}
