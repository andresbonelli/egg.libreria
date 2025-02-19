package com.egg.service;

import com.egg.dto.LibroResponseDTO;
import com.egg.entity.Autor;
import com.egg.entity.Editorial;
import com.egg.entity.Libro;
import com.egg.persistence.LibroDAO;
import jakarta.transaction.Transactional;

import java.util.List;


public class LibroService {
    private final LibroDAO libroDAO;
    private final AutorService autorService;
    private final EditorialService editorialService;

    public LibroService() {
        libroDAO = new LibroDAO();
        autorService = new AutorService();
        editorialService = new EditorialService();
    }

    public List<LibroResponseDTO> listarLibros() {
        List<Libro> libros = libroDAO.listarTodos();
        return libros.stream().map(libro -> new LibroResponseDTO(
                libro.getIsbn(),
                libro.getTitulo(),
                libro.getAnio(),
                libro.getEjemplares(),
                libro.getAutor().getNombre(),
                libro.getEditorial().getNombre()
        )).toList();
    }

    public LibroResponseDTO buscarLibroPorIsbn(Long isbn) {

        Libro libro = libroDAO.buscarPorId(isbn);
        return new LibroResponseDTO(
                libro.getIsbn(),
                libro.getTitulo(),
                libro.getAnio(),
                libro.getEjemplares(),
                libro.getAutor().getNombre(),
                libro.getEditorial().getNombre()
        );
    }

    @Transactional
    public void crearLibro(
            Long isbn,
            String titulo,
            Integer anio,
            Integer ejemplares,
            Long idAutor,
            Long idEditorial
            ) {
        Autor autor = autorService.buscarPorId(idAutor);
        Editorial editorial = editorialService.buscarPorId(idEditorial);

        if (autor == null || editorial == null) {
            throw new RuntimeException("Autor o Editorial no encontrados");
        }
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setAlta(true);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libroDAO.guardar(libro);
    }
    public void modificarLibro(Libro libro) {
        libroDAO.actualizar(libro);
    }
    public void eliminarLibro(Long isbn) {
        Libro libro = libroDAO.buscarPorId(isbn);
        libroDAO.eliminar(libro);
    }
}
