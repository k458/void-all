package com.k458.void_db_controller.service;

import com.k458.void_db_controller.model.User;
import com.k458.void_db_controller.repo.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final IUserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(null);
    }

//    @Override
//    public User getUserByName(String name) {
//        return userRepo.findBy(id).orElseThrow(null);
//    }

    @Override
    public User updateUser(User u) {
        User userById = getUserById(u.getId());
        userById.setName(u.getName());
        return userRepo.save(userById);
    }

    @Override
    public User createUser(User u) {
        return userRepo.save(u);
    }

    @Override
    public void deleteUser(Long id) {
        User userById = getUserById(id);
        userRepo.delete(userById);
    }
}
