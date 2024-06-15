package org.example.dao.impl;

import org.example.bean.Skill;
import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.SkillDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {
    @Override
    public List<Skill> getAllSkills() {
        List<Skill> skills = new ArrayList<>();
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from resume.skill;");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Skill skill = new Skill(id, name);
                skills.add(skill);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return skills;
    }
}
