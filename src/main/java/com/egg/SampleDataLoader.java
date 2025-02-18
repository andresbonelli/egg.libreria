package com.egg;

import com.egg.service.AutorService;
import com.egg.service.EditorialService;
import com.egg.service.LibroService;

public class SampleDataLoader implements Runnable {
    @Override
    public void run() {
        try {
            AutorService autorService = new AutorService();
            // Crear autores
            System.out.println("Cargando autores...");
            autorService.crearAutor("Gabriel García Márquez");
            autorService.crearAutor("Paulo Coelho");
            autorService.crearAutor("Antoine de Saint-Exupéry");
            autorService.crearAutor("Oscar Wilde");
            autorService.crearAutor("J.R.R. Tolkien");
        } catch (Exception e) {
            System.out.println("Error creando autores " + e.getMessage());
        }
        try {
            EditorialService editorialService = new EditorialService();
            // Crear editoriales
            System.out.println("Cargando editoriales...");
            editorialService.crearEditorial("Editorial Sudamericana");
            editorialService.crearEditorial("Editorial Planeta");
        } catch (Exception e) {
            System.out.println("Error creando editoriales " + e.getMessage());
        }
        try {
            LibroService libroService = new LibroService();
            // Crear libros
            System.out.println("Cargando libros...");
            libroService.crearLibro(9788437604947L, "Cien años de soledad", 1967, 471, 1L, 1L);
            libroService.crearLibro(9788437604948L, "El amor en los tiempos del cólera", 1985, 368, 1L, 1L);
            libroService.crearLibro(9788437604949L, "El coronel no tiene quien le escriba", 1961, 128, 1L, 1L);
            libroService.crearLibro(9788437604950L, "El ojo del mundo", 1964, 128, 1L, 1L);
            libroService.crearLibro(9788437604951L, "El libro de la selva", 1961, 128, 1L, 1L);
            libroService.crearLibro(9788437604952L, "El ruido y la furia", 1961, 128, 1L, 1L);
            libroService.crearLibro(9788437604953L, "El alquimista", 1988, 208, 2L, 2L);
            libroService.crearLibro(9788437604954L, "El principito", 1943, 96, 3L, 2L);
            libroService.crearLibro(9788437604955L, "El retrato de Dorian Gray", 1890, 352, 4L, 2L);
            libroService.crearLibro(9788437604956L, "El señor de los anillos", 1954, 1178, 5L, 2L);
            libroService.crearLibro(9788437604967L, "El señor de los anillos: La comunidad del anillo", 1954, 576, 5L, 2L);
            libroService.crearLibro(9788437604968L, "El señor de los anillos: Las dos torres", 1954, 576, 5L, 2L);
            libroService.crearLibro(9788437604969L, "El señor de los anillos: El retorno del rey", 1955, 576, 5L, 2L);

        } catch (Exception e) {
            System.out.println("Error creando libros " + e.getMessage());
        }
    }
}
