package org.example.dao.inter;

import org.example.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    public List<UserSkill> getAllUserSkillByUserId(int userId);

    public boolean addUserSkill(UserSkill userSkill);

    public boolean updateUserSkill(UserSkill userSkill);

    public boolean removeUserSkill(int id);
}
