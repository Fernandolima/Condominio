<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
	<meta charset="UTF-8" />
	<title>Web Home - &Aacute;rea Administrativa - Cadastrar Espaços</title>
	<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>" />
	
	<script src="<c:url value = "/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
<head>
<body id="list-user-register">
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
							<li class="item-menu"><a href="/WebHomeBeta/espaco" class="menu-drop">Cadastro de espaços</a></li>
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
				<h2>Cadastro de Espaços</h2>
				<c:forEach items="${listaEspaco}" var="item" varStatus="num">
					<p class="itemBlocos pBloco">--<c:out value="${item}"/></p>
				</c:forEach>
				<form method="post" id="formCadEspaco" action="">
					<div id="content-espaco">
						<div class="espacos">
							<div class="comboEspaco" id="comboEspacoList">
								<label>Espaço:</label>
								<select onchange="ADMIN.espacos(this)">
									<option value="">Selecione</option>
									<option value="churrasqueira">Churrasqueira</option>
									<option value="piscina">Piscina</option>
									<option value="outro">Outro</option>
								</select>
							</div>
							<div class="outroEspaco"></div>
							<div class="elInput">
								<label>Descrição: </label>
								<input type="text" class="descricaoArea" />
							</div>
						</div>
					</div>					
					<input type="button" id="btSubmitBlocos" class="btSubmit" value="Enviar" />
					<a href="#" id="addEspaco" class="btnAdiciona">+</a>
				</form>
			</section>
		</div>
	</section>
	<!-- <footer id="footer-site">
		</footer> -->
	<script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/adicionarBlocos.js"/>" type="text/javascript"></script>
</body>
</html>
