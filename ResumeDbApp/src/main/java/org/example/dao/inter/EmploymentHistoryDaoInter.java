package org.example.dao.inter;

import org.example.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

    public EmploymentHistory getEmploymentHistoryById(int id);

    public boolean addEmploymentHistory(EmploymentHistory employmentHistory);

    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory);

    public boolean removeEmploymentHistory(int id);
}
