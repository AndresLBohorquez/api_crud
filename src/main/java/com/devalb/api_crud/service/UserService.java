package com.devalb.api_crud.service;

import java.util.List;

import com.devalb.api_crud.entity.User;

public interface UserService {

    public List<User> getAll();

    public User getById(Long id);

    public String addUser(User user);

    public List<User> addUsers(List<User> users);

    public String editUser(Long id, User user);

    public String deleteUser(Long id);
}