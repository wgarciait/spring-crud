package com.teste.pagbank.spring_crud.repository;

import com.teste.pagbank.spring_crud.model.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {
    Optional<Country> findByName(String name);
}
