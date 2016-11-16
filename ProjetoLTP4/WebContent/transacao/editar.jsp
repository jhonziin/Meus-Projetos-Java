<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.upis.ltp4.entidades.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Transações</title>
<link rel="stylesheet" href="${raiz}css/bootstrap.css" />
</head>
<style>
	select{
		width:10% !important;
	}
	input{
		width:30% !important;
	}
</style>
<body>
	<div class="container">
		<h1 class="page-header">Editar Transação</h1>
	</div>
	<% Transacao trans = (Transacao) session.getAttribute("idTrans");
		List<Usuario> usuarios = (List) session.getAttribute("usuarios");
	%>
	<form class="form-horizontal" action="transacoes?acao=editar" method="post">
	<input type="hidden" name="id" value="<%=trans.getId()%>">
	  <div class="form-group">
	    <label for="historico" class="col-sm-2 control-label">Historico</label>
	    <div class="col-sm-10">
	      <input type="text" name="historico" class="form-control" id="historico" value="<%=trans.getHistorico()%>">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="valor" class="col-sm-2 control-label">Valor R$</label>
	    <div class="col-sm-10">
	      <input type="number" name="valor" class="form-control" id="valor" value="<%=trans.getValor()%>">
	    </div>
	  </div>
	  <div class="form-group">
	  <
	  <label for="valor" class="col-sm-2 control-label">Usuarios</label>
		  <select name="idUsuario" class="form-control">
		  	<% for(Usuario usu: usuarios){ %>
		  		<option value="<%=usu.getId()%>"><%=usu.getNome() %></option>
		  	<%} %>
		  </select>
		 </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Atualizar</button>
	      <button class="btn btn-default"><a href="transacoes?acao=listar">Voltar</a></button>
	    </div>
	  </div>
	</form>
</body>
</html>