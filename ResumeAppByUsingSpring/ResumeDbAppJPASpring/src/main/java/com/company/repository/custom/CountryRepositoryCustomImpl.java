package com.company.repository.custom;

import com.company.entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepositoryCustomImpl implements CountryRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Country> getAllCountries() {
        String jpql = "SELECT c FROM Country c";
        TypedQuery<Country> query = em.createQuery(jpql, Country.class);
        List<Country> list = query.getResultList();
        return list;
    }

    @Override
    public Country getCountryById(int id) {
        return em.find(Country.class, id);
    }

    @Override
    public boolean addCountry(Country country) {
        em.persist(country);
        return true;
    }

    @Override
    public boolean updateCountry(Country country) {
        em.merge(country);
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        Country country = em.find(Country.class, id);
        em.remove(country);
        return true;
    }
}
