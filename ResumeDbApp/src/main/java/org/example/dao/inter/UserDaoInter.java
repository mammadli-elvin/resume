package org.example.dao.inter;

import org.example.entity.User;
import org.example.entity.UserSkill;

import java.util.List;

public interface UserDaoInter {
    public List<User> getAllUsers();

    public User getById(int id);

    public boolean addUser(User u);

    public boolean updateUser(User u);

    public boolean removeUser(int id);
}
