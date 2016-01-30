package br.com.auxiliar.dao.test;

import java.io.File;
import java.util.Date;

import br.com.auxiliar.bean.Continuacao;
import br.com.auxiliar.bean.Endereco;
import br.com.auxiliar.bean.Localidade;
import br.com.auxiliar.bean.Pessoa;
import br.com.auxiliar.bean.TipoPessoa;
import br.com.auxiliar.dao.PessoaDAO;

public class PessoaDAOTEST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		
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
		
		pessoaDAO.incluirPessoa(pessoa);
		
		
		
		for (Pessoa pes : pessoaDAO.listarPessoas()) {
			System.out.println(" Nome " + pes.getNome());
			System.out.println(" cdTipoPessoa " + pes.getCdTpPessoa());
			System.out.println(" numero Continuacao " + pes.getContinuacao().getCdContinuacao());
			System.out.println("arryFoto " + pes.getFoto());
			System.out.println(" Email " + pes.getEmail());
			System.out.println(" Senha " + pes.getSenha());
			System.out.println(" cdEndereco " + pes.getEndereco().getCdEndereco());
			System.out.println(" Telefone 1 " + pes.getTelefone1());
			System.out.println(" Telefone 2  " + pes.getTelefone2());
			System.out.println(" Telefone 3 " + pes.getTelefone3());
			System.out.println(" Nome Responsavel 1 " + pes.getNomeResponsavel1());
			System.out.println(" Nome Responsavel 2 " + pes.getNomeResponsavel2());
			System.out.println(" aniversario " + pes.getAniversario());
			System.out.println(" idade " + pes.getIdade());
			System.out.println(" cdLocalidade " + pes.getLocalidade().getCdLocalidade());
			System.out.println(" Observação " + pes.getObservacao());
			System.out.println(" data criacao " + pes.getDataCriacao());
			System.out.println(" tem whatsApp " + pes.isWhatsapp());
			System.out.println(" tem Facebook " + pes.isFacebook());
		
		}
		
		
		Pessoa pessoaAlterar = new Pessoa(1,TipoPessoa.AUXILIAR.getCode(), continuacao , "Samuel Oliveira Santos" , foto, "samueloliveirajob@hotmail.com" , "2334862222" ,
				endereco, "987882638", "36566921", "984194131", "Nilza Oliveira" , " Edvaldo Batista dos Santos" ,
				22101993,  21, localidade , "TESTE" , new Date(), true, true );
		
		pessoaDAO.alterarPessoa(pessoaAlterar);
		
		Pessoa find = pessoaDAO.findPessoa(pessoaAlterar.getCdPessoa());
		if(find != null){
			System.out.println(" ALTERADO");
			System.out.println(" Nome " + find.getNome());
			System.out.println(" cdTipoPessoa " + find.getCdTpPessoa());
			System.out.println(" numero Continuacao " + find.getContinuacao().getCdContinuacao());
			System.out.println("arryFoto " + find.getFoto());
			System.out.println(" Email " + find.getEmail());
			System.out.println(" Senha " + find.getSenha());
			System.out.println(" cdEndereco " + find.getEndereco().getCdEndereco());
			System.out.println(" Telefone 1 " + find.getTelefone1());
			System.out.println(" Telefone 2  " + find.getTelefone2());
			System.out.println(" Telefone 3 " + find.getTelefone3());
			System.out.println(" Nome Responsavel 1 " + find.getNomeResponsavel1());
			System.out.println(" Nome Responsavel 2 " + find.getNomeResponsavel2());
			System.out.println(" aniversario " + find.getAniversario());
			System.out.println(" idade " + find.getIdade());
			System.out.println(" cdLocalidade " + find.getLocalidade().getCdLocalidade());
			System.out.println(" Observação " + find.getObservacao());
			System.out.println(" data criacao " + find.getDataCriacao());
			System.out.println(" tem whatsApp " + find.isWhatsapp());
			System.out.println(" tem Facebook" + find.isFacebook());
		}
		
		
		
		for (Pessoa pes : pessoaDAO.listarPessoasContinuacao(2, true, false)) {
			System.out.println("******* PESSOAS DA CONTINUACAO 2 Masculino ***********");
			System.out.println(" Nome " + pes.getNome());
			System.out.println(" cdTipoPessoa " + pes.getCdTpPessoa());
			System.out.println(" numero Continuacao " + pes.getContinuacao().getCdContinuacao());
			System.out.println("arryFoto " + pes.getFoto());
			System.out.println(" Email " + pes.getEmail());
			System.out.println(" Senha " + pes.getSenha());
			System.out.println(" cdEndereco " + pes.getEndereco().getCdEndereco());
			System.out.println(" Telefone 1 " + pes.getTelefone1());
			System.out.println(" Telefone 2  " + pes.getTelefone2());
			System.out.println(" Telefone 3 " + pes.getTelefone3());
			System.out.println(" Nome Responsavel 1 " + pes.getNomeResponsavel1());
			System.out.println(" Nome Responsavel 2 " + pes.getNomeResponsavel2());
			System.out.println(" aniversario " + pes.getAniversario());
			System.out.println(" idade " + pes.getIdade());
			System.out.println(" cdLocalidade " + pes.getLocalidade().getCdLocalidade());
			System.out.println(" Observação " + pes.getObservacao());
			System.out.println(" data criacao " + pes.getDataCriacao());
			System.out.println(" tem whatsApp " + pes.isWhatsapp());
			System.out.println(" tem Facebook " + pes.isFacebook());
			System.out.println("******* fim PESSOAS DA CONTINUACAO 2 ***********");
		}
		
		for (Pessoa pes : pessoaDAO.findPessoaPorNome("Samuel")) {
			System.out.println("******* PESSOAS por NOME ***********");
			System.out.println(" Nome " + pes.getNome());
			System.out.println(" cdTipoPessoa " + pes.getCdTpPessoa());
			System.out.println(" numero Continuacao " + pes.getContinuacao().getCdContinuacao());
			System.out.println("arryFoto " + pes.getFoto());
			System.out.println(" Email " + pes.getEmail());
			System.out.println(" Senha " + pes.getSenha());
			System.out.println(" cdEndereco " + pes.getEndereco().getCdEndereco());
			System.out.println(" Telefone 1 " + pes.getTelefone1());
			System.out.println(" Telefone 2  " + pes.getTelefone2());
			System.out.println(" Telefone 3 " + pes.getTelefone3());
			System.out.println(" Nome Responsavel 1 " + pes.getNomeResponsavel1());
			System.out.println(" Nome Responsavel 2 " + pes.getNomeResponsavel2());
			System.out.println(" aniversario " + pes.getAniversario());
			System.out.println(" idade " + pes.getIdade());
			System.out.println(" cdLocalidade " + pes.getLocalidade().getCdLocalidade());
			System.out.println(" Observação " + pes.getObservacao());
			System.out.println(" data criacao " + pes.getDataCriacao());
			System.out.println(" tem whatsApp " + pes.isWhatsapp());
			System.out.println(" tem Facebook " + pes.isFacebook());
			System.out.println("******* fim PESSOAS POR NOME  ***********");
		}
		
		

	}

}
