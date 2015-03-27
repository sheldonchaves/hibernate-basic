package br.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.model.Conta;
import br.com.financas.model.Movimentacao;
import br.com.financas.model.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class Search {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
        conta.setId(1);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Query query = manager
                .createQuery("select m from Movimentacao m where m.conta = :pConta"
                        + " and m.tipoMovimentacao = :pTipo");

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
            System.out.println("\nDescricao ..: " + m.getDescricao());
            System.out.println("Valor ......: R$ " + m.getValor());
        }

        manager.close();
	}
}
