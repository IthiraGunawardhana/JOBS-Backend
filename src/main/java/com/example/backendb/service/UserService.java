package com.example.backendb.service;

import com.example.backendb.entity.Product;
import com.example.backendb.entity.User;
import com.example.backendb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        userRepository.save(user);
        return null;
    }

    public void updateCustomer(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
//            existingUser.setDOB(user.getDOB());
            existingUser.setPhone(user.getPhone());
            existingUser.setPassword(user.getPassword());
            userRepository.save(existingUser);
        }
    }

    public void deleteCustomer(Long id) {
        userRepository.deleteById(id);
    }
}
