package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.Movimentacao.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();

		double inicio = System.currentTimeMillis();
		
		Conta conta = em.find(Conta.class, 3);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Cartão de Crédito");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("724.00"));
		movimentacao.setConta(conta);
		
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		
		em.close();
		
		double fim = System.currentTimeMillis();
		
		System.out.println("Tempo de execução: "+(fim-inicio)+"ms");
		
	}
	
}
