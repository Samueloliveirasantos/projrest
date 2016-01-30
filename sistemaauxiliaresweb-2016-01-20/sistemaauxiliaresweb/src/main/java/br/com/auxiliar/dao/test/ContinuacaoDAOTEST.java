package br.com.auxiliar.dao.test;

import br.com.auxiliar.bean.Continuacao;
import br.com.auxiliar.bean.Pessoa;
import br.com.auxiliar.dao.ContinuacaoDAO;

public class ContinuacaoDAOTEST {

	
	
	public static void main(String[] args) {
		ContinuacaoDAO continuacaoDAO = new ContinuacaoDAO();
		
		Continuacao continuacao = new Continuacao();
		continuacao.setFeminino(false);
		continuacao.setMasculino(true);
		continuacao.setIntervaloInicio(9);
		continuacao.setIntervaloFim(12);
		continuacao.setNumero(3);
		
		continuacaoDAO.incluirContinuacao(continuacao );
		
		
		
		for (Continuacao cont : continuacaoDAO.listarContinuacoes()) {
			System.out.println(" Invervalo Inicio " + cont.getIntervaloInicio());
			System.out.println(" Invervalo Fim " + cont.getIntervaloFim());
			System.out.println(" Numero Continuacao " + cont.getNumero());
			System.out.println(" Feminino " +  cont.isFeminino());
			System.out.println(" Masculino " +  cont.isMasculino());
		}
		
		
		
		Continuacao alterar = new Continuacao();
		Pessoa pessoa = new Pessoa();
		pessoa.setCdPessoa(0);
		alterar.setPessoa(pessoa );
		alterar.setCdContinuacao(1);
		alterar.setFeminino(false);
		alterar.setMasculino(true);
		alterar.setIntervaloInicio(10);
		alterar.setIntervaloFim(12);
		alterar.setNumero(3);
		
		continuacaoDAO.alterarContinuacao(alterar);
		
		Continuacao find = continuacaoDAO.findContinuacao(alterar.getNumero(), alterar.isMasculino(), alterar.isFeminino());
		if(find != null){
			System.out.println("ALTERAÁ√O");
			System.out.println(" Invervalo Inicio " + find.getIntervaloInicio());
			System.out.println(" Invervalo Fim " + find.getIntervaloFim());
			System.out.println(" Numero Continuacao " + find.getNumero());
			System.out.println(" Feminino " +  find.isFeminino());
			System.out.println(" Masculino " +  find.isMasculino());
			
		}
		
		
		
		
		
	}
	

	

}
