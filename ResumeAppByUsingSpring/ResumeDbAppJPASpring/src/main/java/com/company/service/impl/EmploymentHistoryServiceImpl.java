package com.company.service.impl;

import com.company.repository.EmploymentHistoryRepository;
import com.company.entity.EmploymentHistory;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {

    @Autowired
    private EmploymentHistoryRepository empHistoryRepo;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        return empHistoryRepo.getAllEmploymentHistoryByUserId(userId);
    }

    @Override
    public EmploymentHistory getEmploymentHistoryById(int id) {
        return empHistoryRepo.getEmploymentHistoryById(id);
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory employmentHistory) {
        return empHistoryRepo.addEmploymentHistory(employmentHistory);
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        return empHistoryRepo.updateEmploymentHistory(employmentHistory);
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        return empHistoryRepo.removeEmploymentHistory(id);
    }
}
