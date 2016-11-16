<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
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
	<div class="container">
		<h1 class="page-header">Cadastro</h1>
	</div>
 <form action="/ProjetoLTP4/usuario" method="post" class="form-horizontal">
 	<input type="hidden" name="acao" value="inserir">
 	<div class="form-group">
 		<label class="col-sm-2 control-label">Nome:</label>
 		<input class="form-control" type="text" name="nome" placeholder="Digite seu nome">
 	</div>
 	<div class="form-group">
 		<label class="col-sm-2 control-label">Email:</label>
 		<input class="form-control" type="text" name="email" placeholder="Digite seu email">
 	</div>
 	<div class="form-group">
 		<label class="col-sm-2 control-label">Telefone:</label>
 		<input class="form-control" type="text" name="telefone" placeholder="Digite seu telefone">
 	</div>
 	<div class="form-group">
	 	<label class="col-sm-2 control-label">Sexo:</label>
	 	<div class="radio-inline">
		  <label>
		    <input type="radio" name="sexo" value="masculino" checked>
		    Masculino
		  </label>
		 </div>
		 <div class="radio-inline"> 
		  <label>
		  	<input type="radio" name="sexo" value="feminino">
		  	Feminino
		  </label>
		</div>
 	</div>
 	<div class="form-group col-sm-2 control-label">
 		<button class="btn btn-default" type="submit">Salvar</button>
 		<button class="btn btn-default"><a href="../usuario?acao=listar">voltar</a></button>
 	</div>
 	
 	
 </form>
</body>
</html>