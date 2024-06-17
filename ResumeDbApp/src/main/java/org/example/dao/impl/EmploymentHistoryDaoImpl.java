package org.example.dao.impl;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.EmploymentHistoryDaoInter;
import org.example.entity.Country;
import org.example.entity.EmploymentHistory;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {
    public EmploymentHistory getEmploymentHistory(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        int userId = rs.getInt("user_id");
        User user = new User(userId);

        return new EmploymentHistory(id, header, beginDate, endDate, jobDescription, user);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public EmploymentHistory getEmploymentHistoryById(int id) {
        EmploymentHistory result = null;
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from resume.employment_history where id=?;");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                result = getEmploymentHistory(rs);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory employmentHistory) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into resume.employment_history(header, begin_date, end_date, job_description, user_id) values(?, ?, ?, ?, ?);");
            stmt.setString(1, employmentHistory.getHeader());
            stmt.setDate(2, employmentHistory.getBeginDate());
            stmt.setDate(3, employmentHistory.getEndDate());
            stmt.setString(4, employmentHistory.getJobDescription());
            stmt.setInt(5, employmentHistory.getUser().getId());
            return stmt.execute();
        } catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        return false;
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        return false;
    }
}
