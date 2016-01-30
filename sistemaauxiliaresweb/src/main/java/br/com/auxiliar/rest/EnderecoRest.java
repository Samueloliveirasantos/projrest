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

import br.com.auxiliar.bean.Endereco;
import br.com.auxiliar.business.EnderecoBO;


@Path("/endereco")
public class EnderecoRest {


	@GET
	@Path("/todosEnderecos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Endereco> getEnderecos() {
		EnderecoBO enderecoBO = new EnderecoBO();
		return enderecoBO.listarEnderecos();
	}
	
	@DELETE
	@Path("/excluirEndereco")
	@Produces(MediaType.APPLICATION_JSON)
	public void excluirEndereco(@PathParam("cdEndereco") int cdEndereco) {
		EnderecoBO enderecoBO = new EnderecoBO();
		enderecoBO.excluirEndereco(cdEndereco);
	}
	
	
	@PUT
	@Path("/alterarEndereco")
	@Produces(MediaType.APPLICATION_JSON)
	public void alterarEndereco(Endereco endereco) {
		EnderecoBO enderecoBO = new EnderecoBO();
		enderecoBO.alterarEndereco(endereco);
	}
	
	
	@POST
	@Path("/incluirEndereco")
	@Produces(MediaType.APPLICATION_JSON)
	public void incluirEndereco(Endereco endereco) {
		EnderecoBO enderecoBO = new EnderecoBO();
		enderecoBO.incluirEndereco(endereco);
	}
	
	
}