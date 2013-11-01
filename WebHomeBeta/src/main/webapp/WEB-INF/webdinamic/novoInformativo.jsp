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
		<title></title>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
	<head>
	<body id="home" class="rede-social">
		<input type="hidden" id="userSessao" value="<c:out value="${usuario.idUser}"></c:out>" />
		<header id="header-site" class="connected">
			<div class="content">
				<h1><a href="/WebHomeBeta/home/" class="hidden" id="logo-site" title="Web Home">Web Home</a></h1>
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
					<p class="name-user-connected"><c:out value="${usuario.nome}"></c:out><p>					
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
								<li><a href="/WebHomeBeta/home/informativo">Anúncios</a></li>
								<li><a href="home/atas">Atas de Assembléias</a></li>
								<li><a href="#">Gastos</a></li>
								<li><a href="#">Reserva de espa&ccedil;os</a></li>
								<li class="last-link"><a href="#">Usu&aacute;rios</a></li>
							</ul>

						</div>
					</div>
				</div>
				<div id="rightCol">
					<h2 id="tituloSubPaginas">Cadastrar Informativo</h2>
					
					<form method="POST" autocomplete="off" action="/WebHomeBeta/home/novoInformativo/salvar">
						<input type="hidden" name="informativoTO.idUser" value="<c:out value="${usuario.idUser}"/>" />
						<input type="hidden" name="informativoTO.nomeUser" value="<c:out value="${usuario.nome}"/>" />
						<input type="text" name="informativoTO.email" placeholder="email" />
						<textarea name="informativoTO.informativo" placeholder="anuncio"></textarea>
						
						<input type="submit" value="enviar" />
					</form>
					
				</div>
			</div>
		</section>
		<!-- <footer id="footer-site">
		</footer> -->		
	</body>
</html>
