package br.com.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.model.Conta;
import br.com.financas.model.Movimentacao;
import br.com.financas.model.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteContaMovimentacoes2 {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

        Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes where c.id = :pId");
        query.setParameter("pId", 1);
        Conta conta = (Conta) query.getSingleResult();

        manager.close();

        List<Movimentacao> movimentacoes = conta.getMovimentacoes();
        
        String entradas = "";
        Double totalEntradas = new Double(0);
        String saidas = "";
        Double totalSaidas = new Double(0);
        
        System.out.println("Movimentações: (" + conta.getMovimentacoes().size() +")\n");
        for (Movimentacao m : movimentacoes) {
        	if (m.getTipoMovimentacao() == TipoMovimentacao.ENTRADA){
        		entradas += "Descricao ..: " + m.getDescricao();
        		entradas += "\nValor ......: R$ +" + m.getValor() + "\n";
        		totalEntradas += m.getValor().doubleValue();
        	} else {
        		saidas += "Descricao ..: " + m.getDescricao();
        		saidas += "\nValor ......: R$ -" + m.getValor() + "\n";
        		totalSaidas += m.getValor().doubleValue();
        	}
        }
        System.out.println("== Entradas (R$: +" + totalEntradas + ")");
        System.out.println(entradas);
        
        System.out.println("== Saidas (R$: -" + totalSaidas + ")");
        System.out.println(saidas);
        
        System.out.println("Saldo: R$ " + (totalEntradas-totalSaidas));
	}
}
