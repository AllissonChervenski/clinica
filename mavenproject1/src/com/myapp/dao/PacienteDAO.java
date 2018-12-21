package com.myapp.dao;

import com.boraji.tutorial.hibernate.JPAUtil;
import com.myapp.model.Paciente;
import java.util.Collection;
import javax.persistence.EntityManager;

public class PacienteDAO
{

    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    public boolean insertPaciente(Paciente paciente)
    {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(paciente);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

    public Collection<Paciente> selectAll()
    {
        String oql = "From " + Paciente.class.getName() + "";
        Collection<Paciente> listDados = null;
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        listDados = entityManager.createQuery(oql).getResultList();
        entityManager.close();

        return listDados;
    }

    public boolean updateProntuario(Paciente paciente)
    {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(paciente);
            entityManager.getTransaction().commit();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();

            return false;
        }

    }

    public boolean deleteProntuario(Paciente paciente)
    {
        try {
            entityManager.getTransaction().begin();
            paciente = entityManager.find(Paciente.class, paciente.getId());
            entityManager.remove(paciente);
            entityManager.getTransaction().commit();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();

            return false;
        }
    }
}
