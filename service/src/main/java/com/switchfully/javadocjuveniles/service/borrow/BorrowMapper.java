package com.switchfully.javadocjuveniles.service.borrow;

import com.switchfully.javadocjuveniles.domain.borrow.Borrow;
import com.switchfully.javadocjuveniles.domain.exceptions.BookNotFoundException;
import com.switchfully.javadocjuveniles.service.books.BookService;
import com.switchfully.javadocjuveniles.service.users.members.MemberMapper;
import com.switchfully.javadocjuveniles.service.users.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.switchfully.javadocjuveniles.domain.borrow.Borrow.BorrowBuilder.borrowBuilder;

@Component
public class BorrowMapper {
    private MemberMapper memberMapper;
    private MemberService memberService;
    private BookService bookService;

    @Autowired
    public BorrowMapper(MemberMapper memberMapper, MemberService memberService, BookService bookService) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
        this.bookService = bookService;
    }

    public Collection<BorrowDto> toDto(Collection<Borrow> memberCollection) {
        return memberCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public BorrowDto toDto(Borrow borrow) {
        return new BorrowDto(borrow.getId(), memberMapper.toDto(borrow.getMember()), borrow.getItem(), borrow.getStartDate(), borrow.getDueDate(), borrow.getEndDate());
    }

    public Borrow toBorrow(CreateBookBorrowDto createBookBorrowDto) {
        return borrowBuilder()
                .withMember(memberService.getMemberById(createBookBorrowDto.getMemberId()))
                .withBorrowable(bookService.getBookByISBN(createBookBorrowDto.getBookISBN()).stream().findFirst().orElseThrow(() -> new BookNotFoundException("ISBN")))
                .buildBorrow();
    }
}
