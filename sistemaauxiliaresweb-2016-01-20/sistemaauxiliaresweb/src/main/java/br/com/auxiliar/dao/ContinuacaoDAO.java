package br.com.auxiliar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.auxiliar.bean.Continuacao;
import br.com.auxiliar.bean.Pessoa;
import br.com.auxiliar.connection.ConexaoFactory;

public class ContinuacaoDAO {

	Connection conexao = null;

	/**
	 * metodo responsavel por incluir uma continuacao.
	 * @param continuacao
	 */
	public void incluirContinuacao(Continuacao continuacao){
		PreparedStatement ps = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "INSERT INTO continuacao (  cd_continuacao, numero, cd_pessoa, ismasculino, isfeminino, intervalo_inicio, intervalo_fim) " +
					" VALUES ( nextval('continuacao_sq') ,?,?,?,?,?,?) ";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, continuacao.getNumero());
		    ps.setInt(2, continuacao.getPessoa() != null ? continuacao.getPessoa().getCdPessoa() : 0);
			ps.setBoolean(3, continuacao.isMasculino());
			ps.setBoolean(4, continuacao.isFeminino());
			ps.setInt(5, continuacao.getIntervaloInicio());
			ps.setInt(6, continuacao.getIntervaloFim());
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

	public void excluirContinuacao(Continuacao continuacao){
		PreparedStatement ps = null;
		//obtem a conexão
		try{
			conexao = ConexaoFactory.conexaoHeroku();
			// pega a placa do veiculo e exclui
			String sql ="DELETE FROM continuacao WHERE numero = ? and ismasculino = ? and isfeminino = ? ";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, continuacao.getCdContinuacao());
			ps.setBoolean(2, continuacao.isMasculino());
			ps.setBoolean(3, continuacao.isFeminino());
			
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

	public void alterarContinuacao(Continuacao continuacao){
		PreparedStatement ps = null;

		try {
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "UPDATE continuacao SET cd_pessoa = ?, intervalo_inicio = ?, intervalo_fim = ? " +
					" WHERE cd_continuacao = ? ";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, continuacao.getPessoa().getCdPessoa());
			ps.setInt(2, continuacao.getIntervaloInicio());
			ps.setInt(3, continuacao.getIntervaloFim());
			ps.setInt(4, continuacao.getCdContinuacao());
			
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

	public List<Continuacao> listarContinuacoes(){
		List<Continuacao> continuacoes = new ArrayList<Continuacao>();
		Statement smt = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			smt = conexao.createStatement();
			String sql = "SELECT  cd_continuacao, numero, cd_pessoa, ismasculino, isfeminino, intervalo_inicio, intervalo_fim from continuacao";

			rs = smt.executeQuery(sql);
			while(rs.next()){
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				continuacao.setNumero(rs.getInt("numero"));
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				continuacao.setPessoa(pessoa);
				continuacao.setMasculino(rs.getBoolean("ismasculino"));
				continuacao.setFeminino(rs.getBoolean("isfeminino"));
				continuacao.setIntervaloInicio(rs.getInt("intervalo_inicio"));
				continuacao.setIntervaloFim(rs.getInt("intervalo_fim"));
				continuacoes.add(continuacao);
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

		return continuacoes;
	}

	
	public Continuacao findContinuacao(int numero, Boolean ismasculino, boolean isfeminino ){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			
			String sql = "SELECT  cd_continuacao, numero, cd_pessoa, ismasculino, isfeminino, intervalo_inicio, intervalo_fim from continuacao " +
					"where numero = ? and ismasculino = ? and isfeminino = ?";
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, numero);
			ps.setBoolean(2, ismasculino);
			ps.setBoolean(3, isfeminino);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				continuacao.setNumero(rs.getInt("numero"));
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				continuacao.setPessoa(pessoa);
				continuacao.setMasculino(rs.getBoolean("ismasculino"));
				continuacao.setFeminino(rs.getBoolean("isfeminino"));
				continuacao.setIntervaloInicio(rs.getInt("intervalo_inicio"));
				continuacao.setIntervaloFim(rs.getInt("intervalo_fim"));
				return continuacao;
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

	
	public List<Continuacao> listaTodasContinuacoes(int numero, boolean isMasculino, boolean isFeminino){
		List<Continuacao> continuacoes = new ArrayList<Continuacao>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			
			String sql = "SELECT  cd_continuacao, numero, cd_pessoa, ismasculino, isfeminino, intervalo_inicio, intervalo_fim from continuacao " +
					"where numero = ? and ismasculino = ? and isfeminino = ?";
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, numero);
			ps.setBoolean(2, isMasculino);
			ps.setBoolean(3, isFeminino);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Continuacao continuacao = new Continuacao();
				continuacao.setCdContinuacao(rs.getInt("cd_continuacao"));
				continuacao.setNumero(rs.getInt("numero"));
				Pessoa pessoa = new Pessoa();
				pessoa.setCdPessoa(rs.getInt("cd_pessoa"));
				continuacao.setPessoa(pessoa);
				continuacao.setMasculino(rs.getBoolean("ismasculino"));
				continuacao.setFeminino(rs.getBoolean("isfeminino"));
				continuacao.setIntervaloInicio(rs.getInt("intervalo_inicio"));
				continuacao.setIntervaloFim(rs.getInt("intervalo_fim"));
				continuacoes.add(continuacao);
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
		return continuacoes;
	}
	
	
	

}
