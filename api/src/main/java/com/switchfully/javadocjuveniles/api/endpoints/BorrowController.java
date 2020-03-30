package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.service.borrow.BorrowDto;
import com.switchfully.javadocjuveniles.service.borrow.BorrowService;
import com.switchfully.javadocjuveniles.service.borrow.CreateBookBorrowDto;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = MemberController.USER_RESOURCE_PATH)
public class BorrowController {

    public static final String BORROW_RESOURCE_PATH = "/borrow";
    private final Logger loggerBorrow = LoggerFactory.getLogger(BorrowController.class);
    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping(path = "/book/", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Generating a new borrow", notes = "INSS and ISBN should be provided." , response = BorrowDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public BorrowDto startBorrow(@RequestBody CreateBookBorrowDto newBookBorrow) {
        loggerBorrow.info("Creating a new book borrow");
        return borrowService.addBorrow(newBookBorrow);
    }

    @PostMapping(path = "/return/{id}", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Ending borrow", notes = "BorrowId should be provided." , response = BorrowDto.class)
    @ResponseStatus(HttpStatus.OK)
    public BorrowDto endBorrow(@PathVariable String id ) {
        loggerBorrow.info("Ending borrow for id: " + id);
        return borrowService.endBorrow(id);
    }

    @GetMapping(path = "/overdue", produces = "application/json")
    @ApiOperation(value = "List of overdue books", notes = "Returns all overdue books." , response = BorrowDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<BorrowDto> getOverdue() {
        loggerBorrow.info("Retrieving list of overdue books.");
        return borrowService.findOverdueBooks();
    }

    @GetMapping(path = "/listforuser/{id}", produces = "application/json")
    @ApiOperation(value = "List of lent books", notes = "Returns all lent books per user" , response = BorrowDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<BorrowDto> getLentBooksForUser(@PathVariable String id) {
        loggerBorrow.info("Retrieving list of lent books.");
        return borrowService.findAllBorrowsForMember(id);
    }
}
