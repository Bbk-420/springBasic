package com.example.easynotes.service;

import com.example.easynotes.model.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserProfileService  {
    List<UserProfile> getAllProfile();

}
