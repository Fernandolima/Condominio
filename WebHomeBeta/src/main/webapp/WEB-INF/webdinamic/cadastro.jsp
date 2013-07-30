<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt_BR">
      
	<head>
	<meta charset="UTF-8" />
		<title>Web Home - Cadastro</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		
		<script src="jquery-1.10.2.min.js" type="text/javascript"></script>
	<head>
	<body id="register-view">
		
			<form:form modelAttribute="usuario" action="cadastro/add" method="post">
				<form:label path="nome">Nome</form:label><form:input path="nome"/>
				<form:label path="login">Login</form:label><form:input path="login"/>
				<form:label path="email">E-mail</form:label><form:input path="email"/>
				<form:label path="senha">Senha</form:label><form:input path="senha"/>
				<form:label path="dt_nascimento">Data de nascimento</form:label><form:input path="dt_nascimento"/>
				<form:label path="cpf">CPF</form:label><form:input path="cpf"/>
				<form:label path="bloco">Bloco</form:label><form:input path="bloco"/>
				<form:label path="apartamento">Apartamento</form:label><form:input path="apartamento"/>
				<button type="submit" id="save">Cadastrar</button>
			</form:form>
			
		
	</body>
</html>
