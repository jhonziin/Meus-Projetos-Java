<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, br.upis.ltp4.entidades.*, javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
<link rel="stylesheet" href="${raiz}css/bootstrap.css" />
<script>
	function confirma(id){
		if(window.confirm("Tem certeza da exclusao?")){
			location.href="usuario?acao=excluir&id="+id;
		}
	}
</script>
</head>
	<body>
		<%! List<Usuario> usuarios;%>
		<%! HttpSession session; %>
		<% usuarios = (List) session.getAttribute("usuarios"); %>
		<div class="container">
			<h1 class="page-header">Lista de Usuarios</h1>
		</div>
		<jsp:include page="../template/menu.jsp"></jsp:include>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<table border="1" class="table table-hover">
				<tr bgcolor="cccccc">
					<td>Nome</td>
					<td>Email</td>
					<td>Telefone</td>
					<td>Sexo</td>
					
				</tr>
				<% for (Usuario usuario : usuarios){
					%>
					<tr>
						<td><%= usuario.getNome() %></td>
						<td><%= usuario.getEmail() %></td>
						<td><%= usuario.getTelefone() %></td>
						<td><%= usuario.getSexo() %></td>
						<td><a href="usuario?acao=alterar&id=<%=usuario.getId() %>">Alterar</a></td>
						<td><a href="javascript:confirma(<%=usuario.getId()%>)">Excluir</a></td>
					</tr>
				<%	
			   		}
				%>
			</table>
			<a class="btn btn-default" href="usuarios/cadastro.jsp">Cadastrar</a>
			<a class="btn btn-default" href="index.jsp">voltar</a>
		</div>
	</body>
</html>