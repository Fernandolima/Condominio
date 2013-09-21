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
		<!-- <link href="<c:url value = "http://fonts.googleapis.com/css?family=Chela+One"/>" rel='stylesheet' type='text/css'/>-->
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
		
		<script type="JavaScript">
			function Validate() {
				var arquivo = document.getElementById("arquivo").value;
				if (arquivo != '') {
					var checkimg = arquivo.toLowerCase();
					if (!checkimg.match(/(\.pdf|\.PDF)$/)) {
						alert("Please enter Image File Extensions .pdf");
						document.getElementById("arquivo").focus();
						return false;
					}
				}
				return true;
			}
		</script>
	<head>
	<body id="cadastrar-atasView">
		<header id="header-site">
			<div class="content">
				<h1><a href="index" title="Web Home">Web Home</a></h1>
				<div id="data-user">
					<p>Ol&aacute;, <c:out value="${dadosUsuarioBean.usuario.nome}"/><p>
					<span>|</span>
					<a href="#" title="Ver site">Ver site</a>
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
							<li class="item-menu"><a href="listarAtas" class="menu-drop">Listar Atas</a></li>
							<li class="item-menu"><a href="atas" class="menu-drop">Cadastrar Atas</a></li>
						</ul>
						
						<span class="item-menu title-menu-drop"><b>></b> Condomínio</span>
						<ul class="sub-menu">
							<li class="item-menu"><a href="cadastrarBlocos" class="menu-drop">Cadastro de blocos</a></li>
						</ul>
						
						<a href="validarMoradores" class="item-menu">Morador</a>
						<a href="publicar" class="item-menu">Publicar</a>
				</nav>
				<section id="content-admin">
					<div id="cadastrarAtas">
						<h2>Cadastrar Atas</h2>
						<form:form modelAttribute="atasBean" action="atas/addArquivos" method="post" id="frmAtas" enctype="multipart/form-data">
							<div id="contentFrm">
								<div class="blocos">
									<form:label for="tituloAta" path="atasTo.titulo">Título:</form:label>
									<form:input type="text" id="tituloAta" path="atasTo.titulo" autocomplete="off" />
									 
									<form:label for="numAp" class="marginLabel" path="atasTo.atas">Atas</form:label>
									<form:input type="text" id="numAp" class="inputBloco" path="atasTo.atas" autocomplete="off" />
									
									<form:label for="fileData" path="fileData">File</form:label>
									<form:input path="fileData" id="arquivo" type="file" />
									
									<form:label for="numAp" class="marginLabel" path="atasTo.dataAta">Inicio da numeração:</form:label>
									<form:input type="text" id="numAp" class="inputBloco" path="atasTo.dataAta" autocomplete="off" />
									
								</div>
							</div>
							<input type="submit" id="btSubmitBlocos" class="btSubmit" value="Enviar" />
						</form:form>
					</div>
				</section>
			</div>
		</section>
		<!-- <footer id="footer-site">
		</footer> -->
		
		<script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
	</body>
</html>
