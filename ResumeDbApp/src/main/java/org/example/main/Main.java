package org.example.main;

import org.example.dao.inter.CountryDaoInter;
import org.example.dao.inter.EmploymentHistoryDaoInter;
import org.example.dao.inter.SkillDaoInter;
import org.example.dao.inter.UserDaoInter;
import org.example.dao.inter.UserSkillDaoInter;
import org.example.entity.User;

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


    }


}

/*
    Connection




*/