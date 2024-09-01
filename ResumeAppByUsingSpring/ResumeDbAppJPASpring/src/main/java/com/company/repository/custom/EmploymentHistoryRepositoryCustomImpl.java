package com.company.repository.custom;

import com.company.entity.EmploymentHistory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmploymentHistoryRepositoryCustomImpl implements EmploymentHistoryRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        String jpql = "SELECT e FROM EmploymentHistory e WHERE e.user.id= :id";
        TypedQuery<EmploymentHistory> query = em.createQuery(jpql, EmploymentHistory.class);
        query.setParameter("id", userId);
        List<EmploymentHistory> list = query.getResultList();
        return list;
    }

    @Override
    public EmploymentHistory getEmploymentHistoryById(int id) {
        return em.find(EmploymentHistory.class, id);
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory employmentHistory) {
        em.persist(employmentHistory);
        return true;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        em.merge(employmentHistory);
        return true;
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        EmploymentHistory empHistory = em.find(EmploymentHistory.class, id);
        em.remove(empHistory);
        return true;
    }
}
