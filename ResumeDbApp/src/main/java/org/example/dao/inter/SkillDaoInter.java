package org.example.dao.inter;

import org.example.entity.Skill;

import java.util.List;

public interface SkillDaoInter {
    public List<Skill> getAllSkills();

    public Skill getSkillById(int id);

    public boolean addSkill(Skill skill);

    public boolean updateSkill(Skill skill);

    public boolean removeSkill(int id);
}
