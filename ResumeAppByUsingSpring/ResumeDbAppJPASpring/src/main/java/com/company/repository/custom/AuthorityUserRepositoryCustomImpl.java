package com.company.repository.custom;

import com.company.entity.Authority;
import com.company.entity.AuthorityUser;
import com.company.entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorityUserRepositoryCustomImpl implements AuthorityUserRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Authority findAuthorityByUserId(int userId) {
        String jpql = "select u.authorityId from AuthorityUser u where u.userId=:userId";
        Query query = em.createQuery(jpql);
        query.setParameter("userId", userId);
        int authorityId = (Integer)query.getSingleResult();

        return em.find(Authority.class, authorityId);
    }
}
