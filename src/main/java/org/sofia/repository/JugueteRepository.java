package org.sofia.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.sofia.entity.Juguete;

import java.util.List;

public class JugueteRepository {

    private final EntityManagerFactory emf;

    public JugueteRepository() {

        emf = Persistence.createEntityManagerFactory("productoPU");
    }

    public void crear(Juguete producto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Juguete leer(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Juguete.class, id);
        } finally {
            em.close();
        }
    }

    public List<Juguete> leerTodos() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Producto p", Juguete.class)
                    .getResultList();
        }
    }

    public void actualizar(Juguete producto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Juguete producto = em.find(Juguete.class, id);
            if (producto != null) {
                em.remove(producto);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}