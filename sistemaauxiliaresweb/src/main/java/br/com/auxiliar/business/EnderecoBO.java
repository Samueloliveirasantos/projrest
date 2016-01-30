package br.com.auxiliar.business;

import java.util.List;

import br.com.auxiliar.bean.Endereco;
import br.com.auxiliar.dao.EnderecoDAO;

public class EnderecoBO {

	/**
	 * metodo de inclusao de endereco 
	 * @param endereco
	 */
	public void incluirEndereco(Endereco endereco){
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.incluirEndereco(endereco);
	}
	
	/**
	 * metodo para excluir um endereco
	 * @param cdEndereco
	 */
	public void excluirEndereco(int cdEndereco){
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.excluirEndereco(cdEndereco);
	}
	
	/**
	 * metodo altera um endereco
	 * @param endereco
	 */
	public void alterarEndereco(Endereco endereco){
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.alterarEndereco(endereco);
	}
	
	/**
	 * metodo lista todos os enderecos da Base
	 * @return List<Endereco>
	 */
	public List<Endereco> listarEnderecos(){
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		return enderecoDAO.listarEnderecos();
	}
	
}
