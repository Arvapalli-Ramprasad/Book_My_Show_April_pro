package com.accio.Book_My_Show.Services;

import com.accio.Book_My_Show.Models.User;
import com.accio.Book_My_Show.Repositories.UserRepository;
import com.accio.Book_My_Show.Requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;
    public String addUser(AddUserRequest addUserRequest){
        User user = User.builder()
                .name(addUserRequest.getName())
                .age(addUserRequest.getAge())
                .emailId(addUserRequest.getEmailId())
                .mobileNumber(addUserRequest.getMobileNumber())
                .build();

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(addUserRequest.getEmailId());
        mailMessage.setFrom("springtesteraccio@gmail.com");
        mailMessage.setSubject("Welcome to BookMyShow App !!");
        String body = "Hi "+addUserRequest.getName()+" Welcome to BookMyShow App with welcome offer upto 30%";
        mailMessage.setText(body);

        javaMailSender.send(mailMessage);

        user = userRepository.save(user);
        return "The User has been saved successfully with userId "+user.getUserId();
    }


}
