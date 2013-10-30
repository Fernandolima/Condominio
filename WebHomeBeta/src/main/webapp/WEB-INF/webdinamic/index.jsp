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
  	//verifica se o usuario ja esta logado, evitando que o mesmo veja a pagina de login se estiver logado
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
		<link rel="shortcut icon" href="<c:url value = "/img/favicon.jpg"/>" type="image/x-icon" />
		<!-- <link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/login.css"/>"/> -->
		
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap-responsive.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/login.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
	</head>
	<body id="login">
	    <div class="container">
	        <form class="form-signin" action="j_spring_security_check" id="frmLogin" method="post" autocomplete="off">
	            <h2 class="form-signin-heading" id="titleLogin">Web Home</h2>
	            <input type="text" class="input-block-level" name="j_username" placeholder="E-mail">
	            <input type="password" class="input-block-level" name="j_password" placeholder="Senha">
	            <label for="j_remember" class="checkbox">
	            <input type="checkbox" id="j_remember" name="_spring_security_remember_me"> Continuar conectado
	            </label>
	            <input class="btn btn-large btn-primary" type="submit" value="Login"/>
	            
	            <p id="noRegister">Ainda n&atilde;o tem cadastro? <a href="cadastro" id="btRegister">Clique aqui</a></p>
	        </form>	
	    </div> <!-- /container -->
		
		<script src="<c:url value = "/bootstrap/vendors/jquery-1.9.1.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/js/login-validate.js"/>" type="text/javascript"></script>
		
	</body>
</html>

