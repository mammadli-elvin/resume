package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    @Override
    public List<Country> getAllCountries() {
        EntityManager em = em();
        String jpql = "SELECT c FROM Country c";
        TypedQuery<Country> query = em.createQuery(jpql, Country.class);
        List<Country> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public Country getCountryById(int id) {
        EntityManager em = em();
        Country country = em.find(Country.class, id);
        em.close();
        return country;
    }

    @Override
    public boolean addCountry(Country country) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateCountry(Country country) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(country);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        EntityManager em = em();
        Country country = em.find(Country.class, id);
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
