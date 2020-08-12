package com.sabi11.hometracking.controller;


import com.sabi11.hometracking.model.User;
import com.sabi11.hometracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/users")
    public ResponseEntity<User> save(@RequestBody User user) {
       User users = userService.save(user);
       return new ResponseEntity<User>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> get(@PathVariable("id")Long userId) {
       User user = userService.findById(userId);
       return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> delete(@PathVariable("userid")Long userId) {
        userService.delete(userId);
        return new ResponseEntity<String>("user is deleted successfully", HttpStatus.OK);
    }
}
