package br.com.auxiliar.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Notificacao {
	
	private int cdNotificacao;
	private Pessoa pessoaRemetente;
	private Pessoa pessoaDestinataria;
	private boolean isLida;
	private String descricao;
	private Date dataCriacao;
	
	
	
	/**
	 * @return the cdNotificacao
	 */
	public int getCdNotificacao() {
		return cdNotificacao;
	}
	/**
	 * @param cdNotificacao the cdNotificacao to set
	 */
	public void setCdNotificacao(int cdNotificacao) {
		this.cdNotificacao = cdNotificacao;
	}
	
	/**
	 * @return the pessoaRemetente
	 */
	public Pessoa getPessoaRemetente() {
		return pessoaRemetente;
	}
	/**
	 * @param pessoaRemetente the pessoaRemetente to set
	 */
	public void setPessoaRemetente(Pessoa pessoaRemetente) {
		this.pessoaRemetente = pessoaRemetente;
	}
	/**
	 * @return the pessoaDestinataria
	 */
	public Pessoa getPessoaDestinataria() {
		return pessoaDestinataria;
	}
	/**
	 * @param pessoaDestinataria the pessoaDestinataria to set
	 */
	public void setPessoaDestinataria(Pessoa pessoaDestinataria) {
		this.pessoaDestinataria = pessoaDestinataria;
	}
	/**
	 * @return the isLida
	 */
	public boolean isLida() {
		return isLida;
	}
	/**
	 * @param isLida the isLida to set
	 */
	public void setLida(boolean isLida) {
		this.isLida = isLida;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}
	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	

}
