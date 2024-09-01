package com.company.service.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryServiceInter {

    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

    public EmploymentHistory getEmploymentHistoryById(int id);

    public boolean addEmploymentHistory(EmploymentHistory employmentHistory);

    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory);

    public boolean removeEmploymentHistory(int id);
}
