package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaComDAO {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = em.find(Conta.class, 3);
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		Double media = dao.mediaDaConta(conta);
		System.out.println("Titular: " + conta.getTitular() + "\nM�dia das movimenta��es: R$" + media);
		
	}
	
}
