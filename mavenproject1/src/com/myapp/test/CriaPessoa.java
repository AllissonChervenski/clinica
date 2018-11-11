package com.myapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;

import com.boraji.tutorial.hibernate.JPAUtil;
import com.myapp.model.Empregado;
import com.myapp.model.Paciente;
import com.myapp.model.Pessoa;

public class CriaPessoa {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
//			entityManager.getTransaction().begin();
//
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			Pessoa p1 = new Empregado();
//			p1.setNome("Pedro");
//			//p1.setDataNascimento(sdf.parse("12/12/2001"));
//			entityManager.persist(p1);
//			
//			entityManager.getTransaction().commit();
			
			// Retorna a quantidade de pessoas cadastradas por meio de uma consulta SQL
//			String sql = "select count(*) from TB_Pessoa";
//
//			Object result = entityManager.createNativeQuery(sql).getSingleResult();
//			System.out.println("Quantidade de pessoas cadatradas = " + result);

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		JPAUtil.shutdown();
	}

}
