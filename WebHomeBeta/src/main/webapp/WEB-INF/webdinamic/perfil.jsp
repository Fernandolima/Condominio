<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt_BR">
	<head>
	<meta charset="UTF-8" />
		<title>Web Home - &Aacute;rea Administrativa - Validar Cadastro</title>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/jquery.modal.css"/>"/>
		<link rel="stylesheet" href="<c:url value = "/css/jquery.Jcrop.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/js/jquery.form.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/js/jquery.modal.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/js/jquery.Jcrop.min.js"/>" type="text/javascript"></script>
		
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
					<a href="/WebHomeBeta/home/perfil">Configuracoes</a>
					<span>|</span>
					<p class="name-user-connected"><c:out value="${moradorControllerBean.usuario.nome}"></c:out><p>					
				</div>
			</div>
		</header>
		<section id="contentSite">	
			
			<!-- Modal HTML embedded directly into document -->
		  	<div id="editarFoto" style="display:none;">
		  		<div id="container-foto">
		  			<img src="img/load-login.gif" id="loadFoto" alt="carregando foto"/> 
		  		</div>
		  		<a href="#" id="cortarImagem" style="display: none">OK</a>
		  	</div>
		  	
			<div id="main-site">			
				<div id="leftCol">
					<div id="user-connected">
						<div id="photo-user">
							<img id="thumb-photo" src="<c:out value="${moradorControllerBean.usuario.imagem}"></c:out>"/>
							<form:form modelAttribute="uploadControllerBean" id="trocarFoto" action="/WebHomeBeta/perfil/upload" name="frm" method="post" enctype="multipart/form-data" onSubmit="return Validate();">
								<label for="image" class="inputFile">Alterar foto</label>
								<form:input path="fileData" id="image" type="file" style="display:none;" onchange="EDITAR_PERFIL.alterarFoto(this)" />
									
								
							</form:form>
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
								<h2>Editar Perfil</h2>
							</div>
							<div id="alterar-senha">
								<h2 id="btn-alterar-senha">Alterar Senha</h2>
								<div id="content-alterar-senha">
									<p>Preencha os campos abaixo para alterar a sua senha</p>
									<form action="#" method="POST" id="frmAlterarSenha">
										<label>Senha atual:</label>
										<input type="password" id="txtSenha" />
										
										<label>Nova Senha:</label>
										<input type="password" id="txtNovaSenha" />
										
										<label>Confirmar Nova Senha:</label>
										<input type="password" id="txtNovaSenhaConf" />
										
										 <div class="form-actions">
                                        	<input type="submit" id="btSubmitPerfil" class="btn btn-primary" value="Salvar" />
                                        </div>
                                        
									</form>
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
	</body>
</html>