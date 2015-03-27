package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.model.Conta;
import br.com.financas.util.JPAUtil;

public class Insert {
	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Marco Veio");
		conta.setBanco("Safra");
		conta.setAgencia("876");
		conta.setNumero("9875");

		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();

		manager.persist(conta);

		manager.getTransaction().commit();
		manager.close();
	}
}
