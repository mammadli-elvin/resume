package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getAllSkills() {
        EntityManager em = em();
        String jpql = "SELECT s FROM Skill s";
        TypedQuery<Skill> query = em.createQuery(jpql, Skill.class);
        List<Skill> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public Skill getSkillById(int id) {
        EntityManager em = em();
        Skill skill = em.find(Skill.class, id);
        em.close();
        return skill;
    }

    //JPQL
//    public Skill getSkillById(int id) {
//        EntityManager em = em();
//        String jpql = "SELECT s FROM Skill s WHERE s.id = :id";
//        TypedQuery<Skill> query = em.createQuery(jpql, Skill.class);
//        query.setParameter("id", id);
//        List<Skill> list = query.getResultList();
//        em.close();
//        if (list.size() == 1) {
//            return list.getFirst();
//        }
//        return null;
//    }

    @Override
    public boolean addSkill(Skill skill) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(skill);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        EntityManager em = em();
        Skill skill = em.find(Skill.class, id);
        em.getTransaction().begin();
        em.remove(skill);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
