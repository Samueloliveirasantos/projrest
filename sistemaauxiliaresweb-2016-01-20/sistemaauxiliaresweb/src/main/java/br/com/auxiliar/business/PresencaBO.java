package br.com.auxiliar.business;

import java.util.List;

import br.com.auxiliar.bean.Presenca;
import br.com.auxiliar.dao.PresencaDAO;

public class PresencaBO {
	

	public void incluirPresenca(Presenca presenca){
		PresencaDAO presencaDAO = new PresencaDAO();
		presencaDAO.incluirPresenca(presenca);
	}
	
	public void alterarPresenca(Presenca presenca){
		PresencaDAO presencaDAO = new PresencaDAO();
		presencaDAO.alterarPresenca(presenca);
	}
	
	public void excluirPresenca(int cdPresenca){
		PresencaDAO presencaDAO = new PresencaDAO();
		presencaDAO.findPresenca(cdPresenca);
	}
	
	public List<Presenca> listarTodasPresenca(){
		PresencaDAO presencaDAO = new PresencaDAO();
		return presencaDAO.listarPresencas();
	}
	
	public List<Presenca> listarTodasPresencaContinuacao(int cdContinuacao){
		PresencaDAO presencaDAO = new PresencaDAO();
		return presencaDAO.listarPresencasContinuacao(cdContinuacao);
	}
		
}