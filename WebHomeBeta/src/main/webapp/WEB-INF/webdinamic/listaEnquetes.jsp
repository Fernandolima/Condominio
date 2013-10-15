<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="pt_BR">
	<head>
	<meta charset="UTF-8" />
		<title>Web Home - &Aacute;rea Administrativa</title>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>

	<head>
	<body id="cadastrar-atasView">
		<header id="header-site">
			<div class="content">
				<h1><a href="../admin" class="hidden" id="logo-site" title="Web Home">Web Home</a></h1>
				<div id="data-user">
					<p>Ol&aacute;, <c:out value="${usuario.nome}"/><p>
					<span>|</span>
					<a href="home" title="Ver site">Ver site</a>
					<span>|</span>
					<a href="WebHomeBeta/j_spring_security_logout" title="Sair">Sair</a>
				</div>
			</div>
		</header>
		<section id="main-admin-home">
			<div class="content">
				<nav id="nav-admin">
					<h2>Administrador</h2>
						
						<span class="item-menu title-menu-drop"><b>></b> Atas</span>
						<ul class="sub-menu">
							<li class="item-menu"><a href="/WebHomeBeta/admin/listaAtas" class="menu-drop">Listar Atas</a></li>
							<li class="item-menu"><a href="/WebHomeBeta/admin/atas" class="menu-drop">Cadastrar Atas</a></li>
						</ul>
						
						<span class="item-menu title-menu-drop"><b>></b> Condomínio</span>
						<ul class="sub-menu">
							<li class="item-menu"><a href="/WebHomeBeta/admin/cadastrarBlocos" class="menu-drop">Cadastro de blocos</a></li>
						</ul>
						
						<span class="item-menu title-menu-drop"><b>></b> Enquete</span>
						<ul class="sub-menu">
							<li class="item-menu"><a href="/WebHomeBeta/admin/listaEnquetes" class="menu-drop">Listar Enquetes</a></li>
							<li class="item-menu"><a href="/WebHomeBeta/admin/enquetes" class="menu-drop">Cadastrar Enquetes</a></li>
						</ul>
						
						<a href="/WebHomeBeta/admin/validarMoradores" class="item-menu">Morador</a>
						<a href="/WebHomeBeta/admin/publicar" class="item-menu">Publicar</a>
				</nav>
				<section id="content-admin">
					<div id="cadastrarEnquetes">
						<h2>Enquetes Cadastradas</h2>
						
						<div id="tabelaBlocos">
							<div class="lineTabelaBlocos">
								<p class="itemBlocos pBloco title">Título</p>
								<p class="itemBlocos title">Status</p>
								<p class="itemBlocos excluir">Excluir</p>
								<p class="itemBlocos excluir">Visualizar</p>
							</div>
							<c:forEach items="${listaEnquetes}" var="item">
						    	<div class="lineTabelaBlocos">
									<p class="itemBlocos pBloco"><c:out value="${item.enquete}"/></p>
									<c:choose>
										<c:when test="${item.ativa}">
									    	<a href="#" class="itemBlocos desativarEnquete" data-enquete="<c:out value="${item.idEquete}"/>">Desativar</a>
									  	</c:when>
									  	<c:otherwise>
									    	<a href="#" class="itemBlocos ativarEnquete" data-enquete="<c:out value="${item.idEquete}"/>">Ativar</a>
									  	</c:otherwise>
									</c:choose>
									<a href="#" class="itemBlocos excluirEnquete" data-enquete="<c:out value="${item.idEquete}"/>">Excluir</a>
									<a href="#" class="itemBlocos visualizarEnquete" data-enquete="<c:out value="${item.idEquete}"/>">Visualizar</a>
								</div>							    	
						    </c:forEach>
						</div>
									
					</div>
				</section>
			</div>
		</section>
		<!-- <footer id="footer-site">
		</footer> -->
		
		<script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
		</body>
</html>
