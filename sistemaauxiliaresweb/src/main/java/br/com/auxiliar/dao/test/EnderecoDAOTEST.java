package br.com.auxiliar.dao.test;

import br.com.auxiliar.bean.Endereco;
import br.com.auxiliar.dao.EnderecoDAO;

public class EnderecoDAOTEST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		Endereco endereco = new Endereco();
		endereco.setDsRua("Rua Santa Catarina");
		endereco.setNumero(205);
		endereco.setDsBairro("Jd. Rochdalle");
		endereco.setDsCidade("Osasco");
		endereco.setDsEstado("São Paulo");
		endereco.setDsPais("Brasil");
		
		enderecoDAO.incluirEndereco(endereco);
		
		
		
		for (Endereco end : enderecoDAO.listarEnderecos()) {
			
			System.out.println(" LISTA INICIO  ");
			System.out.println(" cdEndereco " + end.getCdEndereco());
			System.out.println(" dsRua " + end.getDsRua());
			System.out.println(" numero " + end.getNumero());
			System.out.println(" dsBairro " + end.getDsBairro());
			System.out.println(" dsCidade " + end.getDsCidade());
			System.out.println(" dsEstado " + end.getDsEstado());
			System.out.println(" dsPais " + end.getDsPais());
			System.out.println(" LISTA FIM ");
			
		
		}
		
		Endereco enderecoAlterar = new Endereco();
		enderecoAlterar.setCdEndereco(11);
		enderecoAlterar.setDsRua("Av. Copacabana");
		enderecoAlterar.setNumero(500);
		enderecoAlterar.setDsBairro("Copacabana");
		enderecoAlterar.setDsCidade("Rio de Janeiro");
		enderecoAlterar.setDsEstado("Rio de Janeiro");
		enderecoAlterar.setDsPais("Brasil");
		
		
		enderecoDAO.alterarEndereco(enderecoAlterar);
		
		Endereco find = enderecoDAO.findEndereco(enderecoAlterar.getCdEndereco());
		if(find != null){
			System.out.println(" ALTERADO");
			System.out.println(" cdEndereco " + find.getCdEndereco());
			System.out.println(" dsRua " + find.getDsRua());
			System.out.println(" numero " + find.getNumero());
			System.out.println(" dsBairro " + find.getDsBairro());
			System.out.println(" dsCidade " + find.getDsCidade());
			System.out.println(" dsEstado " + find.getDsEstado());
			System.out.println(" dsPais " + find.getDsPais());
			
		}
		
		
		

	}

}
