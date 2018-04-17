package com.example.easynotes.service;

import com.example.easynotes.dto.UserDto;
import com.example.easynotes.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User addNewUser(UserDto userDto);

    List<User> getAllUser();


    User deleteUser(Long userId);

    User updateUser(Long userId, UserDto userDto);

}
