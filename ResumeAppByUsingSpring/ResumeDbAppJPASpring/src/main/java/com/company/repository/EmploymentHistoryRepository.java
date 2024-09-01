package com.company.repository;

import com.company.repository.custom.EmploymentHistoryRepositoryCustom;
import com.company.entity.EmploymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistory, Integer>, EmploymentHistoryRepositoryCustom {

}
