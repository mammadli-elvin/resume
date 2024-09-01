package com.company.repository.custom;

import com.company.entity.User;

import java.util.List;

public interface UserRepositoryCustom {

    public List<User> getAllUsers();

    public List<User> getUsersByCategory(String name, String surname, String phone);

    public User findByEmail(String email);

    public User getUserById(int id);

    public boolean addUser(User u);

    public boolean updateUser(User u);

    public boolean removeUser(int id);
}
