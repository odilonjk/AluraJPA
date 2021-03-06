package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaEstados {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		Conta conta = em.find(Conta.class, 2);
		System.out.println("Titular: "+conta.getTitular());
		conta.setTitular("Lana Armstrong");
		System.out.println("Titular: "+conta.getTitular());
		em.getTransaction().commit();
		em.close();
		
		
	}
	
}
