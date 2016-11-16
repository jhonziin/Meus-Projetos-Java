<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.upis.ltp4.entidades.*, java.util.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Transação</title>
<link rel="stylesheet" href="../css/bootstrap.css" />
<style>
	select{
		width:10% !important;
	}
	input{
		width:30% !important;
	}
</style>
</head>
	<body>
	<% List<Usuario> usuarios = (List) session.getAttribute("usuarios"); %>
	<div class="container">
		<h1 class="page-header">Cadastrar Transação</h1>
	</div>
		<form class="form-horizontal" action="/ProjetoLTP4/transacoes" method="post">
			<input type="hidden" name="acao" value="inserir">
			<div class="form-group">
				<label class="col-sm-2 control-label">Histórico: </label>
				<input class="form-control" type="text" name="historico">
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Valor: R$</label>
				<input class="form-control" type="number" name="valor">
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Usuario</label>
				<select name="id" class="form-control">
					<% for(Usuario user: usuarios){ %>
					<option value="<%=user.getId()%>"><%=user.getNome()%></option>
					<%} %>
				</select>
			</div>
			<div class="form-group col-sm-2 control-label">
				<button type="submit" class="btn btn-default">Salvar</button>
				<a class="btn btn-default" href="../transacoes?acao=listar">voltar</a>
			</div>
		</form>
	</body>
</html>