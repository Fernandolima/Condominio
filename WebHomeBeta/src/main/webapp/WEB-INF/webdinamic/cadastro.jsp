<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt_BR">

      <c:set var="nomeOK" value="false"/> <!-- se o campo estiver preenchido errado uma vari�vel deve vir setada como true -->
      <c:set var="nomeCadastro" value="Tatiane Jayme Dias"/> <!-- quando retorna com erro, todos os valores inseridos nos inputs devem ser retornados em uma vari�vel -->
      <c:set var="formNok" value="true"/> <!-- se algum campo do formul�rio estiver com erro, uma vari�vel deve vir setada como true -->      
      
	<head>
	<meta charset="UTF-8" />
		<title>Web Home - Cadastro</title>
		<link href="<c:url value = "http://fonts.googleapis.com/css?family=Chela+One"/>" rel='stylesheet' type='text/css'/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/webstatic/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/webstatic/css/cadastro.css"/>"/>
		
		<script src="<c:url value = "/webstatic/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
	<head>
	<body id="register-view">
		<header id="header-site">
			<div class="content">
				<h1><a href="index" title="Web Home">Web Home</a></h1>
			</div>
		</header>
		<section id="main-register">
			<div class="content">
				<div class="info-register">
					<h2>Pr&eacute;-Cadastro</h2>

					<p>Para ter acesso &agrave; &Aacute;rea do Morador, preencha o formul&aacute;rio ao lado.</p>
					<p>Seu cadastro ser&aacute; encaminhado e validado pelo s&iacute;ndico e em breve seu acesso ser&aacute; liberado.</p>
				</div>
				<div class="form-register">
					<h2>Formul�rio de Pr�-Cadastro</h2>
					<p>* Campos obrigat�rios</p>
		
					<form:form modelAttribute="bean" action="cadastro/add" method="post" id="frm-register">
						<div id="warnningMessage">
							<p>Verifique os campos destacados</p>
						</div>
						
						<form:label for="nome" path="usuarioTO.nome">Nome: *</form:label>
						<form:input type="text" path="usuarioTO.nome" cssClass="${(bean.validName) ? '' : 'error'}" />
						
						<form:label for="email" path="usuarioTO.email">E-mail: *</form:label>
						<form:input path="usuarioTO.email" cssClass="${(bean.validEmail) ? '' : 'error'}" />
						
						<form:label for="senha" path="usuarioTO.senha">Senha: *</form:label>
						<form:password path="usuarioTO.senha" />
						
						<form:label for="confSenha" class="lblRight" path="confSenha">Confirmar Senha: *</form:label>
						<form:password path="confSenha" />
						
						<form:label for="dt_nascimento" path="usuarioTO.dt_nascimento">Data de nascimento:</form:label>
						<form:input path="usuarioTO.dt_nascimento"/>
						<!--<fmt:formatDate value="${dt_nascimento.time}" pattern="DD/MM/YYYY"/>-->
						
						<form:label class="lblRight" for="cpf" path="usuarioTO.cpf">CPF: *</form:label>
						<form:input path="usuarioTO.cpf" />
						
						<form:label for="bloco" path="usuarioTO.bloco">Bloco: *</form:label>
						<form:input path="usuarioTO.bloco" />
						
						<form:label for="apartamento" class="lblRight" path="usuarioTO.apartamento">Apartamento: *</form:label>
						<form:input path="usuarioTO.apartamento"/>
						
						<input type="submit" id="btSubmitRegister" class="btSubmit" value="Enviar" />
					</form:form></div>
			</div>
		</section>
		<footer id="footer-site">
		</footer>
		
		<script src="<c:url value = "/webstatic/js/jquery.alphanumeric.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/webstatic/js/jquery.maskedinput-1.3.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/webstatic/js/cadastro.js"/>" type="text/javascript"></script>
	</body>
</html>
