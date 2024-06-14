package org.example.main;

import org.example.bean.User;
import org.example.dao.impl.UserDaoImpl;
import org.example.dao.inter.UserDaoInter;

import java.util.List;

public class Main {
    // Java Database Connectivity = JDBC API Specification
    // Data Access Object

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();

        System.out.println(userDao.getAll());
    }


}

/*
    Connection




*/