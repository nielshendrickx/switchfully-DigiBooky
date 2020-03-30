package com.switchfully.javadocjuveniles.api.security.authentication;

import com.switchfully.javadocjuveniles.domain.user.MemberRepository;
import com.switchfully.javadocjuveniles.domain.user.User;
import com.switchfully.javadocjuveniles.domain.user.UserRepository;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class AuthenticationService {

    private final MemberRepository memberRepository;
    private final UserRepository userRepository;

    private List<User> usersList = new ArrayList<>();

    @Autowired
    public AuthenticationService(MemberRepository memberRepository, UserRepository userRepository) {
        this.memberRepository = memberRepository;
        this.userRepository = userRepository;
        usersList.addAll(memberRepository.getAllMembers());
        usersList.addAll(userRepository.getAllUsers());
    }

    public User getUser(String email, String password) {
        return usersList.stream()
                .filter(externalAuthentication -> externalAuthentication.getEmail().equals(email))
                .filter(externalAuthentication -> externalAuthentication.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
