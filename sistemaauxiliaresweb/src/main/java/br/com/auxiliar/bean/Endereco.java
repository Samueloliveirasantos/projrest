package br.com.auxiliar.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Endereco {
	
	private int cdEndereco;
	private Pessoa pessoa;
	private String dsRua;
	private String dsBairro;
	private String dsCidade;
	private String dsEstado;
	private String dsPais;
	private int numero;
	
	
	
	/**
	 * @return the cdEndereco
	 */
	public int getCdEndereco() {
		return cdEndereco;
	}
	/**
	 * @param cdEndereco the cdEndereco to set
	 */
	public void setCdEndereco(int cdEndereco) {
		this.cdEndereco = cdEndereco;
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
	 * @return the dsRua
	 */
	public String getDsRua() {
		return dsRua;
	}
	/**
	 * @param dsRua the dsRua to set
	 */
	public void setDsRua(String dsRua) {
		this.dsRua = dsRua;
	}
	/**
	 * @return the dsBairro
	 */
	public String getDsBairro() {
		return dsBairro;
	}
	/**
	 * @param dsBairro the dsBairro to set
	 */
	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}
	/**
	 * @return the dsCidade
	 */
	public String getDsCidade() {
		return dsCidade;
	}
	/**
	 * @param dsCidade the dsCidade to set
	 */
	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}
	/**
	 * @return the dsEstado
	 */
	public String getDsEstado() {
		return dsEstado;
	}
	/**
	 * @param dsEstado the dsEstado to set
	 */
	public void setDsEstado(String dsEstado) {
		this.dsEstado = dsEstado;
	}
	/**
	 * @return the dsPais
	 */
	public String getDsPais() {
		return dsPais;
	}
	/**
	 * @param dsPais the dsPais to set
	 */
	public void setDsPais(String dsPais) {
		this.dsPais = dsPais;
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

	
	
	
	

}
