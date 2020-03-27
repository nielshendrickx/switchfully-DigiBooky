package com.switchfully.javadocjuveniles.api.endpoints;

import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.service.users.MemberDto;
import com.switchfully.javadocjuveniles.service.users.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = MemberController.USER_RESOURCE_PATH)
public class MemberController {

    public static final String USER_RESOURCE_PATH = "/member";
    private final Logger logger = LoggerFactory.getLogger(MemberController.class);
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Collection<MemberDto> getAllMembers() {
        logger.info("Returning all members");
        return memberService.getAllMembers();
    }

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto register(@RequestBody MemberDto infos) {
        logger.info("Creating a new member");
        memberService.register(infos);
        return null;
    }
}
