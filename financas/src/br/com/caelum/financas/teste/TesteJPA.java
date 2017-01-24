package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Irene Rita");
		conta.setBanco("237 - BANCO BRADESCO");
		conta.setNumero("86759-1");
		conta.setAgencia("1745");
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		
		System.out.println(conta.getId());
		
		em.getTransaction().commit();
		em.close();

	}

}
