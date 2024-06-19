package org.example.main;

import org.example.dao.impl.UserSkillDaoImpl;
import org.example.dao.inter.CountryDaoInter;
import org.example.dao.inter.EmploymentHistoryDaoInter;
import org.example.dao.inter.SkillDaoInter;
import org.example.dao.inter.UserDaoInter;
import org.example.dao.inter.UserSkillDaoInter;
import org.example.entity.Country;
import org.example.entity.Skill;
import org.example.entity.User;
import org.example.entity.UserSkill;

public class Main {
    // Java Database Connectivity = JDBC API Specification
    // Data Access Object

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();
        User u = new User(3, "Aylin", "Mammadli", "++994777777777" , "aylinmammadli@gmail.com", null, null, null);

//        System.out.println(userDao.getAllUsers());
//        System.out.println(userDao.getUserById(6));
//        System.out.println(userDao.addUser(u));
//        System.out.println(userDao.removeUser(3));

        CountryDaoInter countryDao = Context.instanceCountryDao();
        Country country = new Country(3, "Turkey", "Turk");
//        System.out.println(countryDao.getAllCountries());
//        System.out.println(countryDao.getCountryById(3));
//        countryDao.addCountry(new Country(3, "Turkiye", "Turk"));
//        countryDao.updateCountry(country);
//        countryDao.removeCountry(3);

        EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();

//        System.out.println(employmentHistoryDao.getAllEmploymentHistoryByUserId(6));
//        System.out.println(employmentHistoryDao.getEmploymentHistoryById(1));

        SkillDaoInter skillDao = Context.instanceSkillDao();
//        System.out.println(skillDao.getAllSkills());
//        System.out.println(skillDao.getSkillById(1));
//        skillDao.addSkill(new Skill(4, "Javascript"));
//        skillDao.updateSkill(new Skill(4, "Python"));
//        skillDao.removeSkill(4);

        UserSkillDaoInter userSkillDao = new UserSkillDaoImpl();
        User u1 = userDao.getUserById(6);
        Skill s1 = skillDao.getSkillById(1);
        UserSkill userSkill = new UserSkill(4, u1, s1, 10);


//        System.out.println(userSkillDao.getAllUserSkillByUserId(1));
//        userSkillDao.addUserSkill(userSkill);
//        userSkillDao.updateUserSkill(userSkill);
        userSkillDao.removeUserSkill(4);

    }



}

/*
    Connection




*/