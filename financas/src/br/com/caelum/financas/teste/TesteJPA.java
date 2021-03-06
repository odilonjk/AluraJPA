package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		
		double inicio = System.currentTimeMillis();
		
		Conta conta = new Conta();
		conta.setBanco("China Bank");
		conta.setNumero("112233");
		conta.setAgencia("3210");
		conta.setTitular("Shing Shunlon");
		
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		
		double fim = System.currentTimeMillis();
		
		System.out.println("Tempo de execu��o: "+(fim-inicio)+"ms");
		
	}
	
}
