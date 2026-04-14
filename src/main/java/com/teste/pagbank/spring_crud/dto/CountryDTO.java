package com.teste.pagbank.spring_crud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CountryDTO(
        Long id,
        @NotBlank(message = "name is required") String name
) {}
