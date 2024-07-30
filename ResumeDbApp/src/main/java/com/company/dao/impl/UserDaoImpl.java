/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
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
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String profileDesc = rs.getString("profile_description");
        String address = rs.getString("address");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");
        Date birthDate = rs.getDate("birthdate");

        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthplaceStr, null);

        return new User(id, name, surname, phone, email, profileDesc, address, birthDate, nationality, birthplace);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select u.*, n.nationality as nationality, c.name as birthplace"
                    + " from resume.user u"
                    + "         left join resume.country n"
                    + "                   on u.nationality_id = n.id"
                    + "         left join resume.country c"
                    + "                   on u.birthplace_id = c.id;");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<User> getUsersByCategory(String name, String surname, String phone) {
        List<User> result = new ArrayList<>();
        try(Connection c = connect()) {
            String sql = "select u.*, n.nationality as nationality, c.name as birthplace from resume.user u "
                    + "left join resume.country n on u.nationality_id = n.id "
                    + "left join resume.country c on u.birthplace_id = c.id where 1=1";
            if(name!=null && !name.trim().isEmpty())
                sql += " and u.name=?";
            if(surname!=null && !surname.trim().isEmpty())
                sql += " and u.surname=?";
            if(phone!=null && !phone.trim().isEmpty()) {
                sql += " and u.phone=?";
            }
            PreparedStatement stmt = c.prepareStatement(sql);
            int i=1;
            if(name!=null && !name.trim().isEmpty()) {
                stmt.setString(i, name);
                i++;
            }
            if(surname!=null && !surname.trim().isEmpty()) {
                stmt.setString(i, surname);
                i++;
            }
            if(phone!=null && !phone.trim().isEmpty()) {
                stmt.setString(i, phone);
            }
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public User getUserById(int userId) {
        User result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select u.*, n.nationality as nationality, c.name as birthplace"
                    + " from resume.user u"
                    + "         left join resume.country n"
                    + "                   on u.nationality_id = n.id"
                    + "         left join resume.country c"
                    + "                   on u.birthplace_id = c.id where u.id = " + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into resume.user(name, surname, phone, email, profile_description, address, birthdate, birthplace_id, nationality_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setString(6, u.getAddress());
            stmt.setDate(7, u.getBirthDate());
            stmt.setInt(8, u.getBirthPlace().getId());
            stmt.setInt(9, u.getNationality().getId());
            stmt.execute();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                u.setId(generatedKeys.getInt(1));
            }

            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update resume.user set name=?, surname=?, phone=?, email=?, profile_description=?, address=?, birthdate=?, birthplace_id=?, nationality_id=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setString(6, u.getAddress());
            stmt.setDate(7, u.getBirthDate());
            stmt.setInt(8, u.getBirthPlace().getId());
            stmt.setInt(9, u.getNationality().getId());
            stmt.setInt(10, u.getId());
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("delete from user where id = " + id);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
