package com.egg.persistence;

import com.egg.entity.Libro;
import jakarta.persistence.EntityManager;

public class LibroDAO extends DAO<Libro>{

    @Override
    public void guardar(Libro libro) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }

    }
}
