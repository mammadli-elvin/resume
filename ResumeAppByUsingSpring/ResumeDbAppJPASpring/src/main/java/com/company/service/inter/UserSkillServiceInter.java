package com.company.service.inter;

import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillServiceInter {
    public List<UserSkill> getAllUserSkillByUserId(int userId);

    public boolean addUserSkill(UserSkill userSkill);

    public boolean updateUserSkill(UserSkill userSkill);

    public boolean removeUserSkill(int id);
}
