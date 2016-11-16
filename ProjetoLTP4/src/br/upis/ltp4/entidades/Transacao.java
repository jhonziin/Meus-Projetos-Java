package br.upis.ltp4.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transacao {
	long id;
	String historico;
	Date dataHistorico;
	long valor;
	Usuario usuario;
	
	public Transacao(){
		this.usuario = new Usuario();
	}

	
	public Date getDataHistorico() {
		return dataHistorico;
	}


	public void setDataHistorico(Date dataHistorico) {
		this.dataHistorico = dataHistorico;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setDtaNasc(Date data) {
		// TODO Auto-generated method stub
		
	}
	
	
}
