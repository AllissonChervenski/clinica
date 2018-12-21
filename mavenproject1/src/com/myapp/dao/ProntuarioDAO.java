package com.myapp.dao;

import com.boraji.tutorial.hibernate.JPAUtil;
import com.myapp.model.Prontuario;
import java.util.Collection;
import javax.persistence.EntityManager;

public class ProntuarioDAO
{

    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    public boolean insertProntuario(Prontuario prontuario)
    {
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(prontuario);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

    public Collection<Prontuario> selectAll()
    {
        String oql = "From " + Prontuario.class.getName() + "";
        Collection<Prontuario> listDados = null;
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        listDados = entityManager.createQuery(oql).getResultList();
        entityManager.close();
        
        return listDados;
    }

    public boolean updateProntuario(Prontuario prontuario)
    {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(prontuario);
            entityManager.getTransaction().commit();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();

            return false;
        }

    }

    public boolean deleteProntuario(Prontuario prontuario)
    {
        try {
            entityManager.getTransaction().begin();
            prontuario = entityManager.find(Prontuario.class, prontuario.getId());
            entityManager.remove(prontuario);
            entityManager.getTransaction().commit();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();

            return false;
        }
    }

}
