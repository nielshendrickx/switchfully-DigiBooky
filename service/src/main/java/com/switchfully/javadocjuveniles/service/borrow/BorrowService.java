package com.switchfully.javadocjuveniles.service.borrow;

import com.switchfully.javadocjuveniles.domain.borrow.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BorrowService {
    private BorrowMapper borrowMapper;
    private BorrowRepository borrowRepository;

    @Autowired
    public BorrowService(BorrowMapper borrowMapper, BorrowRepository borrowRepository) {
        this.borrowMapper = borrowMapper;
        this.borrowRepository = borrowRepository;
    }

    public Collection<BorrowDto> findAllBorrowsForItem() {
        return null;
    }

    public Collection<BorrowDto> findAllBorrowsForMember() {
        return null;
    }

    public Collection<BorrowDto> findOverdueBooks() {
        return null;
    }

    public Collection<BorrowDto> generateBorrowReport() {
        return null;
    }

    public BorrowDto addBorrow(CreateBorrowDto createBorrowDto) {
        return null;
    }

    public String endBorrow() {
        return null;
    }
}
