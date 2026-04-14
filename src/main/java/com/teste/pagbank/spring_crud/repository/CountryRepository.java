package com.teste.pagbank.spring_crud.repository;

import com.teste.pagbank.spring_crud.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
}
