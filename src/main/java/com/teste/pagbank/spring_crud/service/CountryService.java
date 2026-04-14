package com.teste.pagbank.spring_crud.service;

import com.teste.pagbank.spring_crud.builder.CountryBuilder;
import com.teste.pagbank.spring_crud.dto.CountryDTO;
import com.teste.pagbank.spring_crud.dto.PageCountryDTO;
import com.teste.pagbank.spring_crud.model.Country;
import com.teste.pagbank.spring_crud.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryBuilder countryBuilder;

    public CountryService(final CountryRepository countryRepository, final CountryBuilder countryBuilder) {
        this.countryRepository = countryRepository;
        this.countryBuilder = countryBuilder;
    }

    public CountryDTO findByName(String name) {
        return countryBuilder.build(countryRepository.findByName(name).get());
    }

    public PageCountryDTO<CountryDTO> findAll(int page, int size, String direction, String attribute) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.Direction.fromString(direction),
                attribute
        );
        Page<Country> result = countryRepository.findAll(pageable);

        List<CountryDTO> dtos = result.getContent().stream()
                .map(p -> new CountryDTO(p.getId(), p.getName()))
                .toList();

        return new PageCountryDTO<>(
                dtos,
                result.getNumber(),
                result.getTotalElements(),
                result.getTotalPages(),
                result.isLast()
        );

    }

    public CountryDTO save(CountryDTO countryDTO) {
        return countryBuilder.build(countryRepository.save(countryBuilder.build(countryDTO)));
    }
}
