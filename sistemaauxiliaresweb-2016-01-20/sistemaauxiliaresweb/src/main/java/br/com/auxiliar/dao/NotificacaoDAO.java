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

import br.com.auxiliar.bean.Notificacao;
import br.com.auxiliar.bean.Pessoa;
import br.com.auxiliar.connection.ConexaoFactory;

public class NotificacaoDAO {

	Connection conexao = null;

	/**
	 * metodo responsavel por incluir uma Notificacao.
	 * @param notificacao
	 */
	public void incluirNotificacao(Notificacao notificacao){
		PreparedStatement ps = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "INSERT INTO notificacao (cd_notificacao, cd_pessoa_remetente, cd_pessoa_destinataria, isLida, descricao, date_criacao )" +
					" VALUES (nextval('notificacao_sq') ,?,?,?,?)";
			
			ps = conexao.prepareStatement(sql);
			ps.setInt(2, notificacao.getPessoaRemetente().getCdPessoa());
			ps.setInt(3, notificacao.getPessoaDestinataria().getCdPessoa());
			ps.setBoolean(4, notificacao.isLida());
			Date data = new Date(Calendar.getInstance().getTime().getTime());
			ps.setString(5, notificacao.getDescricao());
			ps.setDate(6, data);
			
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

	public void excluirNotificacao(int cdNotificacao){
		PreparedStatement ps = null;
		//obtem a conexão
		try{
			conexao = ConexaoFactory.conexaoHeroku();
			String sql ="DELETE FROM notificacao WHERE cd_notificacao = ?";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, cdNotificacao);

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

	public void alterarNotificacao(Notificacao notificacao){
		PreparedStatement ps = null;

		try {
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "UPDATE SET  islida  = ? " +
					" FROM notificacao WHERE cd_notificacao = ? ";

			ps = conexao.prepareStatement(sql);
			
			ps.setBoolean(1, notificacao.isLida());
			ps.setInt(2, notificacao.getCdNotificacao());
			
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

	public List<Notificacao> listarNotificacaos(){
		List<Notificacao> notificacoes = new ArrayList<Notificacao>();
		Statement smt = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			smt = conexao.createStatement();
			String sql = "SELECT cd_notificacao, cd_pessoa_remetente, cd_pessoa_destinataria, islida, descricao, date_criacao  from notificacao";

			rs = smt.executeQuery(sql);
			while(rs.next()){
				Notificacao notificacao = new Notificacao();
				notificacao.setCdNotificacao(rs.getInt("cd_notificacao"));
				Pessoa pessoaRemetente = new Pessoa();
				pessoaRemetente.setCdPessoa(rs.getInt("cd_pessoa_remetente"));
				Pessoa pessoaDestinataria = new Pessoa();
				pessoaDestinataria.setCdPessoa(rs.getInt("cd_pessoa_destinataria"));
				notificacao.setLida(rs.getBoolean("islida"));
				notificacao.setDescricao(rs.getString("descricao"));
				notificacao.setDataCriacao(rs.getDate("date_criacao"));
				notificacoes.add(notificacao);
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

		return notificacoes;
	}


	
	public List<Notificacao> listarNotificacoesRemetente(int cdPessoaRemetente){
		List<Notificacao> notificacoes = new ArrayList<Notificacao>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			String sql = "SELECT cd_notificacao, cd_pessoa_remetente, cd_pessoa_destinataria, islida, descricao, date_criacao  from notificacao "
					+ "where cd_pessoa_remetente = ? ";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, cdPessoaRemetente);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Notificacao notificacao = new Notificacao();
				notificacao.setCdNotificacao(rs.getInt("cd_notificacao"));
				Pessoa pessoaRemetente = new Pessoa();
				pessoaRemetente.setCdPessoa(rs.getInt("cd_pessoa_remetente"));
				Pessoa pessoaDestinataria = new Pessoa();
				pessoaDestinataria.setCdPessoa(rs.getInt("cd_pessoa_destinataria"));
				notificacao.setLida(rs.getBoolean("islida"));
				notificacao.setDescricao(rs.getString("descricao"));
				notificacao.setDataCriacao(rs.getDate("date_criacao"));
				notificacoes.add(notificacao);
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

		return notificacoes;
	}
	
	
	public List<Notificacao> listarNotificacoesRemetenteNLida(int cdPessoaRemetente){
		List<Notificacao> notificacoes = new ArrayList<Notificacao>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			String sql = "SELECT cd_notificacao, cd_pessoa_remetente, cd_pessoa_destinataria, islida, descricao, date_criacao  from notificacao "
					+ "where cd_pessoa_remetente = ? "
					+ "and islida is true";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, cdPessoaRemetente);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Notificacao notificacao = new Notificacao();
				notificacao.setCdNotificacao(rs.getInt("cd_notificacao"));
				Pessoa pessoaRemetente = new Pessoa();
				pessoaRemetente.setCdPessoa(rs.getInt("cd_pessoa_remetente"));
				Pessoa pessoaDestinataria = new Pessoa();
				pessoaDestinataria.setCdPessoa(rs.getInt("cd_pessoa_destinataria"));
				notificacao.setLida(rs.getBoolean("islida"));
				notificacao.setDescricao(rs.getString("descricao"));
				notificacao.setDataCriacao(rs.getDate("date_criacao"));
				notificacoes.add(notificacao);
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

		return notificacoes;
	}

	
	public List<Notificacao> listarNotificacoesDestinatario(int cdPessoaDestinatario){
		List<Notificacao> notificacoes = new ArrayList<Notificacao>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			String sql = "SELECT cd_notificacao, cd_pessoa_remetente, cd_pessoa_destinataria, islida, descricao, date_criacao  from notificacao "
					+ "where cd_pessoa_destinataria = ? ";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, cdPessoaDestinatario);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Notificacao notificacao = new Notificacao();
				notificacao.setCdNotificacao(rs.getInt("cd_notificacao"));
				Pessoa pessoaRemetente = new Pessoa();
				pessoaRemetente.setCdPessoa(rs.getInt("cd_pessoa_remetente"));
				Pessoa pessoaDestinataria = new Pessoa();
				pessoaDestinataria.setCdPessoa(rs.getInt("cd_pessoa_destinataria"));
				notificacao.setLida(rs.getBoolean("islida"));
				notificacao.setDescricao(rs.getString("descricao"));
				notificacao.setDataCriacao(rs.getDate("date_criacao"));
				notificacoes.add(notificacao);
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

		return notificacoes;
	}
	

}
