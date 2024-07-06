/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import java.util.List;

/**
 *
 * @author elvin
 */
public interface EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

    public EmploymentHistory getEmploymentHistoryById(int id);

    public boolean addEmploymentHistory(EmploymentHistory employmentHistory);

    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory);

    public boolean removeEmploymentHistory(int id);
}
