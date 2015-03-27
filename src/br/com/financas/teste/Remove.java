package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.model.Conta;
import br.com.financas.util.JPAUtil;

public class Remove {
	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		Conta conta = manager.find(Conta.class, 2);

		manager.remove(conta);

		manager.getTransaction().commit();
		manager.close();
	}
}
