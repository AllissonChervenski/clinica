package com.myapp.dao;

import com.boraji.tutorial.hibernate.JPAUtil;
import com.myapp.model.Empregado;
import javax.persistence.EntityManager;

public class EmpregadoDAO {
public boolean insertEmpregado(Empregado empregado)
    {
        try {
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(empregado);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}