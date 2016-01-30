package br.com.auxiliar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.auxiliar.bean.Endereco;
import br.com.auxiliar.connection.ConexaoFactory;

public class EnderecoDAO {

	Connection conexao = null;

	
	/**
	 * metodo responsavel por incluir uma endereco.
	 * @param endereco
	 */
	public void incluirEndereco(Endereco endereco){
		PreparedStatement ps = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();


			String sql = "INSERT INTO endereco (cd_endereco, ds_rua, ds_bairro, ds_cidade, ds_estado, ds_pais, numero )" +
					" VALUES (nextval('endereco_sq') ,?,?,?,?,?,?)";

			ps = conexao.prepareStatement(sql);
			int index = 1;
			ps.setString(index++, endereco.getDsRua());
			ps.setString(index++, endereco.getDsBairro());
			ps.setString(index++, endereco.getDsCidade());
			ps.setString(index++, endereco.getDsEstado());
			ps.setString(index++, endereco.getDsPais());
			ps.setInt(index++, endereco.getNumero());
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

	public void excluirEndereco(int cdEndereco){
		PreparedStatement ps = null;
		//obtem a conexão
		try{
			conexao = ConexaoFactory.conexaoHeroku();
			// pega a placa do veiculo e exclui
			String sql ="DELETE FROM endereco WHERE cd_endereco = ?";

			ps = conexao.prepareStatement(sql);
			ps.setInt(1, cdEndereco);

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

	public void alterarEndereco(Endereco endereco){
		PreparedStatement ps = null;

		try {
			conexao = ConexaoFactory.conexaoHeroku();

			String sql = "UPDATE endereco SET ds_rua = ? , ds_bairro = ? , ds_cidade = ? , ds_estado = ? , ds_pais = ? , numero = ? " +
					" WHERE cd_endereco = ? ";

			ps = conexao.prepareStatement(sql);
			
			int index = 1;
			ps.setString(index++, endereco.getDsRua());
			ps.setString(index++, endereco.getDsBairro());
			ps.setString(index++, endereco.getDsCidade());
			ps.setString(index++, endereco.getDsEstado());
			ps.setString(index++, endereco.getDsPais());
			ps.setInt(index++, endereco.getNumero());
			ps.setInt(index++, endereco.getCdEndereco());
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

	public List<Endereco> listarEnderecos(){
		List<Endereco> enderecos = new ArrayList<Endereco>();
		Statement smt = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			smt = conexao.createStatement();
			String sql = "SELECT cd_endereco, ds_rua, ds_bairro, ds_cidade, ds_estado, ds_pais, numero from endereco ";

			rs = smt.executeQuery(sql);
			while(rs.next()){
				Endereco endereco = new Endereco();
				endereco.setCdEndereco(rs.getInt("cd_endereco"));
				endereco.setDsRua(rs.getString("ds_rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setDsBairro(rs.getString("ds_bairro"));
				endereco.setDsCidade(rs.getString("ds_cidade"));
				endereco.setDsEstado(rs.getString("ds_estado"));
				endereco.setDsPais(rs.getString("ds_pais"));
				enderecos.add(endereco);
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

		return enderecos;
	}


	public Endereco findEndereco(int cdEndereco){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactory.conexaoHeroku();
			
			String sql = "SELECT cd_endereco, ds_rua, ds_bairro, ds_cidade, ds_estado, ds_pais, numero from endereco where cd_endereco = ? ";
			
			ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, cdEndereco);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Endereco endereco = new Endereco();
				endereco.setCdEndereco(rs.getInt("cd_endereco"));
				endereco.setDsRua(rs.getString("ds_rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setDsBairro(rs.getString("ds_bairro"));
				endereco.setDsCidade(rs.getString("ds_cidade"));
				endereco.setDsEstado(rs.getString("ds_estado"));
				endereco.setDsPais(rs.getString("ds_pais"));
				return endereco;
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
