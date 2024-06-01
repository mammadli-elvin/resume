package org.example.main;

import org.example.dao.impl.UserDaoImpl;
import org.example.dao.inter.UserDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao() {
        //loosely coupling
        //tightly coupling

        return new UserDaoImpl();
    }
}
