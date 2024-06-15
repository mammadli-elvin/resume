package org.example.dao.impl;

import org.example.bean.Country;
import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.CountryDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        try(Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from resume.country;");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String nationality = rs.getString("nationality");
                Country country = new Country(id, name, nationality);
                countries.add(country);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return countries;
    }
}
