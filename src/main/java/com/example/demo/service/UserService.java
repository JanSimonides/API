package com.example.demo.service;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(String username){
        return userRepository.findUserByUsername(username).orElse(null);
    }

    public User getUser(int id){
        return userRepository.findUserById(id).orElse(null);
    }

    public void saveUser (User user){
        try {
            userRepository.save(user);
        }
        catch (Exception ignored){}
    }

    public int createUser(String username, String password, String passwordControl){
        Optional<User> userCheck = userRepository.findUserByUsername(username);
        if (userCheck.isPresent()) {
            return 1;
        }
        else {
            if (!password.equals(passwordControl)) {
                return 2;
            }

            else {
                User user = new User(username,password);
                userRepository.save(user);
                return 0;
            }
        }

    }



    public int loginUser (String username, String password) {
        boolean reulst = userRepository.existsByUsername(username);

        if (reulst == false) {
            return 0;
        } else {
            Optional<User> user = userRepository.findUserByUsername(username);
            if (!user.isPresent()) {
                return 0;
            } else {
                if (user.get().getPassword().equals(password)){
                    if (user.get().getItaly() == null){
                        return 1;
                    }
                    else {
                        return 2;
                    }
                }
                else {
                    return 0;
                }
            }

        }
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();

        users.removeIf(e -> (e.getItaly()==null));

        return users;
    }
}
