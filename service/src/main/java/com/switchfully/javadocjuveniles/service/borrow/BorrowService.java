package com.switchfully.javadocjuveniles.service.borrow;

import com.switchfully.javadocjuveniles.domain.borrow.Borrow;
import com.switchfully.javadocjuveniles.domain.borrow.BorrowRepository;
import com.switchfully.javadocjuveniles.domain.fines.DamageFine;
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

    public Collection<BorrowDto> findAllActiveBorrowsForItem(String id) {
        return borrowMapper.toDto(borrowRepository.getActiveBorrowsForItem(id));
    }

    public Collection<BorrowDto> findAllBorrowsForMember(String id) {
        return borrowMapper.toDto(borrowRepository.getActiveBorrowsForMember(id));
    }

    public Collection<BorrowDto> findOverdueBooks() {
        return borrowMapper.toDto(borrowRepository.getOverdueBooks());
    }

    public Collection<BorrowDto> generateBorrowReport(String id) {
        return borrowMapper.toDto(borrowRepository.getBorrowReportForItem(id));
    }

    public BorrowDto addBorrow(CreateBookBorrowDto createBookBorrowDto) {
        return borrowMapper.toDto(borrowRepository.addBorrow(borrowMapper.toBorrow(createBookBorrowDto)));
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

    public DamageFine endDamagedBorrow(String id) {
        Borrow borrow = borrowRepository.endBorrow(id);
        DamageFine fine = new DamageFine();
        fine.calculateFine(borrow);
        borrow.getMember().addFine(fine);
        return fine;
    }
}
