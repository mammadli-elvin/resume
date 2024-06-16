package org.example.main;

import org.example.dao.impl.CountryDaoImpl;
import org.example.dao.impl.EmploymentHistoryDaoImpl;
import org.example.dao.impl.SkillDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.dao.impl.UserSkillDaoImpl;
import org.example.dao.inter.CountryDaoInter;
import org.example.dao.inter.EmploymentHistoryDaoInter;
import org.example.dao.inter.SkillDaoInter;
import org.example.dao.inter.UserDaoInter;
import org.example.dao.inter.UserSkillDaoInter;

public class Context {
    //loosely coupling
    //tightly coupling
    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceUserSkillDao() {
        return new UserSkillDaoImpl();
    }

    public static SkillDaoInter instanceSkillDao() {
        return new SkillDaoImpl();
    }

    public static CountryDaoInter instanceCountryDao() {
        return new CountryDaoImpl();
    }

    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao() {
        return new EmploymentHistoryDaoImpl();
    }
}
