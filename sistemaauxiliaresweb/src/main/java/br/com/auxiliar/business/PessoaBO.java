package br.com.auxiliar.business;

import java.util.List;

import br.com.auxiliar.bean.Continuacao;
import br.com.auxiliar.bean.Pessoa;
import br.com.auxiliar.bean.TipoPessoa;
import br.com.auxiliar.dao.ContinuacaoDAO;
import br.com.auxiliar.dao.PessoaDAO;

public class PessoaBO {

	/**
	 * metodo de inclus�o de Pessoa
	 * @param pessoa
	 */
	public void incluirPessoa(Pessoa pessoa){
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.incluirPessoa(pessoa);
	}
	
	
	/**
	 * metodo de inclus�o de Auxiliar
	 * @param pessoa
	 */
	public void incluirAuxiliar(Pessoa pessoa, Continuacao continuacao){
		ContinuacaoDAO continuacaoDAO = new ContinuacaoDAO();
		continuacaoDAO.incluirContinuacao(continuacao);
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoa.setCdTpPessoa(TipoPessoa.AUXILIAR.getCode());
		pessoaDAO.incluirPessoa(pessoa);
	}
	
	/**
	 * metodo de Exclusao
	 * @param pessoa
	 */
	public void excluirPessoa(Pessoa pessoa){
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.excluirPessoa(pessoa);
	}
	
	/**
	 * metodo de Altera��o de pessoa
	 * @param pessoa
	 */
	public void alterarPessoa(Pessoa pessoa){
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.alterarPessoa(pessoa);
	}
	
	
	/**
	 * metodo de listar pessoas
	 * @return List<Pessoa>
	 */
	public List<Pessoa> listarPessoas(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.listarPessoas();
	}
	
	/**
	 * metodo de listar pessoas de uma determinada continua��o
	 * do sexo masculino
	 * @return List<Pessoa>
	 */
	public List<Pessoa> listarPessoasContinuacaoMasculino(int numeroContinuacao){
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.listarPessoasContinuacao(numeroContinuacao, true, false);
	}
	
	/**
	 * metodo de listar pessoas de uma determinada continua��o
	 * do sexo feminino
	 * @return List<Pessoa>
	 */
	public List<Pessoa> listarPessoasContinuacaoFeminino(int numeroContinuacao){
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.listarPessoasContinuacao(numeroContinuacao, false, true);
	}
	
	
	/**
	 * metodo para listar todos os Auxiliares do sexo Masculino
	 * @return List<Pessoa>
	 */
	public List<Pessoa> listarTodosAuxiliaresHomens(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.listarAuxiliares(true, false);
	}
	

	/**
	 * metodo para listar todas os Auxiliares do sexo Feminino
	 * @return List<Pessoa>
	 */
	public List<Pessoa> listarTodasAuxiliaresMulheres(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.listarAuxiliares(false, true);
	}
	
	/**
	 * pesquisa de pessoa por cdPessoa
	 * @param cdPessoa
	 * @return Pessoa
	 */
	public Pessoa findPessoa(int cdPessoa){
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.findPessoa(cdPessoa);
	}
	
	/**
     * pesquisa de pessoa por nome de Pessoa
	 * @param nomePessoa
	 * @return List<Pessoa>
	 */
	public List<Pessoa> findPessoaPorNome(String nomePessoa){
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.findPessoaPorNome(nomePessoa);
	}
	
	
	/**
	 * pesquisar pessoas com presenca de uma continuacao 
	 * @param numeroContinuacao
	 * @return List<Pessoa>
	 */
	public List<Pessoa> listarTodasPessoasComPresencaDeUmaContinuacao(int numeroContinuacao){
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.listarTodasPessoasComPresencaDeUmaContinuacao(numeroContinuacao);
	}
	
	/**
	 * pesquisar pessoas com falta de uma continuacao 
	 * @param numeroContinuacao
	 * @return List<Pessoa>
	 */
	public List<Pessoa> listarTodasPessoasComFaltaDeUmaContinuacao(int numeroContinuacao){
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.listarTodasPessoasComFaltaDeUmaContinuacao(numeroContinuacao);
	}
	
}
