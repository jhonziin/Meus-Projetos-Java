<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.upis.ltp4.entidades.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar</title>
</head>
	<body>
		<% Usuario usuario = (Usuario) session.getAttribute("idUsuario"); %>
		<h1>Alterar Usuario</h1>
		<form action="/ProjetoLTP4/usuario?acao=editar" method="post">
			<table border="2">
				<tr bgcolor="cccccc">
					<td>Nome</td>
					<td>Email</td>
					<td>Telefone</td>
					<td colspan="2">Sexo</td>
					
				</tr>
				 
				<%String M = "" , F = ""; %>
				<%if(usuario.getSexo()=='m'){					
					M = "checked";
				}else{
					F = "checked";
				}
					%>
				
				<tr>
					<input type="hidden" name="id" value="<%=usuario.getId() %>">
					<td><input type="text" name="nome" value="<%=usuario.getNome() %>"></td>
					<td><input type="text" name="email" value="<%=usuario.getEmail() %>"></td>
					<td><input type="text" name="telefone" value="<%=usuario.getTelefone()%>"></td>
					<td>
						<input type="radio" name="sexo" value="masculino" <%=M%>>Masculino<br/>
 						<input type="radio" name="sexo" value="feminino" <%=F%> >Feminino<br/>
					</td>
					<td><input type="submit" value="alterar"></td>
				</tr>
				
				
			</table>
			<a href="usuario?acao=listar">voltar</a>
		</form>
	</body>
</html>