package com.company.repository;

import com.company.repository.custom.SkillRepositoryCustom;
import com.company.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer>, SkillRepositoryCustom {

}
