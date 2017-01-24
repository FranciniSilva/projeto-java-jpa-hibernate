package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		// Conta conta = manager.find(Conta.class, 1);
		//
		// System.out.println(conta.getMovimentacoes().size());

		Query query = manager
				.createQuery("select distinct c from Conta c join fetch c.movimentacoes");

		List<Conta> contas = query.getResultList();

		for (Conta conta : contas) {
			System.out.println("Número de Movimentações: "
					+ conta.getMovimentacoes().size());
		}

	}

}
