package com.k458.void_db_users.service;

import com.k458.void_db_users.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    //User getUserByName(String name);
    User updateUser(User u);
    User createUser(User u);
    void deleteUser(Long id);

}
