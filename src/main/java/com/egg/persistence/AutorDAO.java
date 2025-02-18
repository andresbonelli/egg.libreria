package com.egg.persistence;

import com.egg.entity.Autor;
import jakarta.persistence.EntityManager;

public class AutorDAO extends DAO<Autor> {

    public Autor buscarAutorPorNombre(String nombre) {
        try (EntityManager em = getEntityManager()) {
            return em
                    .createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre", Autor.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        }
    }
}
