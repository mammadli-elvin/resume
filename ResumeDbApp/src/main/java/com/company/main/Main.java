/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.main;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;

/**
 *
 * @author elvin
 */
public class Main {
    // Java Database Connectivity = JDBC API Specification
    // Data Access Object

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();
        CountryDaoInter countryDao = Context.instanceCountryDao();
        SkillDaoInter skillDao = Context.instanceSkillDao();
        UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();
        EmploymentHistoryInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();
        System.out.println(userDao.getAllUsers());

    }
}

/*
    Connection
    Statement
    PreparedStatement
    ResultSet
 */
