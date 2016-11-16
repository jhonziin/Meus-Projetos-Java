<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="br.upis.ltp4.entidades.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Transações</title>
<link rel="stylesheet" href="${raiz}css/bootstrap.css" />
</head>
<body>
	<% List<Transacao> transacoes = (List) session.getAttribute("trans"); %>
	<div class="container">
	<h1 class="page-header">Transações</h1>
	</div>
	<jsp:include page="../template/menu.jsp"></jsp:include>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<table border="1" class="table table-hover">
			<tr>
				<td>Usuario</td>
				
				<td>Historico</td>
				<td>Valor</td>
				
			</tr>
			<%for(Transacao trans: transacoes){ %>
				<tr>
				<td><%=trans.getUsuario().getNome() %></td>
				<!--  td><%=trans.getDataHistorico() %></td>-->
				<td><%=trans.getHistorico() %></td>
				<td>R$<%=trans.getValor() %></td>
				<td><a href="transacoes?acao=alterar&id=<%=trans.getId()%>">alterar</a></td>
				<td><a href="transacoes?acao=excluir&id=<%=trans.getId()%>">excluir</a></td>
			</tr>			
			<%} %>			
		</table>
		<a class="btn btn-default" href="transacao/cadastro.jsp">Cadastrar Transacao</a>
		<a class="btn btn-default" href="index.jsp">voltar</a>
	</div>
</body>
</html>