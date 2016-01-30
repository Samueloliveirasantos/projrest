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

import br.com.auxiliar.bean.Localidade;
import br.com.auxiliar.connection.ConexaoFactory;

public class LocalidadeDAO {

	Connection conexao = null;

	/**
	 * metodo responsavel por incluir uma Localidade.
	 * @param localidade
	 */
	public void incluirLocalidade(Localidade localidade){
		PreparedStatement ps = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "INSERT INTO localidade (cd_localidade, ds_localidade, dt_criacao)" +
					" VALUES (nextval('localidade_sq') ,?,?)";
			
			ps = conexao.prepareStatement(sql);
			ps.setString(2, localidade.getDsLocalidade());
			Date data = new Date(Calendar.getInstance().getTime().getTime());
			ps.setDate(3, data);
			
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

	/**
	 * @param cdLocalidade
	 */
	public void excluirLocalidade(int cdLocalidade){
		PreparedStatement ps = null;
		try{
			conexao = ConexaoFactory.conexaoHeroku();
			String sql ="DELETE FROM localidade WHERE cd_localidade = ?";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, cdLocalidade);

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

	/**
	 * @param localidade
	 */
	public void alterarLocalidade(Localidade localidade){
		PreparedStatement ps = null;

		try {
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "UPDATE SET  ds_localidade  = ? " +
					" FROM localidade WHERE cd_localidade = ? ";

			ps = conexao.prepareStatement(sql);
			
			ps.setString(1, localidade.getDsLocalidade());
			ps.setInt(2, localidade.getCdLocalidade());
			
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

	/**
	 * @return
	 */
	public List<Localidade> listarLocalidades(){
		List<Localidade> localidades = new ArrayList<Localidade>();
		Statement smt = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			smt = conexao.createStatement();
			String sql = "SELECT cd_localidade, ds_localidade, dt_criacao  from localidade";

			rs = smt.executeQuery(sql);
			while(rs.next()){
				Localidade localidade = new Localidade();
				localidade.setCdLocalidade(rs.getInt("cd_localidade"));
				localidade.setDsLocalidade(rs.getString("ds_localidade"));
				localidade.setDataCriacao(rs.getDate("dt_criacao"));
				localidades.add(localidade);
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

		return localidades;
	}


	
	/**
	 * @param cdLocalidade
	 * @return
	 */
	public Localidade findLocalidade(int cdLocalidade){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			String sql = "SELECT cd_localidade, ds_localidade, dt_criacao  from localidade "
					+ "where cd_localidade = ? ";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, cdLocalidade);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Localidade localidade = new Localidade();
				localidade.setCdLocalidade(rs.getInt("cd_localidade"));
				localidade.setDsLocalidade(rs.getString("ds_localidade"));
				localidade.setDataCriacao(rs.getDate("dt_criacao"));
				return localidade;
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
