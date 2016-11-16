package br.upis.ltp4.bo;

import java.util.List;

import br.upis.ltp4.dao.UsuarioDAO;
import br.upis.ltp4.entidades.Usuario;

public class UsuarioBO {

	UsuarioDAO dao;
	public UsuarioBO(){
		this.dao = new UsuarioDAO();
	}
	
	public void adicionar(Usuario usuario){
		dao.adicionar(usuario);
	}
	public List<Usuario> pegaUsuarios(){
		return dao.getUsuarios();
	}
	public void alterar(Usuario usuario){
		dao.alterar(usuario);
	}
	public void excluir(Usuario usuario){
		dao.remorer(usuario);
	}
	public Usuario pegarIdUsuario(Long id){
		return dao.getUsuarioId(id);
	}
}
