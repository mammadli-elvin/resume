package org.example.dao.inter;

import org.example.entity.Country;

import java.util.List;

public interface CountryDaoInter {
    public List<Country> getAllCountries();

    public Country getCountryById(int id);

    public boolean addCountry(Country country);

    public boolean updateCountry(Country country);

    public boolean removeCountry(int id);
}
