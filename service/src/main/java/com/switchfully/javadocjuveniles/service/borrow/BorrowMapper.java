package com.switchfully.javadocjuveniles.service.borrow;

import com.switchfully.javadocjuveniles.domain.borrow.Borrow;
import com.switchfully.javadocjuveniles.service.users.MemberMapper;
import com.switchfully.javadocjuveniles.service.users.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.switchfully.javadocjuveniles.domain.borrow.Borrow.BorrowBuilder.borrowBuilder;

@Component
public class BorrowMapper {
    private MemberMapper memberMapper;
    private MemberService memberService;

    @Autowired
    public BorrowMapper( MemberMapper memberMapper, MemberService memberService) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
    }

    public Collection<BorrowDto> toDto(Collection<Borrow> memberCollection) {
        return memberCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public BorrowDto toDto(Borrow borrow) {
        return new BorrowDto(borrow.getId(), memberMapper.toDto(borrow.getMember()), borrow.getBorrowable(), borrow.getStartDate(), borrow.getDueDate(), borrow.getEndDate());
    }

    public Borrow toBorrow(CreateBorrowDto createBorrowDto) {
        return borrowBuilder()
                .withMember(memberService.getMemberById(createBorrowDto.getMember().getId()))
                .withBorrowable(createBorrowDto.getBorrowable())
                .withEndDate(createBorrowDto.getEndDate())
                .buildBorrow();
    }
}
