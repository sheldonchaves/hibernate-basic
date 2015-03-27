package br.com.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.financas.model.Conta;
import br.com.financas.model.TipoMovimentacao;

public class MovimentacaoDao {
	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}

	public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {

		TypedQuery<Double> query = manager.createQuery("select avg(m.valor) from Movimentacao m where m.conta=:pConta "
				+ " and m.tipoMovimentacao = :pTipo", Double.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);

		return query.getSingleResult();
	}
}
