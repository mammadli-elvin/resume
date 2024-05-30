package org.example.dao.inter;

public interface UserDaoInter {
    public List<User> getAll();

    public boolean updateUser(User u);

    public boolean removeUser(int id);
}
