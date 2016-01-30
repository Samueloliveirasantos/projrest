package br.com.auxiliar.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Continuacao {
	
	private int cdContinuacao;
	private Pessoa pessoa;
	private int numero;
	private boolean isMasculino;
	private boolean isFeminino;
	private int intervaloInicio;
	private int intervaloFim;
	
	
	
	
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
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * @return the isMasculino
	 */
	public boolean isMasculino() {
		return isMasculino;
	}
	/**
	 * @param isMasculino the isMasculino to set
	 */
	public void setMasculino(boolean isMasculino) {
		this.isMasculino = isMasculino;
	}
	/**
	 * @return the isFeminino
	 */
	public boolean isFeminino() {
		return isFeminino;
	}
	/**
	 * @param isFeminino the isFeminino to set
	 */
	public void setFeminino(boolean isFeminino) {
		this.isFeminino = isFeminino;
	}
	/**
	 * @return the intervaloInicio
	 */
	public int getIntervaloInicio() {
		return intervaloInicio;
	}
	/**
	 * @param intervaloInicio the intervaloInicio to set
	 */
	public void setIntervaloInicio(int intervaloInicio) {
		this.intervaloInicio = intervaloInicio;
	}
	/**
	 * @return the intervaloFim
	 */
	public int getIntervaloFim() {
		return intervaloFim;
	}
	/**
	 * @param intervaloFim the intervaloFim to set
	 */
	public void setIntervaloFim(int intervaloFim) {
		this.intervaloFim = intervaloFim;
	}
	

}
