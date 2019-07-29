package br.com.caelum.financas.modelo.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
	Conta conta = new Conta();
	conta.setTitular("Leonardo");
	conta.setAgencia("123");
	conta.setBanco("CAIXA ECONOMICA");
	conta.setNumero("456");
	
	Movimentacao movimentacao = new Movimentacao();
	movimentacao.setData(Calendar.getInstance());
	movimentacao.setDescricao("Churrascaria");
	movimentacao.setTipo(TipoMovimentacao.SAIDA);
	movimentacao.setValor(new BigDecimal(200));
	movimentacao.setConta(conta);
	
	EntityManager em = new JPAUtil().getEntityManager();
	
	em.getTransaction().begin();
	em.persist(conta);
	em.persist(movimentacao);
	em.getTransaction().commit();
	
	em.close();
	}
}
