package br.com.auxiliar.business;

import java.util.List;

import br.com.auxiliar.bean.Notificacao;
import br.com.auxiliar.dao.NotificacaoDAO;

public class NotificacaoBO {
	
	
	
	/**
	 * metodo para incluir notificacao 
	 * @param notificacao
	 */
	public void incluirNotificacao(Notificacao notificacao){
		NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
		notificacaoDAO.incluirNotificacao(notificacao);
	}
	
	/**
	 * metodo alterar notificacao 
	 * @param notificacao
	 */
	public void alterarNotificacao(Notificacao notificacao){
		NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
		notificacaoDAO.alterarNotificacao(notificacao);
	}

	/**
	 * metodo para excluir Notificacao 
	 * @param cdNotificacao
	 */
	public void excluirNotificacao(int cdNotificacao){
		NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
		notificacaoDAO.excluirNotificacao(cdNotificacao);
	}

	/**
	 * metodo listar todas notificacoes do remetente
	 * @param cdRemetente
	 * @return List<Notificacao>
	 */
	public List<Notificacao> listarTodasNotificacoesRemetente(int cdRemetente){
		NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
		return notificacaoDAO.listarNotificacoesRemetente(cdRemetente);
	}
	
	/**
	 * metodo listar todas notificacoes do destinatario
	 * @param cdDestinatario
	 * @return List<Notificacao>
	 */
	public List<Notificacao> listarTodasNotificacoesDestinatario(int cdDestinatario){
		NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
		return notificacaoDAO.listarNotificacoesDestinatario(cdDestinatario);
	}
	
	
	/**
	 * metodo listar todas notificacoes do remetente não lidas
	 * @param cdRemetente
	 * @return List<Notificacao>
	 */
	public List<Notificacao> listarTodasNotificacoesNlida(int cdRemetente){
		NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
		return notificacaoDAO.listarNotificacoesRemetenteNLida(cdRemetente);
	}
	
}