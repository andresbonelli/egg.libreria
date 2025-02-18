package com.egg.service;

import com.egg.entity.Editorial;
import com.egg.persistence.EditorialDAO;

public class EditorialService {
    private final EditorialDAO editorialDAO;

    public EditorialService() {
        editorialDAO = new EditorialDAO();
    }

    public Editorial buscarPorId(Long id) {
        return editorialDAO.buscarPorId(id);
    }

    public void crearEditorial(String nombre) {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre de la editorial no puede ser nulo o vacío");
            }

            Editorial editorial = new Editorial();
            editorial.setNombre(nombre);
            editorial.setAlta(true);

            editorialDAO.guardar(editorial);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
