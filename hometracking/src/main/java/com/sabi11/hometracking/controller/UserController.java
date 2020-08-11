package com.sabi11.hometracking.controller;


import com.sabi11.hometracking.model.User;
import com.sabi11.hometracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> get() {
       List<User> users = userService.findAll();

       return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
