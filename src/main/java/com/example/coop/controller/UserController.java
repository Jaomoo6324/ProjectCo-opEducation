package com.example.coop.controller;

import com.example.coop.model.UserModel;
import com.example.coop.repository.UserRepository;
import com.example.coop.service.UserService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public ResponseEntity getAllUsers() {
        List<UserModel> userModels = userService.getAllUsers();
        try {
            return new ResponseEntity<>(userModels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity doLogin(@RequestBody Map<String, String> json) {
        try {
            String email = json.get("email");
            String password = json.get("password");
            UserModel userModel = userService.doLogin(email, password);
            if (userModel != null) {
                System.out.println("Found user!");
                return new ResponseEntity<>(userModel, HttpStatus.OK);
            } else {
                System.out.println("Not found user!");
                return new ResponseEntity<>("This user wasn't found on systems!", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public UserModel addUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @GetMapping("/testuser")
    public String testUser () {
        return "hi";
    }

}
