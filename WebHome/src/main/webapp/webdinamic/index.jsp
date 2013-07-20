<!DOCTYPE html>
<html lang="pt_br">
	<head>
		<meta charset="UTF-8" />
		<link href='http://fonts.googleapis.com/css?family=Chela+One' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" type="text/css" href="login.css">
	</head>
	<body id="login-view">
		<section id="login">
			<h1>Web Home</h1>
			<div id="warnningMessage"><p>Verifique os campos destacados</div>
			<form id="frm-login" action="j_spring_security_check" method="post">
				<label for="txtLogin" id="lbLogin">Login:</label>
				<input type="text" name= "j_username"/>
				<label for="txtPassword" id="lbPassword">Senha:</label>
				<input type="password" name="j_password"/>
				<a href="#" id="forgotPassword">Esqueci minha senha</a>
				<input type="submit" id="btSubmitLogin" value="Enviar">
			</form> 
			<p id="noRegister">Ainda n&atilde;o tem cadastro? <a href="#" id="btRegister">Clique aqui</a></p>
		</section>
	</body>
</html>