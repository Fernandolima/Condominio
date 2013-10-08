<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt_BR">
	<head>
	<meta charset="UTF-8" />
		<title>Web Home - &Aacute;rea Administrativa - Validar Cadastro</title>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		
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
							<li class="item-menu"><a href="listaAtas" class="menu-drop">Listar Atas</a></li>
							<li class="item-menu"><a href="atas" class="menu-drop">Cadastrar Atas</a></li>
						</ul>
						
						<span class="item-menu title-menu-drop"><b>></b> Condomínio</span>
						<ul class="sub-menu">
							<li class="item-menu"><a href="cadastrarBlocos" class="menu-drop">Cadastro de blocos</a></li>
						</ul>
						
						<span class="item-menu title-menu-drop"><b>></b> Enquete</span>
						<ul class="sub-menu">
							<li class="item-menu"><a href="listaEnquetes" class="menu-drop">Listar Enquetes</a></li>
							<li class="item-menu"><a href="enquetes" class="menu-drop">Cadastrar Enquetes</a></li>
						</ul>
						
						<a href="validarMoradores" class="item-menu">Morador</a>
						<a href="publicar" class="item-menu">Publicar</a>
				</nav>
				<section id="content-admin">
					<!-- Se não tiver cadastros para serem validados -->
					<!-- <div id="noRegistration">
						<p>Nenhum cadastro pendente.</p>
					</div> -->
					
					<!-- Se tiver cadastros pendentes -->
					<div id="entries">
						<p>Cadastros pendentes de aprovação</p>
						<table id="tableEntries">
							<tr>
								<td class="name">Nome</td>
								<td class="link">Link</td>
							</tr>
							<c:forEach items="${listaUsuarios}" var="item">
								<tr>
									<td class="name"><c:out value="${item.nome}"/></td>
									<td class="link"><a href="#" data-link="${item.login}">Link</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<form method="POST" action="editarCadastro" id="frmEditarCadastro">
						<input value="" type="hidden" name="login" id="loginEdit" />
					</form>
				</section>
			</div>
		</section>
		<!-- <footer id="footer-site">
		</footer> -->
		<script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
	</body>
</html>
