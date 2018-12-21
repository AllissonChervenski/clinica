package com.myapp.dao;

import com.boraji.tutorial.hibernate.JPAUtil;
import com.myapp.model.Endereco;
import java.util.Collection;
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

    public Collection<Endereco> selectAll() {
        String oql = "From " + Endereco.class.getName() + "";
        Collection<Endereco> listDados = null;
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        listDados = entityManager.createQuery(oql).getResultList();
        entityManager.close();
        return listDados;
    }

    public boolean updateEndereco(Endereco endereco) {
        try {
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(endereco);
            entityManager.getTransaction().commit();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
}
