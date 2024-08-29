/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elvin
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws SQLException {
        int userSkillId = rs.getInt("user_skill_id");
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(userSkillId, new User(userId), new Skill(skillId, skillName), power);
    }

    @Override
    public List<UserSkill> getAllUserSkillByUserId(int id) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("""
                    select u.id, s.id as skill_id, s.name as skill_name, us.id as user_skill_id, us.power
                    from resume.user_skill us
                             left join resume.user u
                                       on us.user_id = u.id
                             left join resume.skill s
                                       on us.skill_id = s.id
                    where u.id = ?;""");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill userskill = getUserSkill(rs);
                result.add(userskill);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public boolean addUserSkill(UserSkill userSkill) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into resume.user_skill(user_id, skill_id, power) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, userSkill.getUser().getId());
            stmt.setInt(2, userSkill.getSkill().getId());
            stmt.setInt(3, userSkill.getPower());
            stmt.execute();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                userSkill.setId(generatedKeys.getInt(1));
            }

            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update resume.user_skill set user_id=?, skill_id=?, power=? where id=?");
            stmt.setInt(1, userSkill.getUser().getId());
            stmt.setInt(2, userSkill.getSkill().getId());
            stmt.setInt(3, userSkill.getPower());
            stmt.setInt(4, userSkill.getId());
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeUserSkill(int id) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from resume.user_skill where id=?");
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
