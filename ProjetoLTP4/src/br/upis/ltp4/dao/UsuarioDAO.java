package br.upis.ltp4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upis.ltp4.entidades.Usuario;
import br.upis.ltp4.utils.Conexao;

public class UsuarioDAO {

	Connection conexao;
	
	public UsuarioDAO(){
		this.conexao = new Conexao().getConexao();
	}
	
	public boolean adicionar(Usuario usuario){
		String sql = "insert into usuario(nome, email, telefone, sexo)"+
				"values(?,?,?,?)";
		PreparedStatement ps;
		if(conexao!=null){
			try {
				ps = conexao.prepareStatement(sql);
				
				ps.setString(1, usuario.getNome());
				ps.setString(2, usuario.getEmail());
				ps.setString(3, usuario.getTelefone());
				ps.setString(4, "" + usuario.getSexo());
				
				ps.execute();
			} catch (SQLException e) {
				System.err.println("Erro ao Inserir");
				return false;
			}
			return true;
		}
		return false;		
	}
	public List<Usuario> getUsuarios(){
		try {
		String sql = "select * from usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();		
			PreparedStatement ps = conexao.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setSexo(rs.getString("sexo").charAt(0));
				usuarios.add(usuario);
			}			
			rs.close();
			ps.close();
			return usuarios;
		} catch (SQLException e) {
			System.err.println("Erro: "+ e);
		}
		return null;		
	}
	
	public Usuario getUsuarioId(Long id){
		String sql= "select * from usuario where id_usuario=?";
		Usuario usuario = new Usuario();
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setSexo(rs.getString("sexo").charAt(0));
				
			}			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println("Erro ao pegar o Id do Usuario"+e);
		}
		return usuario;
	}
	public void alterar(Usuario usuario){
		String sql = "update usuario set nome=? , email = ?, telefone = ?,"+
				"sexo=? where id_usuario=?";
		
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getTelefone());
			ps.setString(4, "" + usuario.getSexo());
			ps.setLong(5, usuario.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.err.println("Erro: "+ e);
		}
	}
	public void remorer(Usuario usuario){
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("delete from usuario where id_usuario = ?");
			ps.setLong(1, usuario.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.err.println("Erro: "+ e);
		}
		
	}
	
}
