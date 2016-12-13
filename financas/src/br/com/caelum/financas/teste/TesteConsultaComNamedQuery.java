package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaComNamedQuery {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = em.find(Conta.class, 1);
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		Long total = dao.totalDeMovimentacoes(conta);
		System.out.println("Conta: " + conta.getNumero() + "\nTitular: " + conta.getTitular() + "\nTotal de movimentações: " + total);
		
	}
	
}
