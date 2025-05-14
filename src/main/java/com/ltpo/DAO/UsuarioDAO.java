package com.ltpo.DAO;

import com.ltpo.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsuarioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("oficinaPU");

    public void salvar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
