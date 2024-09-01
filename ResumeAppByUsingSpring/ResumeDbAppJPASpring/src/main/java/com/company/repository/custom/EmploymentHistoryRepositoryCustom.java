
package com.company.repository.custom;

import com.company.entity.EmploymentHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmploymentHistoryRepositoryCustom {

    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

    public EmploymentHistory getEmploymentHistoryById(int id);

    public boolean addEmploymentHistory(EmploymentHistory employmentHistory);

    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory);

    public boolean removeEmploymentHistory(int id);
}
