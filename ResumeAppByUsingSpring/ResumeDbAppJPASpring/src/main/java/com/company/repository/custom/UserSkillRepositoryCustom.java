package com.company.repository.custom;

import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillRepositoryCustom {

    public List<UserSkill> getAllUserSkillByUserId(int userId);

    public boolean addUserSkill(UserSkill userSkill);

    public boolean updateUserSkill(UserSkill userSkill);

    public boolean removeUserSkill(int id);
}
