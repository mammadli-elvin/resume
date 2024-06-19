package org.example.dao.impl;

import org.example.entity.Skill;
import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.SkillDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {
    public Skill getSkill(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Skill(id, name);
    }

    @Override
    public List<Skill> getAllSkills() {
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from resume.skill;");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Skill skill = getSkill(rs);
                result.add(skill);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Skill getSkillById(int id) {
        Skill result = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from resume.skill where id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getSkill(rs);
            }
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addSkill(Skill skill) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into resume.skill(id, name) values(?, ?)");
            stmt.setInt(1, skill.getId());
            stmt.setString(2, skill.getName());
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateSkill(Skill skill) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update resume.skill set name=? where id=?;");
            stmt.setString(1, skill.getName());
            stmt.setInt(2, skill.getId());
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeSkill(int id) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from resume.skill where id=?;");
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
