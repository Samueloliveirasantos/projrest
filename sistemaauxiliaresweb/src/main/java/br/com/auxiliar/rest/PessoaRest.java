package br.com.auxiliar.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.auxiliar.bean.Continuacao;
import br.com.auxiliar.bean.Pessoa;
import br.com.auxiliar.business.PessoaBO;


@Path("/pessoa")
public class PessoaRest {


	@GET
	@Path("/todasPessoas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getPessoas() {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.listarPessoas();
	}
	
	@GET
	@Path("/todosAuxiliaresHomens")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getListarTodosAuxiliaresHomens() {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.listarTodosAuxiliaresHomens();
	}
	
	@GET
	@Path("/todasAuxiliaresMulheres")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getListarTodasAuxiliaresHomens() {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.listarTodasAuxiliaresMulheres();
	}

	
	@GET
	@Path("/pessoasContinuacaoMasculino")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getPessoasContinuacaoMasculino(@PathParam("numeroContinuacao") int numeroContinuacao) {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.listarPessoasContinuacaoMasculino(numeroContinuacao);
	}
	
	@GET
	@Path("/pessoasContinuacaoFeminino")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getPessoasContinuacaoFeminino(@PathParam("numeroContinuacao") int numeroContinuacao) {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.listarPessoasContinuacaoFeminino(numeroContinuacao);
	}

	@GET
	@Path("/pessoasComPresencaContinuacao")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getPessoasComPresencaDeUmaContinuacao(@PathParam("numeroContinuacao") int numeroContinuacao) {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.listarTodasPessoasComPresencaDeUmaContinuacao(numeroContinuacao);
	}
	
	
	@GET
	@Path("/pessoasComFaltaContinuacao")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> getPessoasComFaltaDeUmaContinuacao(@PathParam("numeroContinuacao") int numeroContinuacao) {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.listarTodasPessoasComFaltaDeUmaContinuacao(numeroContinuacao);
	}
	
	
	@GET
	@Path("/pesquisarPessoa")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa pesquisarPessoa(@PathParam("cdPessoa") int cdPessoa) {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.findPessoa(cdPessoa);
	}
	
	@GET
	@Path("/pesquisarPessoaPorNome")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> pesquisarPessoa(@PathParam("nome") String nomePessoa) {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.findPessoaPorNome(nomePessoa);
	}
	
	
	
	@PUT
	@Path("/alterarPessoa")
	@Produces(MediaType.APPLICATION_JSON)
	public void alterarPessoa(Pessoa pessoa) {
		PessoaBO pessoaBO = new PessoaBO();
		pessoaBO.alterarPessoa(pessoa);
	}
	
	
	@POST
	@Path("/incluirAuxiliar")
	@Produces(MediaType.APPLICATION_JSON)
	public void incluirAuxiliar(Pessoa pessoa, Continuacao continuacao) {
		PessoaBO pessoaBO = new PessoaBO();
		pessoaBO.incluirAuxiliar(pessoa, continuacao);
	}
	
	
	@DELETE
	@Path("/excluirPessoa")
	@Produces(MediaType.APPLICATION_JSON)
	public void excluirPessoa(@PathParam("cdPessoa") int cdPessoa) {
		PessoaBO pessoaBO = new PessoaBO();
		Pessoa pessoa = new Pessoa();
		pessoa.setCdPessoa(cdPessoa);
		pessoaBO.excluirPessoa(pessoa );
	}
	
	
}
