package com.example.demo.service;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createAdmin() {
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setUsername("admin");
        admin.setPassword("admin1");

        try {
            userRepository.save(admin);
        }
        catch (Exception ignored){
        }

    }

    public void loginUser (Map<String, String> body){
        User user = new User();
        user.setEmail(body.get("email"));
        user.setUsername(body.get("username"));
        user.setPassword(body.get("password"));
        System.out.println(user.getUsername());
        if (!userRepository.existsByUsername(user.getUsername())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Username is not existing"
            );
        }
        else {
            User logUser = userRepository.findByUsername(user.getUsername());
            if (!logUser.getPassword().equals(user.getPassword())){
                throw new ResponseStatusException(
                        HttpStatus.FORBIDDEN, "Password is wrong"
                );
            }
        }



    }

    public void createUser(Map<String, String> body) {
        User user = new User();
        user.setEmail(body.get("email"));
        user.setUsername(body.get("username"));
        user.setPassword(body.get("password"));


        if (userRepository.existsByEmail(user.getEmail())){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Email is using"
            );
        }
        else if (userRepository.existsByUsername(user.getUsername())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Username is using"
            );
        }
        else {
            userRepository.save(user);
            throw new ResponseStatusException(
                    HttpStatus.OK, "Registration was successful"
            );
        }
    }
}
