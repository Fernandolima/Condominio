<!DOCTYPE html>
<html lang="pt_BR">
	<head>
		<meta charset="UTF-8" />
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" type="text/css" href="login.css">
		
		<script src="jquery-1.10.2.min.js" type="text/javascript"></script>
	</head>
	<body id="login-view">
		<section id="login">
			<h1>Web Home</h1>
			<h2 id="titleLogin">Login</h2>
			<div id="warnningMessage"></div>
			<form action="j_spring_security_check" method="post">
				<label for="txtLogin" id="lbLogin">Usu&aacute;rio:</label>
				<input type="text" name= "j_username"/>
				<label for="txtPassword" id="lbPassword">Senha:</label>
				<input type="password" name="j_password"/>
				<a href="#" id="forgotPassword">Esqueci minha senha</a>
				<input type="submit" id="btSubmitLogin">
			</form>
			<p id="noRegister">Ainda n&atilde;o tem cadastro? <a href="#" id="btRegister">Clique aqui</a></p>
		</section>
		<script src="login-validate.js" type="text/javascript"></script>
	</body>
</html>