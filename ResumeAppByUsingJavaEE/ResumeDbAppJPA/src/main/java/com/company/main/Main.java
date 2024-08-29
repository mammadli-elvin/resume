/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.main;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;

/**
 * @author elvin
 */
public class Main {
    // Java Database Connectivity = JDBC API Specification
    // Data Access Object

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();
        User u = userDao.findByEmail("elvin2002mammadli@gmail.com");
        System.out.println(u);
//        CountryDaoInter countryDao = Context.instanceCountryDao();
//        SkillDaoInter skillDao = Context.instanceSkillDao();
//        UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();
//        EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();

    }
}

/*
    Connection
    Statement
    PreparedStatement
    ResultSet
 */
