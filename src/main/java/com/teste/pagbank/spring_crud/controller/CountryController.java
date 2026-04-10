package com.teste.pagbank.spring_crud.controller;

import com.teste.pagbank.spring_crud.CountryService;
import com.teste.pagbank.spring_crud.model.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/country")
@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(params = "name")
    public ResponseEntity<Country> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok().body(countryService.findByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Country>> findAll() {
        return ResponseEntity.ok().body(countryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Country> save (@RequestBody Country country) {
        return ResponseEntity.ok().body(countryService.save(country));
    }

}
