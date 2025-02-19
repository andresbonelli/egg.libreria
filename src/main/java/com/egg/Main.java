package com.egg;

import com.egg.dto.LibroResponseDTO;
import com.egg.entity.Libro;
import com.egg.service.LibroService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SampleDataLoader sampleDataLoader = new SampleDataLoader();
        Thread thread = new Thread(sampleDataLoader);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Hilo principal interrumpido.");
        }

        LibroService libroService = new LibroService();
        List<LibroResponseDTO> libros = libroService.listarLibros();
        for (LibroResponseDTO libro : libros) {
            System.out.println(libro);
        }

    }
}