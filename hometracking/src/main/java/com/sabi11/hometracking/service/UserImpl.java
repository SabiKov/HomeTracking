package com.sabi11.hometracking.service;

import com.sabi11.hometracking.dao.UserRepository;
import com.sabi11.hometracking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById(Long userId) {
        if(userRepository.findById(userId).isPresent()){
            return userRepository.findById(userId).get();
        }
        return null;
    }

    @Override
    public void delete(Long userId) {
        User user = findById(userId);
        userRepository.delete(user);
    }
}
