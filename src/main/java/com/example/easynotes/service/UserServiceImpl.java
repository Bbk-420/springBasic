package com.example.easynotes.service;

import com.example.easynotes.dto.UserDto;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Status;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addNewUser(UserDto userDto) {
        User user =new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setDisplayName(userDto.getDisplayName());
        user.setStatus(Status.INACTIVE);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User deleteUser(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
        user.setStatus(Status.INACTIVE);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, UserDto userDto) {
        User user=userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setDisplayName(userDto.getDisplayName());
        return userRepository.save(user);
    }

}
