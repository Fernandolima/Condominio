<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
	<meta charset="UTF-8" />
	<title>Web Home</title>
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/bootstrap.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/magic-bootstrap.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/bootstrapHealper.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>" />

	<script src="<c:url value = "/js/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
<head>
<body id="informativoView" class="rede-social">
	<input type="hidden" id="userSessao" value="<c:out value="${moradorControllerBean.usuario.idUser}"></c:out>" />
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Web Home</a>
        </div>
        
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    		<ul class="nav navbar-nav">
    			<li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="alerta-notificacao"><span class="glyphicon glyphicon-star-empty"></span></a>
	              <span id="numeroNotificacao" class="badge dropdown-toggle" data-toggle="dropdown"></span>
	              <ul class="dropdown-menu" id="main-notificacao">
	                <li>Nenhuma notifica��o</li>
	              </ul>
	            </li>
    		</ul>
          
          	<ul class="nav navbar-nav navbar-right">
            	<li class="dropdown">
	            	<a href="#" class="dropdown-toggle" data-toggle="dropdown"><c:out value="${usuario.nome}" /> <b class="caret"></b></a>
	              	<ul class="dropdown-menu">
	                	<li><a href="/WebHomeBeta/home/perfil">Editar Perfil</a></li>
	                	<li class="divider"></li>
	                	<li><a href="WebHomeBeta/logout">Sair</a></li>
	              	</ul>
            	</li>
          	</ul>
        </div><!--/.nav-collapse -->
	</nav>
	

	<!-- Begin Body -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="row" id="sidebar" style="background-color: #57acdd;">
					<div class="col-md-12" id="fotoUsuario">
						<img src="<c:out value="${usuario.imagem}"></c:out>" alt="..." class="img-rounded img-responsive">
					</div>
					
					<ul class="nav nav-pills nav-stacked nav-usuario">
						<li><a href="/WebHomeBeta/home">Home</a></li>
						<li><a href="/WebHomeBeta/home/atas">Atas de Assembl�ia</a></li>
						<li class="active"><a href="/WebHomeBeta/home/informativo">An�ncios</a></li>
						<li><a href="/WebHomeBeta/home/gastos">Gastos</a></li>
						<li><a href="/WebHomeBeta/home/listarEspaco">Reserva de espa&ccedil;os</a></li>
						<li><a href="/WebHomeBeta/home/mural">Mural</a></li>
						<sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="/WebHomeBeta/admin">�rea Administrativa</a></li></sec:authorize>
					</ul>
				</div>
			</div>
			
			<div class="col-md-9">
				<div id="topPage">
					<h3>An�ncios</h3>
					<a href="/WebHomeBeta/home/novoInformativo" class="btn btn-xs btn-primary">+ Adicionar An�ncio</a>
				</div>
				
				<c:choose>
					<c:when test="${fn:length(listainformativo) > 0}">
				    	<c:forEach items="${listainformativo}" var="item">					
							<div class="panel panel-success">
		  						<div class="panel-heading">
		    						<h3 class="panel-title"><c:out value="${item.nomeUser}"/></h3>
		  						</div>
		  						<div class="panel-body">
		    						<p><b>E-mail: </b><c:out value="${item.email}"/></p>
					                <p style="width:200px"><b>An�ncio: </b><c:out value="${item.informativo}"/></p>
		  						</div>
							</div>					
		                </c:forEach>
				  	</c:when>
				  	<c:otherwise>
				    	<p>Nenhum an�ncio cadastrado. Seja o primeiro a fazer um an�ncio</p>
				  	</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<!-- <footer id="footer-site">
		</footer> -->

	<script src="<c:url value = "/bootstrap/vendors/jquery-1.9.1.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/dist/js/bootstrap.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/assets/scripts.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.js"/>" type="text/javascript"></script>
	<script type="text/javascript">
		$('#sidebar').affix({
			offset : {
				top : $('header').height()
			}
		});
	</script>
	<script src="<c:url value = "/js/comment.js"/>" type="text/javascript"></script>
</body>
</html>
