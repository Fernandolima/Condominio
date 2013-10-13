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
		<title>Web Home - &Aacute;rea Administrativa - Validar Cadastro</title>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
	<head>
	<body id="home" class="rede-social">
		<input type="hidden" id="userSessao" value="<c:out value="${moradorControllerBean.usuario.idUser}"></c:out>" />
		<header id="header-site" class="connected">
			<div class="content">
				<h1><a href="admin" class="hidden" id="logo-site" title="Web Home">Web Home</a></h1>
				<div id="comentario-display">
					<a href="#" id="alerta-notificacao" class="hidden">Notificação</a>
					<p id="numeroNotificacao"></p>
					<div id="main-notificacao">
						
					</div>
				</div>
				<div id="data-user">
					<a href="WebHomeBeta/j_spring_security_logout" title="Sair" class="logout-site">Sair</a>
					<span>|</span>
					<a href="perfil">Configurações</a>
					<span>|</span>
					<p class="name-user-connected"><c:out value="${moradorControllerBean.usuario.nome}"></c:out><p>					
				</div>
			</div>
		</header>
		<section id="contentSite">	
			<div id="main-site">			
				<div id="leftCol">
					<div id="user-connected">
						<div id="photo-user">
							<img id="thumb-photo" src="<c:out value="${moradorControllerBean.usuario.imagem}"></c:out>"/>
							
						</div>
						<div id="nav-user">
							<h3>Categoria</h3>
							<ul class="list-nav">
								<li><a href="#">Assembleias</a></li>
								<li><a href="#">Enquetes</a></li>
								<li><a href="#">Gastos</a></li>
								<li><a href="#">Reserva de espa&ccedil;os</a></li>
								<li class="last-link"><a href="#">Usu&aacute;rios</a></li>
							</ul>

						</div>
					</div>
				</div>
				<div id="rightCol">
					<div id="rigth-content">
						<form:form id="frmComment" method="POST" action="#" modelAttribute="moradorControllerBean">
							<form:textarea type="text" path = "publicacaoTO.publicacao" name="postUser" id="txtComment" placeholder="Está pensando em que?"></form:textarea>
							<input type="button" id="submitComment" value="Publicar" />
						</form:form>
						<div id="main-comments"></div>
					</div>
				</div>
			</div>
		</section>
		<!-- <footer id="footer-site">
		</footer> -->
		<script src="<c:url value = "/js/jquery.autosize.min.js"/>" type="text/javascript"></script>
		<script>
			$(document).ready(function(){
			    $('textarea').autosize();   
			});
		</script>
		<script src="<c:url value = "/js/comment.js"/>" type="text/javascript"></script>
	</body>
</html>
