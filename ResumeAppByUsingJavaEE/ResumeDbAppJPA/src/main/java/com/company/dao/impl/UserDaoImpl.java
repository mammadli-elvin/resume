package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    @Override
    public List<User> getAllUsers() {
        EntityManager em = em();
        String jpql = "select u from User u";
        Query q = em.createQuery(jpql, User.class);
        return q.getResultList();
    }

    // JPQL
    @Override
    public List<User> getUsersByCategory(String name, String surname, String phone) {
        EntityManager em = em();
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
        em.close();
        return users;
    }

    //CriteriaBuilder
//    @Override
//    public List<User> getUsersByCategory(String name, String surname, String phone) {
//        EntityManager em = em();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> cq = cb.createQuery(User.class);
//        Root<User> from = cq.from(User.class);
//
//        // Initial predicate, equivalent to '1=1'
//        Predicate predicate = cb.conjunction();
//
//        if (name != null && !name.trim().isEmpty()) {
//            predicate = cb.and(predicate, cb.equal(from.get("name"), name));
//        }
//        if (surname != null && !surname.trim().isEmpty()) {
//            predicate = cb.and(predicate, cb.equal(from.get("surname"), surname));
//        }
//        if (phone != null && !phone.trim().isEmpty()) {
//            predicate = cb.and(predicate, cb.equal(from.get("phone"), phone));
//        }
//        cq.where(predicate);
//
//        TypedQuery<User> query = em.createQuery(cq);
//        List<User> users = query.getResultList();
//        em.close();
//        return users;
//    }

    //    JPQL
    @Override
    public User findByEmail(String email) {

        EntityManager em = em();
        String jpql = "select u from User u where u.email= :e";
        TypedQuery<User> q = em.createQuery(jpql, User.class);
        q.setParameter("e", email);
        List<User> list = q.getResultList();
        em.close();
        if (list.size() == 1) {
            return list.getFirst();
        }
        return null;
    }

//    CriteriaBuilder
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> postRoot = criteriaQuery.from(User.class);
//        criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(postRoot.get("email"), email));
//        TypedQuery<User> q = em.createQuery(criteriaQuery);
//        List<User> list = q.getResultList();
//        em.close();
//        if (list.size() == 1) {
//            return list.getFirst();
//        }
//        return null;
//    }

    //NamedQuery
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
//        query.setParameter("email", email);
//        List<User> list = query.getResultList();
//        em.close();
//        if(list.size() == 1) {
//            return list.getFirst();
//        }
//        return null;
//    }

    //Native SQL
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query query = em.createNativeQuery("select * from resume.user where email=?", User.class);
//        query.setParameter(1, email);
//        List<User> list = query.getResultList();
//        em.close();
//        if(list.size() == 1) {
//            return list.getFirst();
//        }
//        return null;
//    }


    @Override
    public boolean removeUser(int id) {
        EntityManager em = em();

        User u = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public User getUserById(int userId) {
        EntityManager em = em();
        User u = em.find(User.class, userId);
        em.close();
        return u;
    }

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));

        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public boolean updateUser(User u) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}