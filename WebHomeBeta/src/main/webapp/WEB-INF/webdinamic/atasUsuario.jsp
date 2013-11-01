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
								<li><a href="home/atas">Atas de Assembléias</a></li>
								<li><a href="#">Gastos</a></li>
								<li><a href="#">Reserva de espa&ccedil;os</a></li>
								<li class="last-link"><a href="#">Usu&aacute;rios</a></li>
							</ul>

						</div>
					</div>
				</div>
				<div id="rightCol">
					<h2 id="tituloSubPaginas">Lista de Atas</h2>
					
					<table class="table">
		            	<thead>
		                	<tr>
				                <th>Título da Ata</th>
				                <th>Data da ata</th>
				                <th>Visualizar</th>
				                <th>Download</th>
		              		</tr>
		              	</thead>
		              	<tbody>
		              	    <c:forEach items="${atas}" var="item">
		                		<tr>
			                		<td><c:out value="${item.titulo}"/></td>
			                		<td><c:out value="${item.dataFormat}"/></td>
			                		<td><a href="/WebHomeBeta/home/atas/id=<c:out value="${item.idAtas}"/>" class="btn btn-default">Visualizar</a></td>
			                		<td><a href="<c:out value="${item.arquivo}" />" target="_blank" class="btn btn-info">Baixar</a></td>
		                		</tr>
		                	</c:forEach>
		              	</tbody>
		        	</table>
				</div>
			</div>
		</section>
		<!-- <footer id="footer-site">
		</footer> -->		
	</body>
</html>
