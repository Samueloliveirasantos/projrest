package br.com.auxiliar.dao.test;

import java.util.Date;

import br.com.auxiliar.bean.Notificacao;
import br.com.auxiliar.bean.Pessoa;
import br.com.auxiliar.dao.NotificacaoDAO;

public class NotificacaoDAOTEST {

	
	
	public static void main(String[] args) {
		NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
		
		
		Notificacao notificacao = new Notificacao();
		notificacao.setDataCriacao(new Date());
		notificacao.setDescricao("Teste de Notifica��o");
		Pessoa pessoaDestinataria = new Pessoa();
		pessoaDestinataria.setCdPessoa(1);
		notificacao.setPessoaDestinataria(pessoaDestinataria );
		Pessoa pessoaRemetente = new Pessoa();
		pessoaRemetente.setCdPessoa(2);
		notificacao.setPessoaRemetente(pessoaRemetente);
		notificacao.setLida(false);
		notificacaoDAO.incluirNotificacao(notificacao );
		
		for (Notificacao cont : notificacaoDAO.listarNotificacaos()) {
			System.out.println(" Mensagem da Notifica��o " + cont.getDescricao());
			System.out.println(" Data Cria��o " + cont.getDataCriacao());
			System.out.println(" Pessoa Destinataria " + cont.getPessoaDestinataria());
			System.out.println(" Pessoa Remetente " + cont.getPessoaRemetente());
			System.out.println(" lida ?? " + cont.isLida());
		}
		
		Notificacao alterar = new Notificacao();
		alterar.setLida(true);
		
		notificacaoDAO.alterarNotificacao(alterar);
		
		for (Notificacao find : notificacaoDAO.listarNotificacoesRemetente(pessoaRemetente.getCdPessoa())) {
			System.out.println("ALTERA��O");
			System.out.println(" Mensagem da Notifica��o " + find.getDescricao());
			System.out.println(" Data Cria��o " + find.getDataCriacao());
			System.out.println(" Pessoa Destinataria " + find.getPessoaDestinataria());
			System.out.println(" Pessoa Remetente " + find.getPessoaRemetente());
			System.out.println(" lida ?? " + find.isLida());
			
		}
		
		
	}
	

	

}
