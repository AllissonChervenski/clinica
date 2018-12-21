package com.myapp.dao;

import com.boraji.tutorial.hibernate.JPAUtil;
import com.myapp.model.Empregado;
import java.util.Collection;
import javax.persistence.EntityManager;

public class EmpregadoDAO {

    public boolean insertEmpregado(Empregado empregado) {
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

    public boolean deleteEmpregado(Empregado empregado) {
        try {
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            empregado = entityManager.find(Empregado.class, empregado.getId());
            entityManager.remove(empregado);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Collection<Empregado> selectAll() {
        String oql = "From " + Empregado.class.getName() + "";
        Collection<Empregado> listDados = null;
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        listDados = entityManager.createQuery(oql).getResultList();
        entityManager.close();
        return listDados;
    }
}
