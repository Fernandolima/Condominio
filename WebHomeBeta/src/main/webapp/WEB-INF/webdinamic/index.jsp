<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.springframework.security.core.GrantedAuthority"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.security.core.context.SecurityContext"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>


<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
  <% 
  	//verifica se o usuario ja esta logado, evitando que o mesmo veja a pagina de login
  	String path = null;
 	SecurityContext context = SecurityContextHolder.getContext();
 	if (context instanceof SecurityContext){
		Authentication authentication = context.getAuthentication();
		if (authentication instanceof Authentication){
			Collection<GrantedAuthority> granted = authentication.getAuthorities();
			for(GrantedAuthority authority : granted){
				if (authority.getAuthority().equals("ROLE_ADMIN")) {
					path = request.getContextPath()+"/admin";
					break;
				} else if (authority.getAuthority().equals("ROLE_MORADOR")) {
					path = request.getContextPath()+"/home";
					break;
				}
			}
		}
 	}
  	response.sendRedirect(path);
  	path = null;
  %>
</sec:authorize>
<!DOCTYPE html>

<html lang="pt_BR">
	<head>
		<meta charset="UTF-8" />
		<title>Web Home - Login</title>
		<link href="<c:url value = "http://fonts.googleapis.com/css?family=Chela+One"/>" rel='stylesheet' type='text/css'/>
		<link rel="shortcut icon" href="<c:url value = "/img/favicon.jpg"/>" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/login.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
	</head>
	<body id="login-view">
		<section id="login">
			<h1>Web Home</h1>
			<div id="warnningMessage"></div>
			<form action="j_spring_security_check" id="frmLogin" method="post">
				<label for="j_username" id="lbLogin">Usu&aacute;rio:</label>
				<input type="text" autocomplete="off" name= "j_username"/>
				<label for="j_password" id="lbPassword">Senha:</label>
				<input type="password" name="j_password"/>
				
				<div id="contentRemember">
					<label for = "j_remember" class="lblRemember">Continuar conectado</label>
					<input id = "j_remember" class="inpRemember" name ="_spring_security_remember_me" type="checkBox"/>
				</div>
				
				<a href="esqueciMinhaSenha" id="forgotPassword">Esqueci minha senha</a>
				<input type="submit" value="Enviar" id="btSubmitLogin" class="btSubmit">
				<img src="<c:url value = "/img/load-login.gif"/>" id="load-login" alt="carregando" />
			</form>
			<p id="noRegister">Ainda n&atilde;o tem cadastro? <a href="cadastro" id="btRegister">Clique aqui</a></p>
		</section>
		
		<script src="<c:url value = "/js/login-validate.js"/>" type="text/javascript"></script>
	</body>
</html>

