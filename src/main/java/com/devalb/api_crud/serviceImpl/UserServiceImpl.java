package com.devalb.api_crud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devalb.api_crud.entity.User;
import com.devalb.api_crud.repository.UserRepository;
import com.devalb.api_crud.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public String addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email is already registered.";
        }
        userRepository.save(user);
        return "User added successfully.";
    }

    public List<User> addUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public String editUser(Long id, User user) {
        if (!userRepository.existsById(id)) {
            return "User not found.";
        }
        user.setId(id);
        userRepository.save(user);
        return "User successfully updated.";
    }

    public String deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return "User not found.";
        }
        userRepository.deleteById(id);
        return "User successfully deleted.";
    }
}
