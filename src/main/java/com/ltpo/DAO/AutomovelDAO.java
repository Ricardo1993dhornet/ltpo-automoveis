package com.ltpo.DAO;

import com.ltpo.model.Automovel;

import jakarta.persistence.*;
import java.util.List;

public class AutomovelDAO {

    private EntityManagerFactory emf;
    public EntityManager getEntityManager() {
        return emf.createEntityManager(); // Cria um novo EntityManager a partir do EntityManagerFactory
    }

    public AutomovelDAO(){
        emf = Persistence.createEntityManagerFactory("automovelPU");
        EntityManager em = getEntityManager();
    }

    public void salvar(Automovel automovel){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        if (automovel.getId() == null) {
            em.persist(automovel);
        } else {
            em.merge(automovel);
        }
        em.getTransaction().commit();
    }

    public List<Automovel> buscarTodos(){
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT a FROM Automovel a", Automovel.class).getResultList();
    }

    public Automovel buscarPorId(Integer id){
        EntityManager em = getEntityManager(); // Obtém o EntityManager
        try {
            em.getTransaction().begin();  // Inicia a transação
            Automovel automovel = em.find(Automovel.class, id); // Busca pelo ID
            em.getTransaction().commit(); // Confirma a transação
            return automovel;
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