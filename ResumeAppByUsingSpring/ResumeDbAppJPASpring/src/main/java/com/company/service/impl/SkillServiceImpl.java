package com.company.service.impl;

import com.company.repository.SkillRepository;
import com.company.entity.Skill;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillServiceInter {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.getAllSkills();
    }

    @Override
    public Skill getSkillById(int id) {
        return skillRepository.getSkillById(id);
    }

    @Override
    public boolean addSkill(Skill skill) {
        return skillRepository.addSkill(skill);
    }

    @Override
    public boolean updateSkill(Skill skill) {
        return skillRepository.updateSkill(skill);
    }

    @Override
    public boolean removeSkill(int id) {
        return skillRepository.removeSkill(id);
    }
}
