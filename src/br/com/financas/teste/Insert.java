package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.model.Conta;
import br.com.financas.util.JPAUtil;

public class Insert {
	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("jose dos Santos");
		conta.setBanco("Itau");
		conta.setAgencia("0453");
		conta.setNumero("56621");

		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();

		manager.persist(conta);

		manager.getTransaction().commit();
		manager.close();
	}
}
