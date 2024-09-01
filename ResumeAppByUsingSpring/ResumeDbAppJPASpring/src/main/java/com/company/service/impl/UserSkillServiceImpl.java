package com.company.service.impl;

import com.company.repository.UserSkillRepository;
import com.company.entity.UserSkill;
import com.company.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserSkillServiceImpl implements UserSkillServiceInter {

    @Autowired
    private UserSkillRepository userSkillRepo;

    @Override
    public List<UserSkill> getAllUserSkillByUserId(int userId) {
        return userSkillRepo.getAllUserSkillByUserId(userId);
    }

    @Override
    public boolean addUserSkill(UserSkill userSkill) {
        return userSkillRepo.addUserSkill(userSkill);
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        return userSkillRepo.updateUserSkill(userSkill);
    }

    @Override
    public boolean removeUserSkill(int id) {
        return userSkillRepo.removeUserSkill(id);
    }
}
