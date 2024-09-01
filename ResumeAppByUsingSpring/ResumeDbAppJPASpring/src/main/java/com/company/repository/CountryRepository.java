package com.company.repository;

import com.company.repository.custom.CountryRepositoryCustom;
import com.company.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>, CountryRepositoryCustom {

}
