<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
	<meta charset="UTF-8" />
	<title>Web Home - &Aacute;rea Administrativa - Validar Cadastro</title>
	<link href="http://fonts.googleapis.com/css?family=Chela+One" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>" />
	
	<script src="<c:url value = "/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
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
				
					<span class="item-menu title-menu-drop"><b>></b> Condom�nio</span>
					<ul class="sub-menu">
						<li class="item-menu"><a href="cadastrarBlocos" class="menu-drop">Cadastro de blocos</a></li>
					</ul>
					
					<a href="validarMoradores" class="item-menu">Morador</a>
					<a href="publicar" class="item-menu">Publicar</a>
			</nav>			
			
			<section id="content-admin">
				<h2>Cadastro de Blocos e Apartamentos</h2>
				
				<form:form modelAttribute="bloco" action="addBloco" method="post" id="frmBlocos">
					<div id="contentFrm">
						<div class="blocos">
							<form:label for="bloco" path="descricaoCondominioTO.bloco">Bloco:</form:label>
							<form:input type="text" id="bloco" path="descricaoCondominioTO.bloco" autocomplete="off" />
							 
							<form:label for="numAp" class="marginLabel" path="descricaoCondominioTO.quantAp">N� de Apartamentos:</form:label>
							<form:input type="text" id="numAp" path="descricaoCondominioTO.quantAp" autocomplete="off" />
							
							<form:label for="numAp" class="marginLabel" path="descricaoCondominioTO.quatApAndares">Ap. por Andar:</form:label>
							<form:input type="text" id="numAp" path="descricaoCondominioTO.quatApAndares" autocomplete="off" />
							
							<form:label for="numAp" class="marginLabel" path="descricaoCondominioTO.numeroInicial">Inicio da numera��o:</form:label>
							<form:input type="text" id="numAp" path="descricaoCondominioTO.numeroInicial" autocomplete="off" />
							
						</div>
					</div>
					<input type="submit" id="btSubmitBlocos" class="btSubmit" value="Enviar" />
				</form:form>
				
				<div id="blocosCadastrados">
					<h2>Blocos Cadastrados</h2>					
					<c:choose>
						<c:when test="${fn:length(listaBlocos) gt 0}">
							<div id="tabelaBlocos">
								<div class="lineTabelaBlocos">
									<p class="itemBlocos pBloco title">Bloco</p>
									<p class="itemBlocos title">N� de Apartamentos</p>
									<p class="itemBlocos title">Ap. por Andar</p>
									<p class="itemBlocos title">Inicio da numera��o</p>
									<p class="itemBlocos title deleteBloco">Excluir</p>
								</div>
								<c:forEach items="${listaBlocos}" var="item" varStatus="num">
							    	<div class="lineTabelaBlocos">
										<p class="itemBlocos pBloco"><c:out value="${item.bloco}"/></p>
										<p class="itemBlocos"><c:out value="${item.quantAp}"/></p>
										<p class="itemBlocos"><c:out value="${item.quatApAndares}"/></p>
										<p class="itemBlocos"><c:out value="${item.numeroInicial}" /></p>
										<p class="itemBlocos delete" data-id="<c:out value="${item.idbloco}"/>"><a href="#" class="btn-delete-bloco hidden">Delete</a></p>
									</div>							    	
							    </c:forEach>
							</div>
						</c:when>
						<c:otherwise>
							<p class="nenhumResultado">Nenhum bloco cadastrado</p>
						</c:otherwise>
					</c:choose>
			</section>
		</div>
	</section>
	<!-- <footer id="footer-site">
		</footer> -->
	<script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
</body>
</html>
