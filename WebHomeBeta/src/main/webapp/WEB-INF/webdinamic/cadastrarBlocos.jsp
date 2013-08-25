<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
				
				<form:form modelAttribute="bean" action="addBloco" method="post" id="frmBlocos">
					<div id="contentFrm">
						<div class="blocos">
							<form:label for="bloco" path="descricaoCondominioTO.bloco">Bloco:</form:label>
							<form:input type="text" id="bloco" path="descricaoCondominioTO.bloco" />
							
							<form:label for="numAp" class="marginLabel" path="descricaoCondominioTO.ap">N� de Apartamentos:</form:label>
							<form:input type="text" id="numAp" path="descricaoCondominioTO.ap" />
							
							<form:label for="numAp" class="marginLabel" path="descricaoCondominioTO.quatAndares">Ap. por Andar:</form:label>
							<form:input type="text" id="numAp" path="descricaoCondominioTO.quatAndares" />
							
							<form:label for="numAp" class="marginLabel" path="descricaoCondominioTO.numeroInicial">Inicio da numera��o:</form:label>
							<form:input type="text" id="numAp" path="descricaoCondominioTO.numeroInicial" />
							
						</div>
					</div>

					<%--<a href="#" class="adicionar-bloco">+ Adicionar mais bloco</a>--%>
					<input type="submit" id="btSubmitBlocos" class="btSubmit" value="Enviar" />
				</form:form>
			</section>
		</div>
	</section>
	<!-- <footer id="footer-site">
		</footer> -->
	<%--<script src="<c:url value = "/webstatic/js/adicionarBlocos.js"/>" type="text/javascript"></script>--%>
</body>
</html>
