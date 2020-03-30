package com.switchfully.javadocjuveniles.service.users.services;

import com.switchfully.javadocjuveniles.domain.user.UserRepository;
import com.switchfully.javadocjuveniles.service.users.users.CreateUserDto;
import com.switchfully.javadocjuveniles.service.users.users.UserDto;
import com.switchfully.javadocjuveniles.service.users.users.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto register(CreateUserDto newUser) {
        return userMapper.toDto(userRepository.registerNewUser(userMapper.toUser(newUser)));
    }

    public boolean isEmailAvailable(String email) {
        return userRepository.isEmailAvailable(email);
    }

}
