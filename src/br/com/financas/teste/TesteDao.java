package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.dao.MovimentacaoDao;
import br.com.financas.model.Conta;
import br.com.financas.model.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteDao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		MovimentacaoDao dao = new MovimentacaoDao(manager);

		Conta conta = new Conta();
		conta.setId(1);

		Double resultado = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.ENTRADA);

		System.out.println("Movimentação média ..: R$ " + resultado);
	}
}
