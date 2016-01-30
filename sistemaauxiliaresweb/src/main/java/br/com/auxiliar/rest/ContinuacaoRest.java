package br.com.auxiliar.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.auxiliar.bean.Continuacao;
import br.com.auxiliar.business.ContinuacaoBO;


@Path("/continuacao")
public class ContinuacaoRest {


	@GET
	@Path("/todasContinuacoes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Continuacao> getContinuaoes() {
		ContinuacaoBO continuacaoBO = new ContinuacaoBO();
		return continuacaoBO.listarTodasContinuacoes();
	}
	
	@GET
	@Path("/todasContinuacoesFeminino")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Continuacao> getTodasContinuacoesFeminino(@PathParam("numeroContinuacao") int numeroContinuacao) {
		ContinuacaoBO continuacaoBO = new ContinuacaoBO();
		return continuacaoBO.listaTodasContinuacoesFeminino(numeroContinuacao);
	}
	
	
	@GET
	@Path("/todasContinuacoesMasculino")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Continuacao> getTodasContinuacoesMasculino(@PathParam("numeroContinuacao") int numeroContinuacao) {
		ContinuacaoBO continuacaoBO = new ContinuacaoBO();
		return continuacaoBO.listaTodasContinuacoesMasculino(numeroContinuacao);
	}
	
	
	@GET
	@Path("/pesquisarContinuacaoMasculino")
	@Produces(MediaType.APPLICATION_JSON)
	public Continuacao pesquisarContinuacaoMasculino(@PathParam("numeroContinuacao") int numeroContinuacao) {
		ContinuacaoBO continuacaoBO = new ContinuacaoBO();
		return continuacaoBO.pesquisarContinuacaoMasculino(numeroContinuacao);
	}
	
	@GET
	@Path("/pesquisarContinuacaoFeminino")
	@Produces(MediaType.APPLICATION_JSON)
	public Continuacao pesquisarContinuacaoFeminino(@PathParam("numeroContinuacao") int numeroContinuacao) {
		ContinuacaoBO continuacaoBO = new ContinuacaoBO();
		return continuacaoBO.pesquisarContinuacaoFeminino(numeroContinuacao);
	}
	
	
	@PUT
	@Path("/alterarContinuacao")
	@Produces(MediaType.APPLICATION_JSON)
	public void alterarContinuacao(Continuacao continuacao) {
		ContinuacaoBO continuacaoBO = new ContinuacaoBO();
		continuacaoBO.alterarContinuacao(continuacao);
	}
	
	@DELETE
	@Path("/excluirContinuacao")
	@Produces(MediaType.APPLICATION_JSON)
	public void excluirContinuacao(@PathParam("numeroContinuacao") int numeroContinuacao) {
		Continuacao continuacao = new Continuacao();
		continuacao.setCdContinuacao(numeroContinuacao);
		ContinuacaoBO continuacaoBO = new ContinuacaoBO();
		continuacaoBO.excluirContinuacao(continuacao);
	}
	
	
}