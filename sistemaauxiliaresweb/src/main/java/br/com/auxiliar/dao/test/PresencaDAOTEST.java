package br.com.auxiliar.dao.test;

import java.io.File;
import java.util.Date;

import br.com.auxiliar.bean.Continuacao;
import br.com.auxiliar.bean.Endereco;
import br.com.auxiliar.bean.Localidade;
import br.com.auxiliar.bean.Pessoa;
import br.com.auxiliar.bean.Presenca;
import br.com.auxiliar.bean.TipoPessoa;
import br.com.auxiliar.dao.PresencaDAO;

public class PresencaDAOTEST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PresencaDAO presencaDAO = new PresencaDAO();
		
		
		Continuacao continuacao = new Continuacao();
		continuacao.setCdContinuacao(2);
		continuacao.setFeminino(false);
		continuacao.setMasculino(true);
		continuacao.setIntervaloInicio(9);
		continuacao.setIntervaloFim(12);
		continuacao.setNumero(3);
		
		
		
		File file = new File("samuel.jpg");
		byte[] foto = new byte[(int) file.length()];
		
		Localidade localidade = new Localidade();
		localidade.setCdLocalidade(1);
		localidade.setDataCriacao(new Date());
		localidade.setDsLocalidade("Rochdalle");
		
		
		
		
		Endereco endereco = new Endereco();
		endereco.setCdEndereco(3);
		endereco.setDsRua("Rua Santa Catarina");
		endereco.setNumero(205);
		endereco.setDsBairro("Jd. Rochdalle");
		endereco.setDsCidade("Osasco");
		endereco.setDsEstado("São Paulo");
		endereco.setDsPais("Brasil");
		
		
		Pessoa pessoa = new Pessoa(TipoPessoa.COOPERADOR.getCode(), continuacao , "Samuel Oliveira Santos" , foto, "samueloliveirajob@gmail.com" , "S87882638s" ,
				endereco, "987882638", "36566921", "984194131", "Nilza Oliveira" , " Edvaldo Batista dos Santos" ,
				22101993,  21, localidade , "TESTE" , new Date(), true, true );
		
		Presenca presenca = new  Presenca();
		presenca.setCdContinuacao(continuacao.getCdContinuacao());
		presenca.setDataPresenca(new Date());
		presenca.setPessoa(pessoa);
		presenca.setPresenca(true);
		presencaDAO.incluirPresenca(presenca);
		
		
		
		for (Presenca pes : presencaDAO.listarPresencas()) {
			System.out.println(" Nome " + pes.getPessoa().getNome());
			System.out.println(" Numero Continuacao " + pes.getCdContinuacao());
			System.out.println(" Data Presença " + pes.getDataPresenca());
			System.out.println(" Presença " + pes.isPresenca());
		}
		
		
		Presenca presencaAlterar = new  Presenca();
		presencaAlterar.setCdContinuacao(4);
		presencaAlterar.setPresenca(false);
		
		presencaDAO.alterarPresenca(presencaAlterar);
		
		Presenca find = presencaDAO.findPresenca(1);
		if(find != null){
			System.out.println(" ALTERADO");
			System.out.println(" Nome " + find.getPessoa().getNome());
			System.out.println(" Numero Continuacao " + find.getCdContinuacao());
			System.out.println(" Data Presença " + find.getDataPresenca());
		}
		
		
		

	}

}
