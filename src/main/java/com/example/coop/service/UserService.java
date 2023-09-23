package com.example.coop.service;

import com.example.coop.model.UserModel;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<UserModel> getAllUsers ();
    UserModel addUser (UserModel userModel);
    UserModel doLogin (String email, String password);

}
