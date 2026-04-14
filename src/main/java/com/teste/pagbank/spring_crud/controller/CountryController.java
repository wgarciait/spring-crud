package com.teste.pagbank.spring_crud.controller;

import com.teste.pagbank.spring_crud.service.CountryService;
import com.teste.pagbank.spring_crud.dto.CountryDTO;
import com.teste.pagbank.spring_crud.dto.PageCountryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/country")
@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(params = "name")
    public ResponseEntity<CountryDTO> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok().body(countryService.findByName(name));
    }

    @GetMapping
    public ResponseEntity<PageCountryDTO<CountryDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "10") int size,
                                                  @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                  @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
        return ResponseEntity.ok().body(countryService.findAll(page, size, direction, orderBy));
    }

    @PostMapping
    public ResponseEntity<CountryDTO> save (@RequestBody CountryDTO countryDTO) {
        return new ResponseEntity<>(countryService.save(countryDTO), HttpStatus.CREATED);
    }

}
