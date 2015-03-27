package br.com.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.financas.model.Conta;
import br.com.financas.model.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteContaMovimentacoes3 {
	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(1);

		EntityManager manager = new JPAUtil().getEntityManager();

		String jpql = "select avg(m.valor) from Movimentacao m where m.conta=:pConta "
				+ "and m.tipoMovimentacao=:pTipo";

		TypedQuery<Double> query = manager.createQuery(jpql, Double.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		Double resultado = query.getSingleResult();

		System.out.println("Movimentação média ..: R$ " + resultado);

	}
}
