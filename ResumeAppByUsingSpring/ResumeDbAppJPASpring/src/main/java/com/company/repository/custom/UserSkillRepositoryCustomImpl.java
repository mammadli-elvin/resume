package com.company.repository.custom;

import com.company.entity.UserSkill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserSkillRepositoryCustomImpl implements UserSkillRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserSkill> getAllUserSkillByUserId(int userId) {
        String jpql = "SELECT u FROM UserSkill u WHERE u.user.id = :userId";
        TypedQuery<UserSkill> query = em.createQuery(jpql, UserSkill.class);
        query.setParameter("userId", userId);
        List<UserSkill> list = query.getResultList();
        return list;
    }

    @Override
    public boolean addUserSkill(UserSkill userSkill) {
        em.persist(userSkill);
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        em.merge(userSkill);
        return true;
    }

    @Override
    public boolean removeUserSkill(int id) {
        UserSkill userSkill = em.find(UserSkill.class, id);
        em.remove(userSkill);
        return true;
    }
}
