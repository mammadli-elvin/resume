/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.UserSkill;
import java.util.List;

/**
 *
 * @author elvin
 */
public interface UserSkillDaoInter {
    public List<UserSkill> getAllUserSkillByUserId(int userId);

    public boolean addUserSkill(UserSkill userSkill);

    public boolean updateUserSkill(UserSkill userSkill);

    public boolean removeUserSkill(int id);
}
