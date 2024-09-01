package com.company.repository.custom;

import com.company.entity.Skill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkillRepositoryCustomImpl implements SkillRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Skill> getAllSkills() {
        String jpql = "SELECT s FROM Skill s";
        TypedQuery<Skill> query = em.createQuery(jpql, Skill.class);
        List<Skill> list = query.getResultList();
        return list;
    }

    @Override
    public Skill getSkillById(int id) {
        return em.find(Skill.class, id);
    }

    @Override
    public boolean addSkill(Skill skill) {
        em.persist(skill);
        return true;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        em.merge(skill);
        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        Skill skill = em.find(Skill.class, id);
        em.remove(skill);
        return true;
    }
}
