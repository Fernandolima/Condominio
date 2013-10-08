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
		<link href="http://fonts.googleapis.com/css?family=Chela+One" rel='stylesheet' type='text/css' />
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
		
		<script type="text/javascript">
			function Validate() {
				var image = document.getElementById("image").value;
				if (image != '') {
					var checkimg = image.toLowerCase();
					if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
						alert("Please enter Image File Extensions .jpg,.png,.jpeg");
						document.getElementById("image").focus();
						return false;
					}
				}
				return true;
			}
		</script>
	<head>
	<body id="perfil" class="rede-social">
		<header id="header-site" class="connected">
			<div class="content">
				<h1><a href="admin" class="hidden" id="logo-site" title="Web Home">Web Home</a></h1>
				<div id="data-user">
					<a href="WebHomeBeta/j_spring_security_logout" title="Sair" class="logout-site">Sair</a>
					<span>|</span>
					<a href="perfil">Configuracoes</a>
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
							<a href="#" id="alterarFoto">Alterar foto</a>
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
						<div id="perfil-user">
							<div id="content-titulo">
								<h2>Editar perfil</h2>
								
								<div id="editarFoto">
									<h2>Upload de foto</h2>
									
									<div id="main-upload">
										<form enctype="multipart/form-data">
											<input id="instanceValue" multiple="true" name="file" type="file">
											<input type="button" id="btn-upload" value="Upload">
										</form>
									</div>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- <footer id="footer-site">
		</footer> -->
		<script src="<c:url value = "/js/editar.js"/>" type="text/javascript"></script>
		<script type="text/javascript" src="<c:url value = "/js/upload.js"/>"></script>
	</body>
</html>