package com.company.repository.custom;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepo")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAllUsers() {
        String jpql = "select u from User u";
        TypedQuery<User> q = em.createQuery(jpql, User.class);
        return q.getResultList();
    }

    @Override
    @Cacheable(value = "users")
    public List<User> getUsersByCategory(String name, String surname, String phone) {
        String jpql = "select u from User u where 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }
        if (phone != null && !phone.trim().isEmpty()) {
            jpql += " and u.phone=:phone ";
        }

        TypedQuery<User> q = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }
        if (phone != null && !phone.trim().isEmpty()) {
            q.setParameter("phone", phone);
        }
        List<User> users = q.getResultList();
        return users;
    }

    @Override
    public User findByEmail(String email) {
        String jpql = "select u from User u where u.email= :e";
        TypedQuery<User> q = em.createQuery(jpql, User.class);
        q.setParameter("e", email);
        List<User> list = q.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    public boolean removeUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    @Override
    public User getUserById(int userId) {
        return em.find(User.class, userId);
    }

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        em.persist(u);
        return true;
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }
}