package com.teste.pagbank.spring_crud.builder;

import com.teste.pagbank.spring_crud.dto.CountryDTO;
import com.teste.pagbank.spring_crud.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryBuilder {

    public CountryDTO build(Country country) {
        return CountryDTO.builder().id(country.getId()).name(country.getName()).build();
    }

    public Country build(CountryDTO countryDTO) {
        return Country.builder().name(countryDTO.name()).build();
    }

}
