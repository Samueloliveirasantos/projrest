package br.com.auxiliar.business;

import java.util.List;

import br.com.auxiliar.bean.Continuacao;
import br.com.auxiliar.dao.ContinuacaoDAO;

public class ContinuacaoBO {

	/**
	 * metodo para excluir Continuacao
	 * @param continuacao
	 */
	public void excluirContinuacao(Continuacao continuacao){
		ContinuacaoDAO continuacaoDAO = new ContinuacaoDAO();
		continuacaoDAO.excluirContinuacao(continuacao);
	}
	
	/**
	 * @param continuacao
	 */
	public void alterarContinuacao(Continuacao continuacao){
		ContinuacaoDAO continuacaoDAO = new ContinuacaoDAO();
		continuacaoDAO.alterarContinuacao(continuacao);
	}
	
	/**
	 * @param numero
	 * @return
	 */
	public Continuacao pesquisarContinuacaoMasculino(int numero){
		ContinuacaoDAO continuacaoDAO = new ContinuacaoDAO();
		return continuacaoDAO.findContinuacao(numero, true, false);
	}
	
	/**
	 * @param numero
	 * @return
	 */
	public Continuacao pesquisarContinuacaoFeminino(int numero){
		ContinuacaoDAO continuacaoDAO = new ContinuacaoDAO();
		return continuacaoDAO.findContinuacao(numero, false, true);
	}
	
	/**
	 * @param numero
	 * @return List<Continuacao>
	 */
	public List<Continuacao> listaTodasContinuacoesMasculino(int numero){
		ContinuacaoDAO continuacaoDAO = new ContinuacaoDAO();
		return continuacaoDAO.listaTodasContinuacoes(numero,true, false);
	}
	
	/**
	 * @param numero
	 * @return List<Continuacao>
	 */
	public List<Continuacao> listaTodasContinuacoesFeminino(int numero){
		ContinuacaoDAO continuacaoDAO = new ContinuacaoDAO();
		return continuacaoDAO.listaTodasContinuacoes(numero, false, true);
	}
	
	/**
	 * @return List<Continuacao>
	 */
	public List<Continuacao> listarTodasContinuacoes(){
		ContinuacaoDAO continuacaoDAO = new ContinuacaoDAO();
		return continuacaoDAO.listarContinuacoes();
	}
	
	
	
}
