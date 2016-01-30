package br.com.auxiliar.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.auxiliar.bean.Continuacao;
import br.com.auxiliar.bean.Endereco;
import br.com.auxiliar.bean.Localidade;
import br.com.auxiliar.bean.Pessoa;
import br.com.auxiliar.bean.TipoPessoa;
import br.com.auxiliar.connection.ConexaoFactory;

public class PessoaDAO {

	Connection conexao = null;

	/**
	 * metodo responsavel por incluir uma pessoa.
	 * @param pessoa
	 */
	public void incluirPessoa(Pessoa pessoa){
		PreparedStatement ps = null;
		try {
			
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.incluirEndereco(pessoa.getEndereco());
			
			
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "INSERT INTO pessoa (cd_pessoa, cd_tp_pessoa, cd_continuacao, nome, foto, email, senha, telefone_1, telefone_2,telefone_3," +
					" cd_endereco, nome_responsavel, nome_responsavel_2, aniversario,  observacao, cd_localidade, data, iswhatsapp, isfacebook, idade ) " +
					"VALUES (nextval('pessoa_sq') ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = conexao.prepareStatement(sql);
			int index = 1;
			ps.setInt(index++, pessoa.getCdTpPessoa());
			ps.setInt(index++, pessoa.getContinuacao().getCdContinuacao());
			ps.setString(index++, pessoa.getNome());
			ps.setBytes(index++, pessoa.getFoto());
			ps.setString(index++, pessoa.getEmail());
			ps.setString(index++, pessoa.getSenha());
			ps.setString(index++, pessoa.getTelefone1());
			ps.setString(index++, pessoa.getTelefone2());
			ps.setString(index++, pessoa.getTelefone3());
			ps.setInt(index++, pessoa.getEndereco().getCdEndereco());
			ps.setString(index++, pessoa.getNomeResponsavel1());
			ps.setString(index++, pessoa.getNomeResponsavel2());
			ps.setInt(index++, pessoa.getAniversario());
			ps.setString(index++, pessoa.getObservacao());
			ps.setInt(index++, pessoa.getLocalidade().getCdLocalidade());
			Date data = new Date(Calendar.getInstance().getTime().getTime());
			ps.setDate(index++, data);
			ps.setBoolean(index++, pessoa.isWhatsapp());
			ps.setBoolean(index++, pessoa.isFacebook());
			ps.setInt(index++, pessoa.getIdade());
			
			ps.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	

	}

	public void excluirPessoa(Pessoa pessoa){
		PreparedStatement ps = null;
		try{
			conexao = ConexaoFactory.conexaoHeroku();
			String sql ="DELETE FROM pessoa WHERE cd_pessoa = ?";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, pessoa.getCdPessoa());

			ps.executeUpdate();

		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			try{
				ps.close();
				conexao.close();
			}catch(SQLException exc){
				exc.printStackTrace();
			}

		}
	}

	public void alterarPessoa(Pessoa pessoa){
		PreparedStatement ps = null;

		try {
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "UPDATE pessoa SET cd_continuacao = ?, nome= ?, foto= ?, email= ?, senha= ?, telefone_1 = ?, telefone_2 = ?, telefone_3 = ?, " +
					"nome_responsavel = ?, nome_responsavel_2 = ?, aniversario = ?,  observacao = ?,  iswhatsapp = ?, isfacebook = ?, idade = ? " +
					" WHERE cd_pessoa = ? ";

			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, pessoa.getContinuacao().getCdContinuacao());
			ps.setString(2, pessoa.getNome());
			ps.setBytes(3, pessoa.getFoto());
			ps.setString(4, pessoa.getEmail());
			ps.setString(5, pessoa.getSenha());
			ps.setString(6, pessoa.getTelefone1());
			ps.setString(7, pessoa.getTelefone2());
			ps.setString(8, pessoa.getTelefone3());
			ps.setString(9, pessoa.getNomeResponsavel1());
			ps.setString(10, pessoa.getNomeResponsavel2());
			ps.setInt(11, pessoa.getAniversario());
			ps.setString(12, pessoa.getObservacao());
			ps.setBoolean(13, pessoa.isWhatsapp());
			ps.setBoolean(14, pessoa.isFacebook());
			ps.setInt(15, pessoa.getIdade());
			ps.setInt(16, pessoa.getCdPessoa());
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conexao.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}



	}

	public List<Pessoa> listarPessoas(){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Statement smt = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			smt = conexao.createStatement();
			String sql = "SELECT cd_pessoa, cd_tp_pessoa, cd_continuacao, nome, foto, email, senha, telefone_1, telefone_2, telefone_3," +
					"cd_endereco, nome_responsavel, nome_responsavel_2, aniversario, data, iswhatsapp, isfacebook, idade, cd_localidade, observacao from pessoa";

			rs = smt.executeQuery(sql);
			while(rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoa.setCdTpPessoa(rs.getInt("cd_tp_pessoa"));
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				pessoa.setContinuacao(continuacao );
				pessoa.setNome(rs.getString("nome"));
				pessoa.setFoto(rs.getBytes("foto"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setTelefone1(rs.getString("telefone_1"));
				pessoa.setTelefone2(rs.getString("telefone_2"));
				pessoa.setTelefone3(rs.getString("telefone_3"));
				Endereco endereco = new Endereco();
				endereco.setCdEndereco(rs.getInt("cd_endereco"));
				pessoa.setEndereco(endereco);
				pessoa.setNomeResponsavel1(rs.getString("nome_responsavel"));
				pessoa.setNomeResponsavel2(rs.getString("nome_responsavel_2"));
				pessoa.setAniversario(rs.getInt("aniversario"));
				pessoa.setDataCriacao(rs.getDate("data"));
				pessoa.setWhatsapp(rs.getBoolean("iswhatsapp"));
				pessoa.setFacebook(rs.getBoolean("isfacebook"));
				pessoa.setIdade(rs.getInt("idade"));
				Localidade localidade = new Localidade();
				localidade.setCdLocalidade(rs.getInt("cd_localidade"));
				pessoa.setLocalidade(localidade );
				pessoa.setObservacao(rs.getString("observacao"));
				pessoas.add(pessoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				smt.close();
				conexao.close();
				rs.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}

		return pessoas;
	}
	
	
	
	public List<Pessoa> listarAuxiliares(boolean isMasculino, boolean isFeminino){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			String sql = "SELECT p.cd_pessoa, p.cd_tp_pessoa, p.cd_continuacao, p.nome, p.foto, p.email, p.senha, p.telefone_1, p.telefone_2, p.telefone_3," +
					" p.cd_endereco, p.nome_responsavel, p.nome_responsavel_2, p.aniversario, p.data, p.iswhatsapp, p.isfacebook, p.idade, p.cd_localidade, "
					+ " p.observacao from pessoa p, continuacao c  "
					+ "where p.cd_continuacao = c.cd_continuacao "
					+ "and c.ismasculino = ? "
					+ "and c.isfeminino = ? "
					+ "and p.cd_tp_pessoa = ? ";

			ps = conexao.prepareStatement(sql);
			
			ps.setBoolean(1, isMasculino);
			ps.setBoolean(2, isFeminino);
			ps.setInt(3, TipoPessoa.AUXILIAR.getCode());
			
			rs = ps.executeQuery();
			while(rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoa.setCdTpPessoa(rs.getInt("cd_tp_pessoa"));
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				continuacao.setFeminino(isFeminino);
				continuacao.setMasculino(isMasculino);
				pessoa.setContinuacao(continuacao );
				pessoa.setNome(rs.getString("nome"));
				pessoa.setFoto(rs.getBytes("foto"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setTelefone1(rs.getString("telefone_1"));
				pessoa.setTelefone2(rs.getString("telefone_2"));
				pessoa.setTelefone3(rs.getString("telefone_3"));
				Endereco endereco = new Endereco();
				endereco.setCdEndereco(rs.getInt("cd_endereco"));
				pessoa.setEndereco(endereco);
				pessoa.setNomeResponsavel1(rs.getString("nome_responsavel"));
				pessoa.setNomeResponsavel2(rs.getString("nome_responsavel_2"));
				pessoa.setAniversario(rs.getInt("aniversario"));
				pessoa.setDataCriacao(rs.getDate("data"));
				pessoa.setWhatsapp(rs.getBoolean("iswhatsapp"));
				pessoa.setFacebook(rs.getBoolean("isfacebook"));
				pessoa.setIdade(rs.getInt("idade"));
				Localidade localidade = new Localidade();
				localidade.setCdLocalidade(rs.getInt("cd_localidade"));
				pessoa.setLocalidade(localidade );
				pessoa.setObservacao(rs.getString("observacao"));
				pessoas.add(pessoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conexao.close();
				rs.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}

		return pessoas;
	}
	
	

	public Pessoa findPessoa(int cdPessoa){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			
			String sql = "SELECT cd_pessoa, cd_tp_pessoa, cd_continuacao, nome, foto, email, senha, telefone_1, telefone_2, telefone_3," +
					"cd_endereco, nome_responsavel, nome_responsavel_2, aniversario, data, iswhatsapp, isfacebook, idade, cd_localidade, observacao from pessoa  where cd_pessoa = ?";
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, cdPessoa);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoa.setCdTpPessoa(rs.getInt("cd_tp_pessoa"));
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				pessoa.setContinuacao(continuacao );
				pessoa.setNome(rs.getString("nome"));
				pessoa.setFoto(rs.getBytes("foto"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setTelefone1(rs.getString("telefone_1"));
				pessoa.setTelefone2(rs.getString("telefone_2"));
				pessoa.setTelefone3(rs.getString("telefone_3"));
				Endereco endereco = new Endereco();
				endereco.setCdEndereco(rs.getInt("cd_endereco"));
				pessoa.setEndereco(endereco);
				pessoa.setNomeResponsavel1(rs.getString("nome_responsavel"));
				pessoa.setNomeResponsavel2(rs.getString("nome_responsavel_2"));
				pessoa.setAniversario(rs.getInt("aniversario"));
				pessoa.setDataCriacao(rs.getDate("data"));
				pessoa.setWhatsapp(rs.getBoolean("iswhatsapp"));
				pessoa.setFacebook(rs.getBoolean("isfacebook"));
				pessoa.setCdTpPessoa(rs.getInt("idade"));
				Localidade localidade = new Localidade();
				localidade.setCdLocalidade(rs.getInt("cd_localidade"));
				pessoa.setLocalidade(localidade );
				pessoa.setObservacao(rs.getString("observacao"));
				return pessoa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conexao.close();
				rs.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return null;
	}

	public List<Pessoa> listarPessoasContinuacao(int numeroContinuacao, boolean isMasculino, boolean isFeminino) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			
			String sql = "SELECT p.cd_pessoa, p.cd_tp_pessoa, p.cd_continuacao, p.nome, p.foto, p.email, p.senha, p.telefone_1, p.telefone_2, p.telefone_3," +
					" p.cd_endereco, p.nome_responsavel, p.nome_responsavel_2, p.aniversario, p.data, p.iswhatsapp, p.isfacebook, p.idade, p.cd_localidade, "
					+ " p.observacao from pessoa p, continuacao c "
					+ "where p.cd_continuacao = c.cd_continuacao "
					+ "and c.numero = ? "
					+ "and c.ismasculino = ? "
					+ "and c.isfeminino = ? "
					+ "and p.cd_tp_pessoa = ? ";
			
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, numeroContinuacao);
			ps.setBoolean(2, isMasculino);
			ps.setBoolean(3, isFeminino);
			ps.setInt(4, TipoPessoa.JOVEM.getCode());
			
			rs = ps.executeQuery();
			while(rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoa.setCdTpPessoa(rs.getInt("cd_tp_pessoa"));
				Continuacao continuacao = new Continuacao();
				continuacao.setFeminino(isFeminino);
				continuacao.setMasculino(isMasculino);
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				pessoa.setContinuacao(continuacao );
				pessoa.setNome(rs.getString("nome"));
				pessoa.setFoto(rs.getBytes("foto"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setTelefone1(rs.getString("telefone_1"));
				pessoa.setTelefone2(rs.getString("telefone_2"));
				pessoa.setTelefone3(rs.getString("telefone_3"));
				Endereco endereco = new Endereco();
				endereco.setCdEndereco(rs.getInt("cd_endereco"));
				pessoa.setEndereco(endereco);
				pessoa.setNomeResponsavel1(rs.getString("nome_responsavel"));
				pessoa.setNomeResponsavel2(rs.getString("nome_responsavel_2"));
				pessoa.setAniversario(rs.getInt("aniversario"));
				pessoa.setDataCriacao(rs.getDate("data"));
				pessoa.setWhatsapp(rs.getBoolean("iswhatsapp"));
				pessoa.setFacebook(rs.getBoolean("isfacebook"));
				pessoa.setCdTpPessoa(rs.getInt("idade"));
				Localidade localidade = new Localidade();
				localidade.setCdLocalidade(rs.getInt("cd_localidade"));
				pessoa.setLocalidade(localidade );
				pessoa.setObservacao(rs.getString("observacao"));
				pessoas.add(pessoa);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conexao.close();
				rs.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}

		return pessoas;
	}

	public List<Pessoa> findPessoaPorNome(String nomePessoa) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			
			String sql = "SELECT cd_pessoa, cd_tp_pessoa, cd_continuacao, nome, foto, email, senha, telefone_1, telefone_2, telefone_3," +
					"cd_endereco, nome_responsavel, nome_responsavel_2, aniversario, data, iswhatsapp, isfacebook, idade, cd_localidade, "
					+ "observacao from pessoa  where cd_pessoa like  '%?%' ";
			ps = conexao.prepareStatement(sql);
			
			ps.setString(1, nomePessoa);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoa.setCdTpPessoa(rs.getInt("cd_tp_pessoa"));
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				pessoa.setContinuacao(continuacao );
				pessoa.setNome(rs.getString("nome"));
				pessoa.setFoto(rs.getBytes("foto"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setTelefone1(rs.getString("telefone_1"));
				pessoa.setTelefone2(rs.getString("telefone_2"));
				pessoa.setTelefone3(rs.getString("telefone_3"));
				Endereco endereco = new Endereco();
				endereco.setCdEndereco(rs.getInt("cd_endereco"));
				pessoa.setEndereco(endereco);
				pessoa.setNomeResponsavel1(rs.getString("nome_responsavel"));
				pessoa.setNomeResponsavel2(rs.getString("nome_responsavel_2"));
				pessoa.setAniversario(rs.getInt("aniversario"));
				pessoa.setDataCriacao(rs.getDate("data"));
				pessoa.setWhatsapp(rs.getBoolean("iswhatsapp"));
				pessoa.setFacebook(rs.getBoolean("isfacebook"));
				pessoa.setCdTpPessoa(rs.getInt("idade"));
				Localidade localidade = new Localidade();
				localidade.setCdLocalidade(rs.getInt("cd_localidade"));
				pessoa.setLocalidade(localidade );
				pessoa.setObservacao(rs.getString("observacao"));
				pessoas.add(pessoa);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conexao.close();
				rs.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}

		return pessoas;
	}

	public List<Pessoa> listarTodasPessoasComPresencaDeUmaContinuacao(int numeroContinuacao) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			
			String sql = "SELECT p.cd_pessoa, p.cd_tp_pessoa, p.cd_continuacao, p.nome, p.foto, p.email, p.senha, p.telefone_1, p.telefone_2, p.telefone_3," +
					" p.cd_endereco, p.nome_responsavel, p.nome_responsavel_2, p.aniversario, p.data, p.iswhatsapp, p.isfacebook, p.idade, p.cd_localidade, "
					+ " p.observacao from pessoa p, presenca pe, continuacao c "
					+ "where p.cd_continuacao = c.cd_continuacao "
					+ "and p.cd_pessoa = pe.cd_pessoa "
					+ "and pe.cd_continuacao = c.cd_continuacao "
					+ "and c.numero = ? "
					+ "and pe.ispresenca = true "
					+ "and p.cd_tp_pessoa = ? ";
			
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, numeroContinuacao);
			ps.setInt(2, TipoPessoa.JOVEM.getCode());
			
			rs = ps.executeQuery();
			while(rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoa.setCdTpPessoa(rs.getInt("cd_tp_pessoa"));
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				pessoa.setContinuacao(continuacao );
				pessoa.setNome(rs.getString("nome"));
				pessoa.setFoto(rs.getBytes("foto"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setTelefone1(rs.getString("telefone_1"));
				pessoa.setTelefone2(rs.getString("telefone_2"));
				pessoa.setTelefone3(rs.getString("telefone_3"));
				Endereco endereco = new Endereco();
				endereco.setCdEndereco(rs.getInt("cd_endereco"));
				pessoa.setEndereco(endereco);
				pessoa.setNomeResponsavel1(rs.getString("nome_responsavel"));
				pessoa.setNomeResponsavel2(rs.getString("nome_responsavel_2"));
				pessoa.setAniversario(rs.getInt("aniversario"));
				pessoa.setDataCriacao(rs.getDate("data"));
				pessoa.setWhatsapp(rs.getBoolean("iswhatsapp"));
				pessoa.setFacebook(rs.getBoolean("isfacebook"));
				pessoa.setCdTpPessoa(rs.getInt("idade"));
				Localidade localidade = new Localidade();
				localidade.setCdLocalidade(rs.getInt("cd_localidade"));
				pessoa.setLocalidade(localidade );
				pessoa.setObservacao(rs.getString("observacao"));
				pessoas.add(pessoa);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conexao.close();
				rs.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}

		return pessoas;
	}
		
	
	public List<Pessoa> listarTodasPessoasComFaltaDeUmaContinuacao(int numeroContinuacao) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			
			String sql = "SELECT p.cd_pessoa, p.cd_tp_pessoa, p.cd_continuacao, p.nome, p.foto, p.email, p.senha, p.telefone_1, p.telefone_2, p.telefone_3," +
					" p.cd_endereco, p.nome_responsavel, p.nome_responsavel_2, p.aniversario, p.data, p.iswhatsapp, p.isfacebook, p.idade, p.cd_localidade, "
					+ " p.observacao from pessoa p, presenca pe, continuacao c "
					+ "where p.cd_continuacao = c.cd_continuacao "
					+ "and p.cd_pessoa = pe.cd_pessoa "
					+ "and pe.cd_continuacao = c.cd_continuacao "
					+ "and c.numero = ? "
					+ "and pe.ispresenca = false "
					+ "and p.cd_tp_pessoa = ? ";
			
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, numeroContinuacao);
			ps.setInt(2, TipoPessoa.JOVEM.getCode());
			
			rs = ps.executeQuery();
			while(rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoa.setCdTpPessoa(rs.getInt("cd_tp_pessoa"));
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				pessoa.setContinuacao(continuacao );
				pessoa.setNome(rs.getString("nome"));
				pessoa.setFoto(rs.getBytes("foto"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setTelefone1(rs.getString("telefone_1"));
				pessoa.setTelefone2(rs.getString("telefone_2"));
				pessoa.setTelefone3(rs.getString("telefone_3"));
				Endereco endereco = new Endereco();
				endereco.setCdEndereco(rs.getInt("cd_endereco"));
				pessoa.setEndereco(endereco);
				pessoa.setNomeResponsavel1(rs.getString("nome_responsavel"));
				pessoa.setNomeResponsavel2(rs.getString("nome_responsavel_2"));
				pessoa.setAniversario(rs.getInt("aniversario"));
				pessoa.setDataCriacao(rs.getDate("data"));
				pessoa.setWhatsapp(rs.getBoolean("iswhatsapp"));
				pessoa.setFacebook(rs.getBoolean("isfacebook"));
				pessoa.setCdTpPessoa(rs.getInt("idade"));
				Localidade localidade = new Localidade();
				localidade.setCdLocalidade(rs.getInt("cd_localidade"));
				pessoa.setLocalidade(localidade );
				pessoa.setObservacao(rs.getString("observacao"));
				pessoas.add(pessoa);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conexao.close();
				rs.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}

		return pessoas;
	}


}
