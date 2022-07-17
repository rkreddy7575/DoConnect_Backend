package com.wipro.DoConnect.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.DoConnect.dto.SignupRequest;
import com.wipro.DoConnect.dto.UserDto;
import com.wipro.DoConnect.services.user.UserService;

import javax.validation.Valid;


@RestController
public class SignupController {

    @Autowired
    UserService userService;

    @PostMapping({"/sign-up"})
    public ResponseEntity<?> signupUser(@RequestBody(required = true) @Valid SignupRequest signupRequest) throws Exception {

        if (userService.hasUserWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);

        UserDto createdUser = userService.createUser(signupRequest);
        if (createdUser == null)
            return new ResponseEntity<>("User not created, come again later", HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

}
