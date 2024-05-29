package com.accio.Book_My_Show.Services;

import com.accio.Book_My_Show.Models.User;
import com.accio.Book_My_Show.Repositories.UserRepository;
import com.accio.Book_My_Show.Requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(AddUserRequest addUserRequest){
        User user = User.builder()
                .name(addUserRequest.getName())
                .age(addUserRequest.getAge())
                .emailId(addUserRequest.getEmailId())
                .mobileNumber(addUserRequest.getMobileNumber())
                .build();

        user = userRepository.save(user);
        return "The User has been saved successfully with userId "+user.getUserId();
    }
}
