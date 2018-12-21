package com.myapp.dao;

import com.boraji.tutorial.hibernate.JPAUtil;
import com.myapp.model.Prontuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

    @SuppressWarnings("unchecked")
    public List<Prontuario> findAll()
    {
        return entityManager.createQuery("FROM " + Prontuario.class.getName()).getResultList();
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
