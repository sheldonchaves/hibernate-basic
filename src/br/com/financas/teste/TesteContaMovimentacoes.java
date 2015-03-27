package br.com.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.model.Conta;
import br.com.financas.model.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteContaMovimentacoes {
	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(1);

		EntityManager manager = new JPAUtil().getEntityManager();

		String jpql = "select sum(m.valor) from Movimentacao m where m.conta=:pConta "
				+ "and m.tipoMovimentacao=:pTipo";

		Query query = manager.createQuery(jpql);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        BigDecimal resultado = (BigDecimal) query.getSingleResult();

        System.out.println("Total movimentado ..: R$ " + resultado);
	}
}
