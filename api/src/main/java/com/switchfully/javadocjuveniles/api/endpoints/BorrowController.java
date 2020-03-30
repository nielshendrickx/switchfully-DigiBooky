package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.service.borrow.BorrowDto;
import com.switchfully.javadocjuveniles.service.borrow.BorrowService;
import com.switchfully.javadocjuveniles.service.borrow.CreateBorrowDto;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Generating a new borrow", notes = "INSS and ISBN should be provided." , response = BorrowDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public BorrowDto startBorrow(@RequestBody CreateBorrowDto newBorrow) {
        loggerBorrow.info("Creating a new borrow");
        return borrowService.addBorrow(newBorrow);
    }

    @PostMapping(path = "/return/{id}", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Ending borrow", notes = "BorrowId should be provided." , response = BorrowDto.class)
    @ResponseStatus(HttpStatus.OK)
    public BorrowDto endBorrow(@PathVariable String id ) {
        loggerBorrow.info("Ending borrow for id: " + id);
        return borrowService.endBorrow(id);
    }


}
