package com.example.easynotes.controller;

import com.example.easynotes.model.UserProfile;
import com.example.easynotes.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }
    @GetMapping("/userProfile")
    public List<UserProfile>getAllProfile(){
        return userProfileService.getAllProfile();
    }
}

