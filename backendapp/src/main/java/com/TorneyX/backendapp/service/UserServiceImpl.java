package com.TorneyX.backendapp.service;

import com.TorneyX.backendapp.dto.UserDto;
import com.TorneyX.backendapp.model.User;
import com.TorneyX.backendapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//UserServiceImpl
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , "USER", userDto.getFullname());
        return userRepository.save(user);
    }
}
