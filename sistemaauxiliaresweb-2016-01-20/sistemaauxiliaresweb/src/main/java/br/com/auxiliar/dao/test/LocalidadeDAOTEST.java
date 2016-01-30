package br.com.auxiliar.dao.test;

import java.util.Date;

import br.com.auxiliar.bean.Localidade;
import br.com.auxiliar.dao.LocalidadeDAO;

public class LocalidadeDAOTEST {

	
	
	public static void main(String[] args) {
		LocalidadeDAO localidadeDAO = new LocalidadeDAO();
		
		Localidade localidade = new Localidade();
		localidade.setCdLocalidade(1);
		localidade.setDataCriacao(new Date());
		localidade.setDsLocalidade("Jd. Roch");
		localidadeDAO.incluirLocalidade(localidade);
		
		for (Localidade cont : localidadeDAO.listarLocalidades()) {
			System.out.println(" Codigo: " + cont.getCdLocalidade());
			System.out.println(" Localidade: " + cont.getDsLocalidade());
			System.out.println(" Data Criação: " + cont.getDataCriacao());
		}
		
		Localidade alterar = new Localidade();
		alterar.setDsLocalidade("Jd. Rochdalle");
		
		localidadeDAO.alterarLocalidade(alterar);
		
		if(localidadeDAO.findLocalidade(0) != null){ 
			Localidade find = localidadeDAO.findLocalidade(0);
			System.out.println("********** ALTERAÇÃO **********");
			System.out.println(" Codigo: " + find.getCdLocalidade());
			System.out.println(" Localidade: " + find.getDsLocalidade());
			System.out.println(" Data Criação: " + find.getDataCriacao());
			System.out.println("********** FIM ALTERAÇÃO **********");
		}
		
		
	}
	

	

}
