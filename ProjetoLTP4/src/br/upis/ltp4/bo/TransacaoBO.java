package br.upis.ltp4.bo;

import java.util.List;

import br.upis.ltp4.dao.TransacaoDAO;
import br.upis.ltp4.entidades.Transacao;

public class TransacaoBO {

	TransacaoDAO dao;
	
	public TransacaoBO(){
		this.dao = new TransacaoDAO();
	}
	
	public void adicionar(Transacao trans){
		dao.adicionar(trans);
	}
	
	public List<Transacao> listarTransacoes(){
		return dao.listarTransacao();
	}
	public void alterar(Transacao trans){
		dao.alterar(trans);
	}
	public void excluir(long id){
		dao.excluir(id);
	}
	public Transacao consultarId(long id){
		return dao.consultarId(id);
	}
	
}
