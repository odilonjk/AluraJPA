package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.Movimentacao.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = em.find(Conta.class, 3);
		
		Query query = em.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
		query.setParameter("pConta", conta);
		
		System.out.println("Quantidade de movimentações: "+ query.getSingleResult());
		
		em.close();
		
	}
	
}
