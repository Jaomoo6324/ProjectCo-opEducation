package com.example.coop.service;

import com.example.coop.model.UserModel;
import com.example.coop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel addUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public UserModel doLogin(String email, String password) {
        UserModel userModel = userRepository.getUserModelByEmail(email);
        if (userModel != null && userModel.getPassword().equals(password)) {
            return userModel;
        } else {
            return null;
        }
    }
}
