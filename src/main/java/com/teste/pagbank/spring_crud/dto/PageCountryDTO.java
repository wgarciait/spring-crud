package com.teste.pagbank.spring_crud.dto;

import java.util.List;

public record PageCountryDTO<T>(
   List<T> content,
   int currentPage,
   long totalItems,
   int totalPages,
   boolean last
) {}
