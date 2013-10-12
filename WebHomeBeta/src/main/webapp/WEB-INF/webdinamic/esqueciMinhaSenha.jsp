<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt_BR">
	<head>
		<meta charset="UTF-8" />
		<title>Web Home - Cadastro</title>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/esqueciMinhaSenha.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
	</head>
	<body id="forgotPassword-view">
		<header id="header-site">
			<div class="content">
				<a href="index" title="Web Home"><h1>Web Home</h1></a>
			</div>
		</header>
		<section id="main-forgotPassword">
			<div class="content">
				<h2>Esqueci minha senha</h2>
				<div id="content-form">
					<form:form modelAttribute="usuario" action="enviarEmail" method="POST" id="frmForgotPassword">
						<p>Para solicitar uma nova senha, informe o e-mail cadastrado no sistema para solicitar uma nova senha.</p>
						<div id="warnningMessage">
							<p>Mensagem de erro</p>
						</div>
						<label>Digite seu e-mail</label>
						<input type="text" name="email" />
						<br>
						<label>Digite seu CPF</label>
						<input type="text" name="cpf" />
						<br>
						<input type="submit" value="Enviar" />			
					</form:form>
				</div>
			</div>
		</section>
		<footer id="footer-site">
		</footer>
		
		<script src="<c:url value = "/js/esqueciMinhaSenha.js"/>" type="text/javascript"></script>
	</body>
</html>


<!-- 
	- Validar se usuário tem cadastro - setar em uma variável em caso de erro e em caso de sucesso (ex: sendEmailForgot: true ou false), ai o front
	faz o tratamento com essa variável
	
	- Em caso de sucesso - Enviar um e-mail para o usuário
 -->
