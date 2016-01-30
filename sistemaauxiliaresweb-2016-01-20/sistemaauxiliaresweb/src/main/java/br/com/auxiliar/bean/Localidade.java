package br.com.auxiliar.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Localidade {

	private int cdLocalidade;
	private String dsLocalidade;
	private Date dataCriacao;
	
	/**
	 * @return the cdLocalidade
	 */
	public int getCdLocalidade() {
		return cdLocalidade;
	}
	/**
	 * @param cdLocalidade the cdLocalidade to set
	 */
	public void setCdLocalidade(int cdLocalidade) {
		this.cdLocalidade = cdLocalidade;
	}
	/**
	 * @return the dsLocalidade
	 */
	public String getDsLocalidade() {
		return dsLocalidade;
	}
	/**
	 * @param dsLocalidade the dsLocalidade to set
	 */
	public void setDsLocalidade(String dsLocalidade) {
		this.dsLocalidade = dsLocalidade;
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
