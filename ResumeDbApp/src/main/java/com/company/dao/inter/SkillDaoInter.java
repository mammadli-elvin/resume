/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.Skill;
import java.util.List;

/**
 *
 * @author elvin
 */
public interface SkillDaoInter {
    public List<Skill> getAllSkills();

    public Skill getSkillById(int id);

    public boolean addSkill(Skill skill);

    public boolean updateSkill(Skill skill);

    public boolean removeSkill(int id);
}
