package br.upis.ltp4.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.upis.ltp4.bo.TransacaoBO;
import br.upis.ltp4.bo.UsuarioBO;
import br.upis.ltp4.entidades.Transacao;
import br.upis.ltp4.entidades.Usuario;

public class TransacaoServlet extends HttpServlet{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ACAO_LISTAR = "listar";
	private static final String ACAO_INSERIR = "inserir";
	private static final String ACAO_ALTERAR = "alterar";
	private static final String ACAO_EDITAR	="editar";
	private static final String ACAO_EXCLUIR = "excluir";
	private String acao;
	
	//@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		acao = req.getParameter("acao");
		List<Usuario> usuarios = new UsuarioBO().pegaUsuarios();
		session.setAttribute("usuarios", usuarios);
		
		if(acao.equals(ACAO_LISTAR)){
			List<Transacao> trans = new TransacaoBO().listarTransacoes();
			session.setAttribute("trans", trans);
			req.getRequestDispatcher("transacao/listar.jsp").forward(req, resp);
		}else if(acao.equals(ACAO_INSERIR)){
			
			Transacao trans = new Transacao();
			
			trans.setHistorico(req.getParameter("historico"));
			trans.setValor(Long.parseLong(req.getParameter("valor")));
			trans.getUsuario().setId(Long.parseLong(req.getParameter("id")));
			TransacaoBO bot = new TransacaoBO();
			bot.adicionar(trans);
			resp.sendRedirect("transacoes?acao=listar");
		}else if(acao.equals(ACAO_ALTERAR)){
			String id = req.getParameter("id");
			Transacao trans = new TransacaoBO().consultarId(Long.parseLong(id));
			session.setAttribute("idTrans", trans);
			req.getRequestDispatcher("transacao/editar.jsp").forward(req, resp);
		}else if(acao.equals(ACAO_EDITAR)){
			Transacao trans = new Transacao();
			trans.setId(Long.parseLong(req.getParameter("id")));
			trans.setHistorico(req.getParameter("historico"));
			trans.setValor(Long.parseLong(req.getParameter("valor")));
			trans.getUsuario().setId(Long.parseLong(req.getParameter("idUsuario")));;
			TransacaoBO bot = new TransacaoBO();
			bot.alterar(trans);
			resp.sendRedirect("transacoes?acao=listar");
		}else if(acao.equals(ACAO_EXCLUIR)){
			Transacao trans = new Transacao();
			trans.setId(Long.parseLong(req.getParameter("id")));
			TransacaoBO bot = new TransacaoBO();
			bot.excluir(trans.getId());
			resp.sendRedirect("transacoes?acao=listar");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
				
	}
}
	