package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.exceptions.EmailAlreadyRegisteredException;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<String, User> userRepository;

    public UserRepository() {
        this.userRepository = new ConcurrentHashMap<>();
    }

    public boolean isEmailAvailable(String email) {
        if (userRepository.values().stream()
                .anyMatch(member -> member.getEmail().equals(email))) {
            throw new EmailAlreadyRegisteredException(email);
        }
        return true;
    }

    public User registerNewUser(User newUser) {
        userRepository.put(newUser.getId(), newUser);
        return newUser;
    }

}
