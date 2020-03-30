package com.switchfully.javadocjuveniles.service.borrow;

import com.switchfully.javadocjuveniles.domain.borrow.Borrow;
import com.switchfully.javadocjuveniles.domain.borrow.BorrowRepository;
import com.switchfully.javadocjuveniles.domain.fines.FineType;
import com.switchfully.javadocjuveniles.domain.fines.OverdueFine;
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
        return borrowMapper.toDto(borrowRepository.addBorrow(borrowMapper.toBorrow(createBorrowDto)));
    }

    public BorrowDto endBorrow(String id) {
        Borrow borrow = borrowRepository.endBorrow(id);
        if (borrow.getEndDate().isAfter(borrow.getDueDate())) {
            FineType fine = new OverdueFine();
            fine.calculateFine(borrow);
            borrow.getMember().addFine(fine);
        }
        return borrowMapper.toDto(borrow);
    }
}
