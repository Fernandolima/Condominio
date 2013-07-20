<!DOCTYPE html>
<html lang="pt_BR">
	<head>
		<meta charset="UTF-8" />
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" type="text/css" href="login.css">
	</head>
	<body id="loginView">
		<header id="institucional">
			<div class="content">
				<h1>TCC</h1>
				<p class="description">Colocamos alguma mensagem marketeira aqui. Exemplo: A rede do seu condomínio</p>
			</div>
		</header>
		<section id="login">
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
	</body>
</html>