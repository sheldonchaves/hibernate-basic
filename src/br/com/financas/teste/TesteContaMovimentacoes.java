package br.com.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.model.Conta;
import br.com.financas.model.Movimentacao;
import br.com.financas.util.JPAUtil;

public class TesteContaMovimentacoes {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

        Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes where c.id = :pId");
        query.setParameter("pId", 1);
        Conta conta = (Conta) query.getSingleResult();

        manager.close();

        System.out.println(conta.getMovimentacoes().size());
        
        for (int i=0; i < conta.getMovimentacoes().size(); i++) {
        	System.out.println(conta.getMovimentacoes().get(i).getDescricao() );
        }
	}
}
