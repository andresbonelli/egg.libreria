package com.egg.dto;

public record LibroResponseDTO(
        Long isbn,
        String titulo,
        Integer anio,
        Integer ejemplares,
        String nombreAutor,
        String nombreEditorial
) {
}
