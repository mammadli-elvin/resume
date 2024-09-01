package com.company.repository.custom;

import com.company.entity.Skill;

import java.util.List;

public interface SkillRepositoryCustom {

    public List<Skill> getAllSkills();

    public Skill getSkillById(int id);

    public boolean addSkill(Skill skill);

    public boolean updateSkill(Skill skill);

    public boolean removeSkill(int id);
}
