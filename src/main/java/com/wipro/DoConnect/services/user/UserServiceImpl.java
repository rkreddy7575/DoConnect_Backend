package com.wipro.DoConnect.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.DoConnect.dto.SignupRequest;
import com.wipro.DoConnect.dto.UserDto;
import com.wipro.DoConnect.entities.User;
import com.wipro.DoConnect.repository.UserRepo;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;


    public UserDto createUser(SignupRequest signupRequest) {
        User user = new User(signupRequest.getEmail(), new BCryptPasswordEncoder().encode(signupRequest.getPassword()), signupRequest.getName(), 2);
        user = userRepo.save(user);
        if (user == null)
            return  null;

        return user.mapUsertoUserDto();
    }

    public Boolean hasUserWithEmail(String email) {
        return userRepo.findFirstByEmail(email) != null;
    }
}
