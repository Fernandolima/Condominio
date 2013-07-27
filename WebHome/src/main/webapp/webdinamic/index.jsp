<!DOCTYPE html>
<html lang="pt_BR">
	<head>
		<meta charset="UTF-8" />
		<link href='http://fonts.googleapis.com/css?family=Chela+One' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" type="text/css" href="login.css">
		
		<script src="jquery-1.10.2.min.js" type="text/javascript"></script>
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
				<img src="load-login.gif" id="load-login" alt="carregando" />
			</form>
			<p id="noRegister">Ainda n&atilde;o tem cadastro? <a href="cadastro.jsp" id="btRegister">Clique aqui</a></p>
		</section>
		<script src="login-validate.js" type="text/javascript"></script>
	</body>
</html>

