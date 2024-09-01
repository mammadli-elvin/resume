package com.company.service.impl;

import com.company.repository.UserRepository;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<User> getUsersByCategory(String name, String surname, String phone) {
        return userRepository.getUsersByCategory(name, surname, phone);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean removeUser(int id) {
        return userRepository.removeUser(id);
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public boolean addUser(User u) {
        return userRepository.addUser(u);
    }

    @Override
    public boolean updateUser(User u) {
        return userRepository.updateUser(u);
    }
}