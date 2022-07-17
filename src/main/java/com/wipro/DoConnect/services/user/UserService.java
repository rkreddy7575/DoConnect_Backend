package com.wipro.DoConnect.services.user;


import com.wipro.DoConnect.dto.SignupRequest;
import com.wipro.DoConnect.dto.UserDto;

public interface UserService {

     UserDto createUser(SignupRequest signupRequest);

     Boolean hasUserWithEmail(String email);
}
