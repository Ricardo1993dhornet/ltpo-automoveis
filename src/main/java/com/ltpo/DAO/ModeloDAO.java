package com.ltpo.DAO;

import com.ltpo.model.Modelo;

import jakarta.persistence.*;
import java.util.List;

public class ModeloDAO {

    private EntityManagerFactory emf;
    public EntityManager getEntityManager() {
        return emf.createEntityManager(); // Cria um novo EntityManager a partir do EntityManagerFactory
    }

    public ModeloDAO(){
        emf = Persistence.createEntityManagerFactory("oficinaPU");
        EntityManager em = getEntityManager();
    }

    public void salvar(Modelo modelo){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        if (modelo.getId() == null) {
            em.persist(modelo);
        } else {
            em.merge(modelo);
        }
        em.getTransaction().commit();
    }

    public List<Modelo> buscarTodos(){
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT m FROM Modelo m", Modelo.class).getResultList();
    }

    public Modelo buscarPorId(Integer id){
        EntityManager em = getEntityManager(); // Obtém o EntityManager
        try {
            em.getTransaction().begin();  // Inicia a transação
            Modelo modelo = em.find(Modelo.class, id); // Busca pelo ID
            em.getTransaction().commit(); // Confirma a transação
            return modelo;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback em caso de erro
            }
            e.printStackTrace();
            return null;
        } finally {
            em.close(); // Fecha o EntityManager
        }
    }



}