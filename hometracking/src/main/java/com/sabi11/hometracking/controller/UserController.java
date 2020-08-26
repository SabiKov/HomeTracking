package com.sabi11.hometracking.controller;


import com.sabi11.hometracking.exception.ApiRequestException;
import com.sabi11.hometracking.exception.UserIdNotFoundException;
import com.sabi11.hometracking.model.User;
import com.sabi11.hometracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping
//    public List<User> getAllUser() {
//
//     //   throw new ApiRequestException("oops exception happened for reason!");
//    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> get() {
       List<User> users = userService.findAll();
       return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
       User users = userService.save(user);
       return new ResponseEntity<User>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public User get(@PathVariable("id") @Min(1) Long userId) throws UserIdNotFoundException{
        System.out.println("userId " + userId);
            User user = userService.findById(userId);
            if(user == null) {
                throw new UserIdNotFoundException("user is not found by " + userId);
            }
            return user;
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> delete(@PathVariable("userid")Long userId) {
        userService.delete(userId);
        return new ResponseEntity<String>("user is deleted successfully", HttpStatus.OK);
    }
}
