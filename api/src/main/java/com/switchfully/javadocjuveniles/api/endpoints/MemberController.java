package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.service.users.CreateMemberDto;
import com.switchfully.javadocjuveniles.service.users.MemberDto;
import com.switchfully.javadocjuveniles.service.users.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.switchfully.javadocjuveniles.api.security.validation.Validation.*;

@RestController
@RequestMapping(path = MemberController.USER_RESOURCE_PATH)
public class MemberController {

    public static final String USER_RESOURCE_PATH = "/member";
    private final Logger loggerMember = LoggerFactory.getLogger(MemberController.class);
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Get all registered members", notes = "A list of all the registered members will be returned" , response = MemberDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<MemberDto> getAllMembers() {
        loggerMember.info("Returning all members");
        return memberService.getAllMembers();
    }

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")

    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto register(@RequestBody CreateMemberDto newMember) {
        validateNewMember(newMember);
        loggerMember.info("Creating a new member");
        return memberService.register(newMember);
    }

    private void validateNewMember(@RequestBody CreateMemberDto newMember) {
        isValidEmailAddress(newMember.getEmail());
        memberService.isEmailAvailable(newMember.getEmail());
        isValidInss(newMember.getINSS());
        memberService.isInssAvailable(newMember.getINSS());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ApiOperation(value = "Find member by id", notes = "Provide an id to look up a member", response = MemberDto.class)
    @ResponseStatus(HttpStatus.OK)
    public MemberDto getById(@ApiParam(value = "ID value for the member you need to retrieve", required = true) @PathVariable String id) {
        return memberService.getById(id);
    }
}