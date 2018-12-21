package com.myapp.dao;

import com.boraji.tutorial.hibernate.JPAUtil;
import com.myapp.model.Endereco;
import javax.persistence.EntityManager;

public class EnderecoDAO {

    public boolean insertEndereco(Endereco endereco) {
        try {
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(endereco);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

    public boolean deleteEndereco(Endereco endereco) {
        try {
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            endereco = entityManager.find(Endereco.class, endereco.getId());
            entityManager.remove(endereco);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
