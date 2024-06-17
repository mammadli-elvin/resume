package org.example.dao.impl;

import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.UserSkillDaoInter;
import org.example.entity.Skill;
import org.example.entity.User;
import org.example.entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                    from user_skill us
                             left join user u
                                       on us.user_id = u.id
                             left join skill s
                                       on us.skill_id = s.id
                    where u.id = ?;""");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill userskill = getUserSkill(rs);
                result.add(userskill);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

