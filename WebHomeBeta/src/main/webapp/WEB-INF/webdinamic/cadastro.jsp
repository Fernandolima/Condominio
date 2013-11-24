<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
	<meta charset="UTF-8" />
	<title>Web Home</title>
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/bootstrap.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/magic-bootstrap.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/bootstrapHealper.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>" />

	<script src="<c:url value = "/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
<head>
<body id="home" class="rede-social">
	<input type="hidden" id="userSessao" value="<c:out value="${moradorControllerBean.usuario.idUser}"></c:out>" />
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
          <a class="navbar-brand" href="#">Web Home</a>
        </div>
	</nav>
	

	<!-- Begin Body -->
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2 class="text-info">Pr&eacute;-Cadastro</h2>

				<p>Para ter acesso &agrave; &Aacute;rea do Morador, preencha o
					formul&aacute;rio ao lado.</p>
				<p>Seu cadastro ser&aacute; encaminhado e validado pelo
					s&iacute;ndico e em breve seu acesso ser&aacute; liberado.</p>
			</div>
			
			<div class="col-md-8">
				<h2 class="text-info">Formulário de Cadastro</h2>
				<p class="text-right">* Campos obrigatórios</p>
				<form:form role="form" modelAttribute="bean" action="add" method="post" id="frm-register">
				
			
				
					<div class="form-group">
    					<form:input placeholder="Nome: *" type="text" id="nome" path="usuarioTO.nome" cssClass="form-control  ${(bean.validName) ? '' : 'has-error'}"/>
 					</div>
 					
 					<div class="form-group">
    					<form:input placeholder="E-mail: *" path="usuarioTO.email" id="email" cssClass="form-control  ${(bean.validEmail) || (bean.validEmailExistente) ? '' : 'error'}" />
 					</div>
 					
 					<div class="form-group">
    					<form:password placeholder="Senha: *" id="senha" path="usuarioTO.senha" cssClass="form-control  ${(bean.validSenha) ? '' : 'error'}" />
 					</div>
 					
 					<div class="form-group">
    					<form:password placeholder="Confirmar Senha: *" id="confSenha" path="confSenha" cssClass="form-control  ${(bean.validConfSenha) ? '' : 'error'}" />
 					</div>
 					
 					<div class="form-group">
    					<form:input placeholder="Data de nascimento: *" path="data" id="dt_nascimento" cssClass="form-control  ${(bean.validDataNascimento) ? '' : 'error'}" />
 					</div>
 					
 					<div class="form-group">
    					<form:input placeholder="CPF: *" path="usuarioTO.cpf" id="cpf" cssClass="form-control ${(bean.validCpf) ? '' : 'error'}" />
 					</div>
 					
 					<div class="form-group">
    					<form:input placeholder="Bloco: *" path="usuarioTO.bloco" id="bloco" cssClass="form-control ${(bean.validBloco) ? '' : 'error'}" />
 					</div>
 					
 					<div class="form-group">
    					<form:input placeholder="Apartamento: *" path="usuarioTO.ap" id="apartamento" cssClass="form-control  ${(bean.validApartamento) ? '' : 'error'}" />
 					</div>
 					
 					<input type="submit" id="btSubmitRegister" class="btn btn-primary" value="Enviar" />
				</form:form>
			</div>
			
		</div>
	</div>
	<!-- <footer id="footer-site">
		</footer> -->

	<script src="<c:url value = "/bootstrap/dist/js/bootstrap.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/assets/scripts.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.js"/>" type="text/javascript"></script>
	
	<script src="<c:url value = "/js/jquery.alphanumeric.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/jquery.maskedinput-1.3.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/cadastro.js"/>" type="text/javascript"></script>
</body>
</html>
