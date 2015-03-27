package br.com.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financas.model.Conta;
import br.com.financas.model.Movimentacao;
import br.com.financas.model.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class Relacionamento {
	public static void main(String[] args) {
		Conta conta = new Conta();
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("carro");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("350"));
		movimentacao.setData(Calendar.getInstance());
		
		
		
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		conta = manager.find(Conta.class, 1);
		movimentacao.setConta(conta);
		
		manager.persist(conta);
		manager.persist(movimentacao);

		manager.getTransaction().commit();
		manager.close();
	}
}
