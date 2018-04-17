package com.example.easynotes.controller;

import com.example.easynotes.dto.UserDto;
import com.example.easynotes.model.User;
import com.example.easynotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/addUser")
    public User addNewUser(@RequestBody UserDto userDto) {
        return userService.addNewUser(userDto);
    }

    @GetMapping("/users/list")
    public List<User>getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/edit/{id}")
    public User deleteUser(@PathVariable(value = "id") Long userId){
        return userService.deleteUser(userId);
    }
    @PutMapping("/edit/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,
                           @RequestBody UserDto userDto){
        return userService.updateUser(userId,userDto);
    }





}
