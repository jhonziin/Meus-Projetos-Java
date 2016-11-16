package br.upis.ltp4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.upis.ltp4.entidades.Transacao;
import br.upis.ltp4.utils.Conexao;

public class TransacaoDAO {

	Connection conexao;
	
	public TransacaoDAO(){
		this.conexao = new Conexao().getConexao();
	}
	
	public void adicionar(Transacao trans){
		String sql = "insert into transacoes(historico, valor, id_usuario)"+
				"values(?,?,?)";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, trans.getHistorico());
			//Date dta = new Date(trans.getDataHistorico().getTime());
			//ps.setDate(2, (java.sql.Date) dta);
			ps.setLong(2, trans.getValor());
			ps.setLong(3, trans.getUsuario().getId());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.err.println("Erro ao gravar: "+ e);
		}		
	}
	
	public Transacao consultarId(long id){
		
		Transacao trans = new Transacao();
		try {
			PreparedStatement ps = conexao.prepareStatement("select * from transacoes where id_transacoes = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();			
			if(rs.next()){
				trans.setId(rs.getLong("id_transacoes"));
				trans.setHistorico(rs.getString("historico"));
				trans.setDataHistorico(rs.getDate("dataHistorico"));
				trans.setValor(rs.getLong("valor"));
				trans.setUsuario( new UsuarioDAO().getUsuarioId(rs.getLong("id_usuario")));				
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			System.err.println("Erro ao consultar Id: "+e);
		}
		return trans;
	}
	public List<Transacao> listarTransacao(){
		List<Transacao> transacoes = new ArrayList<Transacao>();
		String sql = "select u.nome, t.id_transacoes, t.historico, t.valor,t.id_usuario from usuario u inner join"+
				" transacoes t on u.id_usuario = t.id_usuario";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Transacao trans = new Transacao();
				trans.setId(rs.getLong("id_transacoes"));
				trans.setHistorico(rs.getString("historico"));
				//trans.setDataHistorico(rs.getDate("dataHistorico"));
				trans.setValor(rs.getLong("valor"));
				trans.setUsuario( new UsuarioDAO().getUsuarioId(rs.getLong("id_usuario")));
				transacoes.add(trans);
				
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao listar: "+ e);
		}
		return transacoes;
		
	}
	public void alterar(Transacao trans){
		String sql = "update transacoes set historico = ?, valor=?, id_usuario=? where id_transacoes=?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, trans.getHistorico());
			//ps.setDate(2, (java.sql.Date) trans.getDataHistorico());
			ps.setLong(2, trans.getValor());
			ps.setLong(3, trans.getUsuario().getId());
			ps.setLong(4, trans.getId());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			System.err.println("Erro ao alterar a transacao: "+e);
		}		
	}
	public void excluir(long id){
		try {
			PreparedStatement ps = conexao.prepareStatement("delete from transacoes where id_transacoes=?");
			ps.setLong(1,id);
			ps.execute();
			
		} catch (SQLException e) {
			System.err.println("Erro ao excluir a transacao: "+e);
		}
		
	}
	
	
}
