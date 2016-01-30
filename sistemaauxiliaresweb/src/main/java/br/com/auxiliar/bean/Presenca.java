package br.com.auxiliar.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Presenca {
	
	private int cdPresenca;
	private Pessoa pessoa;
	private int cdContinuacao;
	private Date dataPresenca;
	private boolean isPresenca;
	
	
	/**
	 * @return the cdPresenca
	 */
	public int getCdPresenca() {
		return cdPresenca;
	}
	/**
	 * @param cdPresenca the cdPresenca to set
	 */
	public void setCdPresenca(int cdPresenca) {
		this.cdPresenca = cdPresenca;
	}
	
	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}
	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	/**
	 * @return the cdContinuacao
	 */
	public int getCdContinuacao() {
		return cdContinuacao;
	}
	/**
	 * @param cdContinuacao the cdContinuacao to set
	 */
	public void setCdContinuacao(int cdContinuacao) {
		this.cdContinuacao = cdContinuacao;
	}
	/**
	 * @return the dataPresenca
	 */
	public Date getDataPresenca() {
		return dataPresenca;
	}
	/**
	 * @param dataPresenca the dataPresenca to set
	 */
	public void setDataPresenca(Date dataPresenca) {
		this.dataPresenca = dataPresenca;
	}
	/**
	 * @return the isPresenca
	 */
	public boolean isPresenca() {
		return isPresenca;
	}
	/**
	 * @param isPresenca the isPresenca to set
	 */
	public void setPresenca(boolean isPresenca) {
		this.isPresenca = isPresenca;
	}
	
	
	

}
