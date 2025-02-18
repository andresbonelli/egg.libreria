package com.egg.service;

import com.egg.entity.Autor;
import com.egg.persistence.AutorDAO;
import lombok.RequiredArgsConstructor;


public class AutorService {

    private final AutorDAO autorDAO;

    public AutorService() {
        this.autorDAO = new AutorDAO();
    }

    public Autor buscarPorId(Long id) {
        return autorDAO.buscarPorId(id);
    }

    public Autor buscarPorNombre(String nombre) {
        return autorDAO.buscarAutorPorNombre(nombre);
    }

    public void crearAutor(String nombre) {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre del autor no puede ser nulo o vacío");
            }

            Autor autor = new Autor();
            autor.setNombre(nombre);
            autor.setAlta(true);

            autorDAO.guardar(autor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarAutor(Autor autor) {
        autorDAO.actualizar(autor);
    }
    public void eliminarAutor(Long id) {
        Autor autor = autorDAO.buscarPorId(id);
        autorDAO.eliminar(autor);
    }



}
