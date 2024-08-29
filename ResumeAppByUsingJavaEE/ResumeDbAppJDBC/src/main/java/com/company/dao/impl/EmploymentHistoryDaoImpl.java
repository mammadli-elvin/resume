/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elvin
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    public EmploymentHistory getEmploymentHistory(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        int userId = rs.getInt("user_id");

        return new EmploymentHistory(id, header, beginDate, endDate, jobDescription, new User(userId));
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<EmploymentHistory>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from resume.employment_history where user_id=?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                EmploymentHistory employmentHistory = getEmploymentHistory(rs);
                result.add(employmentHistory);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public EmploymentHistory getEmploymentHistoryById(int id) {
        EmploymentHistory result = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from resume.employment_history where id=?;");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getEmploymentHistory(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory employmentHistory) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into resume.employment_history(header, begin_date, end_date, job_description, user_id) values(?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, employmentHistory.getHeader());
            stmt.setDate(2, employmentHistory.getBeginDate());
            stmt.setDate(3, employmentHistory.getEndDate());
            stmt.setString(4, employmentHistory.getJobDescription());
            stmt.setInt(5, employmentHistory.getUser().getId());
            stmt.execute();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                employmentHistory.setId(generatedKeys.getInt(1));
            }

            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update resume.employment_history set header=?, begin_date=?, end_date=?, job_description=?, user_id=? where id=?;");
            stmt.setString(1, employmentHistory.getHeader());
            stmt.setDate(2, employmentHistory.getBeginDate());
            stmt.setDate(3, employmentHistory.getEndDate());
            stmt.setString(4, employmentHistory.getJobDescription());
            stmt.setInt(5, employmentHistory.getUser().getId());
            stmt.setInt(6, employmentHistory.getId());
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from resume.employment_history where id=?;");
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
