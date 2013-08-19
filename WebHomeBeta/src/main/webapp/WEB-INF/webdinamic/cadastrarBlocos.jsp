<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt_BR">
<head>
<meta charset="UTF-8" />
<title>Web Home - &Aacute;rea Administrativa - Validar Cadastro</title>
<link href="http://fonts.googleapis.com/css?family=Chela+One"
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/webstatic/css/style.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/webstatic/css/admin-home.css"/>" />

<script src="<c:url value = "/webstatic/js/jquery-1.7.2.min.js"/>"
	type="text/javascript"></script>
<head>
<body id="list-user-register">
	<header id="header-site">
		<div class="content">
			<h1>
				<a href="index" title="Web Home">Web Home</a>
			</h1>
			<div id="data-user">
				<p>Entrou como Administrador
				<p>
					<span>|</span> <a href="#" title="Ver site">Ver site</a> <span>|</span>
					<a href="#" title="Sair">Sair</a>
			</div>
		</div>
	</header>
	<section id="main-admin-home">
		<div class="content">
			<nav id="nav-admin">
				<h2>Administrador</h2>
				<span class="item-menu">Painel</span> <a href="validarMoradores"
					class="item-menu"><b>></b> Morador</a>
				<!-- <ul id="btn-morador" class="item-menu">
						<li></li>
					</ul> -->
			</nav>
			
			
			<section id="content-admin">
				<h2>Cadastro de Blocos e Apartamentos</h2>
				<form action="addBloco" method="POST" id="frmBlocos">
					<div id="contentFrm">
						<div class="blocos">
							<label>Bloco:</label>
							<input type="text" name="descricaoCondominioTO.bloco" id="bloco" />

							<label class="marginLabel">Nº de Apartamentos:</label>
							<input type="text" name="descricaoCondominioTO.ap" />
							
							<label class="marginLabel">Ap por andar:</label>
							<input type="text" name="descricaoCondominioTO.quatAndares" />
							
							<label class="marginLabel">Inicio da numeração:</label>
							<input type="text" name="descricaoCondominioTO.numeroInicial" />
						</div>
					</div>

					<%--<a href="#" class="adicionar-bloco">+ Adicionar mais bloco</a>--%>
					<input type="submit" id="btSubmitBlocos" class="btSubmit" value="Enviar" />
				</form>
			</section>
		</div>
	</section>
	<!-- <footer id="footer-site">
		</footer> -->
	<%--<script src="<c:url value = "/webstatic/js/adicionarBlocos.js"/>" type="text/javascript"></script>--%>
</body>
</html>
