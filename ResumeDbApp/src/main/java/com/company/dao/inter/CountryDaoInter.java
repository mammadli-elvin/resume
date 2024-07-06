/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.Country;
import java.util.List;

/**
 *
 * @author elvin
 */
public interface CountryDaoInter {
    public List<Country> getAllCountries();

    public Country getCountryById(int id);

    public boolean addCountry(Country country);

    public boolean updateCountry(Country country);

    public boolean removeCountry(int id);
}
