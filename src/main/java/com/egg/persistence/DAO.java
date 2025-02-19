package com.egg.persistence;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class DAO<T> {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final Class<T> clase;


    @SuppressWarnings("unchecked")
    public DAO() {
        this.clase = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<T> listarTodos() {
        try (EntityManager em = getEntityManager()) {
            return em
                    .createQuery("FROM " + clase.getSimpleName(), clase)
                    .getResultList();
        }
    }

    public T buscarPorId(Long id) {
        try (EntityManager em = getEntityManager()) {
            return em.find(clase, id);
        }
    }

    public void guardar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void actualizar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void eliminar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
