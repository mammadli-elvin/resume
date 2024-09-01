package com.company.repository;

import com.company.repository.custom.UserSkillRepositoryCustom;
import com.company.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer>, UserSkillRepositoryCustom {

}
