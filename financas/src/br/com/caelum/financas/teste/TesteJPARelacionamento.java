package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Carolina Lopes");
		conta.setBanco("104 - CAIXA ECONOMICA FEDERAL");
		conta.setNumero("98654-3");
		conta.setAgencia("1234");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123.9"));
		
		movimentacao.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);

		em.persist(movimentacao);

		em.getTransaction().commit();
		em.close();

	}

}
