<!DOCTYPE html>
<html lang="pt_BR">
	<head>
		<meta charset="UTF-8" />
		<title>Web Home - Esqueci minha senha</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		
		<script src="jquery-1.10.2.min.js" type="text/javascript"></script>
	</head>
	<body id="forgotPassword-view">
		<form action="enviarEmail" method="POST" id="frmForgotPassword">
			<label>Digite seu e-mail</label>
			<input type="text" name="email" />
			<br>
			<input type="submit" value="Enviar" />			
		</form>
		
	</body>
</html>

<!-- 
	- Validar se usuário tem cadastro - setar em uma variável em caso de erro e em caso de sucesso (ex: sendEmailForgot: true ou false), ai o front
	faz o tratamento com essa variável
	
	- Em caso de sucesso - Enviar um e-mail para o usuário
 -->
