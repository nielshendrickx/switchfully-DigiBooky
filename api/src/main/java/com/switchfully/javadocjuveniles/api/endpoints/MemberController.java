package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.service.users.members.CreateMemberDto;
import com.switchfully.javadocjuveniles.service.users.members.MemberDto;
import com.switchfully.javadocjuveniles.service.users.services.MemberService;
import com.switchfully.javadocjuveniles.service.users.services.UserService;
import com.switchfully.javadocjuveniles.service.users.users.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.switchfully.javadocjuveniles.api.security.validation.Validation.*;

@RestController
@RequestMapping(path = MemberController.USER_RESOURCE_PATH)
public class MemberController {

    public static final String USER_RESOURCE_PATH = "/member";
    private final Logger loggerMember = LoggerFactory.getLogger(MemberController.class);
    private final UserService userService;
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService, UserService userService) {
        this.memberService = memberService;
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('VIEW_MEMBERS')")
    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Get all registered members", notes = "A list of all the registered members will be returned" , response = MemberDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<MemberDto> getAllMembers() {
        loggerMember.info("Returning all members");
        return memberService.getAllMembers();
    }

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Register as a member", notes = "Everyone can freely join Digibooky!" , response = MemberDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto register(@RequestBody CreateMemberDto newMember) {
        validateNewMember(newMember);
        loggerMember.info("Creating a new member");
        return memberService.register(newMember);
    }

    private void validateNewMember(CreateMemberDto newMember) {
        isValidEmailAddress(newMember.getEmail());
        memberService.isEmailAvailable(newMember.getEmail());
        isValidInss(newMember.getINSS());
        memberService.isInssAvailable(newMember.getINSS());
    }

    @PreAuthorize("hasAuthority('REGISTER_LIBRARIAN')")
    @PostMapping(path = "/librarian", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Create a new librarian", notes = "A librarian can be created with admin role." , response = LibrarianDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerALibrarian(@RequestBody CreateLibrarianDto newLibrarian) {
        validateMailForNewUser(newLibrarian.getEmail());
        loggerMember.info("Creating a new librarian");
        return userService.register(newLibrarian);
    }

    @PreAuthorize("hasAuthority('REGISTER_ADMIN')")
    @PostMapping(path = "/admin", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Create a new admin", notes = "An admin can only be created with admin role." , response = AdminDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerAnAdmin(@RequestBody CreateAdminDto newAdmin) {
        validateMailForNewUser(newAdmin.getEmail());
        loggerMember.info("Creating a new librarian");
        return userService.register(newAdmin);
    }

    private void validateMailForNewUser(String email) {
        isValidEmailAddress(email);
        userService.isEmailAvailable(email);
    }

    @PreAuthorize("hasAuthority('VIEW_MEMBERS')")
    @GetMapping(path = "/{id}", produces = "application/json")
    @ApiOperation(value = "Find member by id", notes = "Provide an id to look up a member", response = MemberDto.class)
    @ResponseStatus(HttpStatus.OK)
    public MemberDto getById(@ApiParam(value = "ID value for the member you need to retrieve", required = true) @PathVariable String id) {
        return memberService.getDtoById(id);
    }
}