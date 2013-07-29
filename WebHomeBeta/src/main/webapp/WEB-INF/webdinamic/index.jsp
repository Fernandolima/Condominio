<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt_BR">
	<head>
		<meta charset="UTF-8" />
		<title>Web Home - Login</title>
		<link href="<c:url value = "http://fonts.googleapis.com/css?family=Chela+One"/>" rel='stylesheet' type='text/css'/>
		<link rel="shortcut icon" href="<c:url value = "/WEB-INF/webstatic/img/favicon.jpg"/>" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="<c:url value = "/webstatic/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/webstatic/css/login.css"/>"/>
		
		<script src="/WEB-INF/webstatic/js/jquery-1.10.2.min.js" type="text/javascript"></script>
	</head>
	<body id="login-view">
		<section id="login">
			<h1>Web Home</h1>
			<div id="warnningMessage"></div>
			<form action="j_spring_security_check" id="frmLogin" method="post">
				<label for="j_username" id="lbLogin">Usu&aacute;rio:</label>
				<input type="text" autocomplete="off" name= "j_username"/>
				<label for="j_password" id="lbPassword">Senha:</label>
				<input type="password" name="j_password"/>
				<a href="esqueciMinhaSenha.jsp" id="forgotPassword">Esqueci minha senha</a>
				<input type="submit" value="Enviar" id="btSubmitLogin">
				<img src="/WEB-INF/webstatic/img/load-login.gif" id="load-login" alt="carregando" />
			</form>
			<p id="noRegister">Ainda n&atilde;o tem cadastro? <a href="/WEB-INF/pages/hello.jsp" id="btRegister">Clique aqui</a></p>
		</section>
		<script src="/WEB-INF/webstatic/js/login-validate.js" type="text/javascript"></script>
	</body>
</html>

