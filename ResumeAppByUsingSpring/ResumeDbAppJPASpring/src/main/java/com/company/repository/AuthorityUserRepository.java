package com.company.repository;

import com.company.entity.AuthorityUser;
import com.company.repository.custom.AuthorityUserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityUserRepository extends JpaRepository<AuthorityUser, Integer>, AuthorityUserRepositoryCustom {
}
