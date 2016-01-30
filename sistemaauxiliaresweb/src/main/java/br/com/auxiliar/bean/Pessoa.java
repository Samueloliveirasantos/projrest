package br.com.auxiliar.bean;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pessoa {

	private int cdPessoa;
	private int cdTpPessoa;
	private Continuacao continuacao;
	private String nome;
	private byte[] foto;
	private String email;
	private String senha;
	private Endereco endereco;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private String nomeResponsavel1;
	private String nomeResponsavel2;
	private int aniversario;
	private int idade;
	private Notificacao notificacao;
	private Localidade localidade;
	private List<Presenca> listaPresencas;
	private String observacao;
	private Date dataCriacao;
	private boolean isWhatsapp;
	private boolean isFacebook;
	
	
	
	public Pessoa() {
		super();
	}
	
	
	public Pessoa(int cdTpPessoa, Continuacao continuacao, String nome,
			byte[] foto, String email, String senha, Endereco endereco,
			String telefone1, String telefone2, String telefone3,
			String nomeResponsavel1, String nomeResponsavel2, int aniversario,
			int idade, Localidade localidade,
			String observacao, Date dataCriacao,
			boolean isWhatsapp, boolean isFacebook) {
		super();
		this.cdTpPessoa = cdTpPessoa;
		this.continuacao = continuacao;
		this.nome = nome;
		this.foto = foto;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.nomeResponsavel1 = nomeResponsavel1;
		this.nomeResponsavel2 = nomeResponsavel2;
		this.aniversario = aniversario;
		this.idade = idade;
		this.localidade = localidade;
		this.observacao = observacao;
		this.dataCriacao = dataCriacao;
		this.isWhatsapp = isWhatsapp;
		this.isFacebook = isFacebook;
	}
	
	
	public Pessoa(int cdPessoa, int cdTpPessoa, Continuacao continuacao, String nome,
			byte[] foto, String email, String senha, Endereco endereco,
			String telefone1, String telefone2, String telefone3,
			String nomeResponsavel1, String nomeResponsavel2, int aniversario,
			int idade, Localidade localidade,
			String observacao, Date dataCriacao,
			boolean isWhatsapp, boolean isFacebook) {
		super();
		this.cdPessoa = cdPessoa;
		this.cdTpPessoa = cdTpPessoa;
		this.continuacao = continuacao;
		this.nome = nome;
		this.foto = foto;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.nomeResponsavel1 = nomeResponsavel1;
		this.nomeResponsavel2 = nomeResponsavel2;
		this.aniversario = aniversario;
		this.idade = idade;
		this.localidade = localidade;
		this.observacao = observacao;
		this.dataCriacao = dataCriacao;
		this.isWhatsapp = isWhatsapp;
		this.isFacebook = isFacebook;
	}
	
	
	
	
	/**
	 * @return the cdPessoa
	 */
	public int getCdPessoa() {
		return cdPessoa;
	}
	/**
	 * @param cdPessoa the cdPessoa to set
	 */
	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}
	/**
	 * @return the cdTpPessoa
	 */
	public int getCdTpPessoa() {
		return cdTpPessoa;
	}
	/**
	 * @param cdTpPessoa the cdTpPessoa to set
	 */
	public void setCdTpPessoa(int cdTpPessoa) {
		this.cdTpPessoa = cdTpPessoa;
	}
	/**
	 * @return the continuacao
	 */
	public Continuacao getContinuacao() {
		return continuacao;
	}
	/**
	 * @param continuacao the continuacao to set
	 */
	public void setContinuacao(Continuacao continuacao) {
		this.continuacao = continuacao;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the foto
	 */
	public byte[] getFoto() {
		return foto;
	}
	/**
	 * @param foto the foto to set
	 */
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the telefone1
	 */
	public String getTelefone1() {
		return telefone1;
	}
	/**
	 * @param telefone1 the telefone1 to set
	 */
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	/**
	 * @return the telefone2
	 */
	public String getTelefone2() {
		return telefone2;
	}
	/**
	 * @param telefone2 the telefone2 to set
	 */
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	/**
	 * @return the telefone3
	 */
	public String getTelefone3() {
		return telefone3;
	}
	/**
	 * @param telefone3 the telefone3 to set
	 */
	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
	/**
	 * @return the nomeResponsavel1
	 */
	public String getNomeResponsavel1() {
		return nomeResponsavel1;
	}
	/**
	 * @param nomeResponsavel1 the nomeResponsavel1 to set
	 */
	public void setNomeResponsavel1(String nomeResponsavel1) {
		this.nomeResponsavel1 = nomeResponsavel1;
	}
	/**
	 * @return the nomeResponsavel2
	 */
	public String getNomeResponsavel2() {
		return nomeResponsavel2;
	}
	/**
	 * @param nomeResponsavel2 the nomeResponsavel2 to set
	 */
	public void setNomeResponsavel2(String nomeResponsavel2) {
		this.nomeResponsavel2 = nomeResponsavel2;
	}
	/**
	 * @return the aniversario
	 */
	public int getAniversario() {
		return aniversario;
	}
	/**
	 * @param aniversario the aniversario to set
	 */
	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	/**
	 * @return the idade
	 */
	public int getIdade() {
		return idade;
	}
	/**
	 * @param idade the idade to set
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}
	/**
	 * @return the notificacao
	 */
	public Notificacao getNotificacao() {
		return notificacao;
	}
	/**
	 * @param notificacao the notificacao to set
	 */
	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}
	/**
	 * @return the localidade
	 */
	public Localidade getLocalidade() {
		return localidade;
	}
	/**
	 * @param localidade the localidade to set
	 */
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
	/**
	 * @return the listaPresencas
	 */
	public List<Presenca> getListaPresencas() {
		return listaPresencas;
	}
	/**
	 * @param listaPresencas the listaPresencas to set
	 */
	public void setListaPresencas(List<Presenca> listaPresencas) {
		this.listaPresencas = listaPresencas;
	}
	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}
	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
	/**
	 * @return the isWhatsapp
	 */
	public boolean isWhatsapp() {
		return isWhatsapp;
	}
	/**
	 * @param isWhatsapp the isWhatsapp to set
	 */
	public void setWhatsapp(boolean isWhatsapp) {
		this.isWhatsapp = isWhatsapp;
	}
	/**
	 * @return the isFacebook
	 */
	public boolean isFacebook() {
		return isFacebook;
	}
	/**
	 * @param isFacebook the isFacebook to set
	 */
	public void setFacebook(boolean isFacebook) {
		this.isFacebook = isFacebook;
	}

	
	
		
}
