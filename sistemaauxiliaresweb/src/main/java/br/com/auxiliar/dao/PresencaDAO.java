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
import br.com.auxiliar.bean.Pessoa;
import br.com.auxiliar.bean.Presenca;
import br.com.auxiliar.connection.ConexaoFactory;

public class PresencaDAO {

	Connection conexao = null;

	/**
	 * metodo responsavel por incluir uma Presenca.
	 * @param presenca
	 */
	public void incluirPresenca(Presenca presenca){
		PreparedStatement ps = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "INSERT INTO presenca (cd_presenca, cd_pessoa, cd_continuacao, data, ispresenca )" +
					" VALUES (nextval('presenca_sq') ,?,?,?,?)";

			ps = conexao.prepareStatement(sql);
			ps.setInt(2, presenca.getPessoa().getCdPessoa());
			ps.setInt(3, presenca.getPessoa().getContinuacao().getCdContinuacao());
			Date data = new Date(Calendar.getInstance().getTime().getTime());
			ps.setDate(4, data);
			ps.setBoolean(5, presenca.isPresenca());
			
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

	public void excluirPresenca(int cdPresenca){
		PreparedStatement ps = null;
		//obtem a conexão
		try{
			conexao = ConexaoFactory.conexaoHeroku();
			String sql ="DELETE FROM presenca WHERE cd_presenca = ?";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, cdPresenca);

			ps.executeUpdate();

		}catch(SQLException ex){// trata a exception
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

	public void alterarPresenca(Presenca presenca){
		PreparedStatement ps = null;

		try {
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "UPDATE SET  cd_pessoa = ?, cd_continuacao = ?, ispresenca  = ? " +
					" FROM presenca WHERE cd_presenca = ? ";

			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, presenca.getPessoa().getCdPessoa());
			ps.setInt(2, presenca.getPessoa().getContinuacao().getCdContinuacao());
			ps.setBoolean(3, presenca.isPresenca());
			ps.setInt(4, presenca.getCdPresenca());
			
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

	public List<Presenca> listarPresencas(){
		List<Presenca> pessoas = new ArrayList<Presenca>();
		Statement smt = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			smt = conexao.createStatement();
			String sql = "SELECT cd_presenca, cd_pessoa, cd_continuacao, data, ispresenca from presenca";

			rs = smt.executeQuery(sql);
			while(rs.next()){
				Presenca presenca = new Presenca();
				presenca.setCdPresenca(rs.getInt("cd_presenca"));
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				pessoa.setContinuacao(continuacao);
				presenca.setPessoa(pessoa);
				presenca.setDataPresenca(rs.getDate("data"));
				presenca.setPresenca(rs.getBoolean("ispresenca"));
				pessoas.add(presenca);
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

	
	public List<Presenca> listarPresencasContinuacao(int cdContinuacao){
		List<Presenca> presencas = new ArrayList<Presenca>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			
			String sql = "SELECT cd_presenca, cd_pessoa, cd_continuacao, data, ispresenca from presenca "
					   + " where cd_continuacao = ?";
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, cdContinuacao);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Presenca presenca = new Presenca();
				presenca.setCdPresenca(rs.getInt("cd_presenca"));
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				pessoa.setContinuacao(continuacao);
				presenca.setPessoa(pessoa);
				presenca.setDataPresenca(rs.getDate("data"));
				presenca.setPresenca(rs.getBoolean("ispresenca"));
				presencas.add(presenca);
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

		return presencas;
	}


	public Presenca findPresenca(int cdPresenca){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			
			String sql = "SELECT cd_presenca, cd_pessoa, cd_continuacao, data, ispresenca from presenca where cd_presenca = ?";
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, cdPresenca);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Presenca presenca = new Presenca();
				presenca.setCdPresenca(rs.getInt("cd_presenca"));
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				pessoa.setContinuacao(continuacao);
				presenca.setPessoa(pessoa);
				presenca.setDataPresenca(rs.getDate("data"));
				presenca.setPresenca(rs.getBoolean("ispresenca"));
				return presenca;
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
	
	

}
