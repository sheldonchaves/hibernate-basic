package br.com.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.financas.model.Conta;
import br.com.financas.model.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TypedQueryTest {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		String jpqlAvg = "select avg(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo";
		
		String jpqlSum = "select sum(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo";

        TypedQuery<Double> queryAvg = manager.createQuery(jpqlAvg, Double.class);
        TypedQuery<BigDecimal> querySum = manager.createQuery(jpqlSum, BigDecimal.class);

        queryAvg.setParameter("pConta", conta);
        queryAvg.setParameter("pTipo", TipoMovimentacao.SAIDA);
        
        querySum.setParameter("pConta", conta);
        querySum.setParameter("pTipo", TipoMovimentacao.SAIDA);

        Double resultadoAvg = queryAvg.getSingleResult();
        BigDecimal resultadoSum = querySum.getSingleResult();
        

        System.out.println("Media movimentado ..: R$ " + resultadoAvg);
        System.out.println("Soma movimentado ..: R$ " + resultadoSum);
	}
}
