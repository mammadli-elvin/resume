package com.company.service.inter;

import com.company.entity.Country;

import java.util.List;

public interface CountryServiceInter {

    public List<Country> getAllCountries();

    public Country getCountryById(int id);

    public boolean addCountry(Country country);

    public boolean updateCountry(Country country);

    public boolean removeCountry(int id);

}
