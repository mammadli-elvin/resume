package com.company.service.impl;

import com.company.repository.CountryRepository;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryServiceInter {

    @Autowired
    private CountryRepository countryRepo;

    @Override
    public List<Country> getAllCountries() {
        return countryRepo.getAllCountries();
    }

    @Override
    public Country getCountryById(int id) {
        return countryRepo.getCountryById(id);
    }

    @Override
    public boolean addCountry(Country country) {
        return countryRepo.addCountry(country);
    }

    @Override
    public boolean updateCountry(Country country) {
        return countryRepo.updateCountry(country);
    }

    @Override
    public boolean removeCountry(int id) {
        return countryRepo.removeCountry(id);
    }
}
