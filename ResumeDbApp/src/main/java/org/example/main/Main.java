package org.example.main;

import org.example.bean.User;
import org.example.dao.impl.CountryDaoImpl;
import org.example.dao.impl.SkillDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.dao.inter.CountryDaoInter;
import org.example.dao.inter.SkillDaoInter;
import org.example.dao.inter.UserDaoInter;

import java.util.List;

public class Main {
    // Java Database Connectivity = JDBC API Specification
    // Data Access Object

    public static void main(String[] args) throws Exception {
//        UserDaoInter userDao = Context.instanceUserDao();
//        CountryDaoInter countryDao = new CountryDaoImpl();
//        System.out.println(countryDao.getAllCountries());

        SkillDaoInter skillDao = new SkillDaoImpl();
        System.out.println(skillDao.getAllSkills());
    }


}

/*
    Connection




*/