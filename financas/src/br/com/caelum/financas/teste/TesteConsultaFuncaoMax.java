package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = em.find(Conta.class, 1);
		
		TypedQuery<BigDecimal> query = em.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);
		query.setParameter("pConta", conta);
		System.out.println("Maior movimenta��o: R$" + query.getSingleResult());
		
	}
	
}
