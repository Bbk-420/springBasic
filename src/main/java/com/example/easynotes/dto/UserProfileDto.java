package com.example.easynotes.dto;

import com.example.easynotes.model.Gender;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Setter
@Getter
public class UserProfileDto {
    private String firstName;
    private String middleName;
    private  String lastName;
    private  String email;
    private Gender gender;
    private Date dob;
}
