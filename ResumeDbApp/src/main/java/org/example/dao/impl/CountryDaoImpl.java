package org.example.dao.impl;

import org.example.entity.Country;
import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.CountryDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {
    public Country getCountry(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");
        return new Country(id, name, nationality);
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> result = new ArrayList<>();
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from resume.country;");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                Country country = getCountry(rs);
                result.add(country);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Country getCountryById(int id) {
        Country result = null;
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from resume.country where id=?;");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                result = getCountry(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public boolean addCountry(Country country) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into resume.country(id, name, nationality) values(?, ?, ?)");
            stmt.setInt(1, country.getId());
            stmt.setString(2, country.getName());
            stmt.setString(3, country.getNationality());
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateCountry(Country country) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update resume.country set name=?, nationality=? where id=?;");
            stmt.setString(1, country.getName());
            stmt.setString(2, country.getNationality());
            stmt.setInt(3, country.getId());
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeCountry(int id) {
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from resume.country where id=?;");
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
