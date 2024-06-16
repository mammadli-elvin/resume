package org.example.main;

import org.example.dao.inter.CountryDaoInter;
import org.example.dao.inter.EmploymentHistoryDaoInter;
import org.example.dao.inter.SkillDaoInter;
import org.example.dao.inter.UserDaoInter;
import org.example.dao.inter.UserSkillDaoInter;

public class Main {
    // Java Database Connectivity = JDBC API Specification
    // Data Access Object

    public static void main(String[] args) throws Exception {
//        EmploymentHistoryDaoInter userDao = Context.instanceEmploymentHistoryDao();
//        System.out.println(userDao.getAllEmploymentHistoryByUserId(6));

        SkillDaoInter skillDao = Context.instanceSkillDao();
        System.out.println(skillDao.getAllSkills());

        CountryDaoInter countryDao = Context.instanceCountryDao();
        System.out.println(countryDao.getAllCountries());



    }


}

/*
    Connection




*/