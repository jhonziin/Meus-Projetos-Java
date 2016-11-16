package br.upis.ltp4.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.upis.ltp4.bo.UsuarioBO;
import br.upis.ltp4.entidades.Usuario;

public class UsuarioServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	private static final String ACAO_INSERIR = "inserir";

	private static final String ACAO_LISTAR = "listar";

	private static final String ACAO_ALTERAR = "alterar";

	private static final String ACAO_EXCLUIR = "excluir";
	private static final String ACAO_EDITAR = "editar";
	private String acao;
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		acao = req.getParameter("acao");
		if(acao.equals(ACAO_LISTAR)){
			
			List<Usuario> usuarios = new UsuarioBO().pegaUsuarios();
			session.setAttribute("usuarios", usuarios);
			req.getRequestDispatcher("usuarios/listar.jsp").forward(req, resp);
		}else if(acao.equals(ACAO_INSERIR)){
			Usuario usuario = new Usuario();
			usuario.setNome(req.getParameter("nome"));
			usuario.setEmail(req.getParameter("email"));
			usuario.setTelefone(req.getParameter("telefone"));
			usuario.setSexo(req.getParameter("sexo").charAt(0));
			
			UsuarioBO bo = new UsuarioBO();
			bo.adicionar(usuario);
			resp.sendRedirect("usuario?acao=listar");
		}else if(acao.equals(ACAO_ALTERAR)){

			
			String id = req.getParameter("id");
			
			Usuario usuario = (Usuario) new UsuarioBO().pegarIdUsuario(Long.parseLong((id)));			
	
			session.setAttribute("idUsuario", usuario);
			req.getRequestDispatcher("usuarios/editar.jsp").forward(req, resp);
			
		}else if(acao.equals(ACAO_EDITAR)){
			
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(req.getParameter("id")));
			usuario.setNome(req.getParameter("nome"));
			usuario.setEmail(req.getParameter("email"));
			usuario.setSexo(req.getParameter("sexo").charAt(0));
			usuario.setTelefone(req.getParameter("telefone"));
			UsuarioBO bo = new UsuarioBO();
			bo.alterar(usuario);
			resp.sendRedirect("usuario?acao=listar");
		}else if(acao.equals(ACAO_EXCLUIR)){
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(req.getParameter("id")));
			UsuarioBO bo = new UsuarioBO();
			bo.excluir(usuario);
			resp.sendRedirect("usuario?acao=listar");
		}
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
}
