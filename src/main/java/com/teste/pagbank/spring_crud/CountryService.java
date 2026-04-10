package com.teste.pagbank.spring_crud;

import com.teste.pagbank.spring_crud.model.Country;
import com.teste.pagbank.spring_crud.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country findByName(String name) {
        return countryRepository.findByName(name).get();
    }

    public List<Country> findAll() {
        return StreamSupport.stream(countryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }
}
