package br.com.caelum.financas.teste;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();

		Query query = em.createQuery("select distinct c from Conta c join fetch c.movimentacoes where c.id = :pId");
		query.setParameter("pId", 2);
		
		List<Conta> lista = query.getResultList();
		for (Conta conta : lista) {
			System.out.println("Titular: "+conta.getTitular() + "\nMovimentações: " + conta.getMovimentacoes().size());
		}
		
	}
	
}
