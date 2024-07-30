/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.User;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author elvin
 */
public interface UserDaoInter {

    public List<User> getAllUsers();

    public List<User> getUsersByCategory(String name, String surname, String phone);

    public User getUserById(int id);

    public boolean addUser(User u);

    public boolean updateUser(User u);

    public boolean removeUser(int id);
}
