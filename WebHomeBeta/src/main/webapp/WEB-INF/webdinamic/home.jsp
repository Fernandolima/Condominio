<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<body id="home" class="rede-social">
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
	                <li>Nenhuma notificação</li>
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
		
			<div class="col-md-3">
				<div class="row" id="sidebar" style="background-color: #57acdd;">
					<div class="col-md-12" id="fotoUsuario">
						<img src="<c:out value="${moradorControllerBean.usuario.imagem}"></c:out>" alt="..." class="img-rounded img-responsive">
					</div>
					
					<ul class="nav nav-pills nav-stacked nav-usuario">
						<li class="active"><a href="/WebHomeBeta/home">Home</a></li>
						<li><a href="/WebHomeBeta/home/atas">Atas de Assembléia</a></li>
						<li><a href="/WebHomeBeta/home/informativo">Anúncios</a></li>
						<li><a href="#">Gastos</a></li>
						<li><a href="/WebHomeBeta/home/listarEspaco">Reserva de espa&ccedil;os</a></li>
						<li><a href="#">Usu&aacute;rios</a></li>
					</ul>
				</div>
			</div>
			
			<div class="col-md-5">
			
				<form:form id="frmComment" method="POST" action="#" modelAttribute="moradorControllerBean" class="form-horizontal" role="form">
					<form:textarea type="text" path ="publicacaoTO.publicacao" name="postUser" id="txtComment" class="form-control" placeholder="Está pensando em que?"></form:textarea>
					<input type="button" id="submitComment" class="btn btn-warning" value="Publicar" />
				</form:form>
				
				<div id="main-comments"></div>
				
			</div>
			
			<c:if test="${fn:length(listaEnquetes) gt 0}">
				<div class="col-md-3 col-md-offset-1" style="margin-bottom: 30px; background: #ECEFF5; ">
					<c:forEach items="${listaEnquetes}" var="item">
						<div class="enquete" id="idEnquete-<c:out value="${item.idEnquete}"/>">
							<h4>Enquete: <c:out value="${item.enquete}"/></h4>
							<div class="opcoesEnquete">
								<input type="hidden" class="idEnquete" value="<c:out value="${item.idEnquete}"/>"/>
								<c:forEach items="${item.opcoes}" var="opc">
									<div class="radio">
										<label>
											<input type="radio" name="opc" value="<c:out value="${opc.idOpcao}"/>"><c:out value="${opc.opcao}"/>
										</label>
									</div>
								</c:forEach>
							</div>
							
							<a href="#" class="participarEnquete btn btn-info">Votar</a>
						</div>
					</c:forEach>
				</div>
			</c:if>
			
			<div class="col-md-3 col-md-offset-1" style="background: #ECEFF5; padding-bottom:15px;">
				<h4>Anúncios</h4>
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
      						<h4 class="panel-title">
					        	<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
					          		vende-se apartamento
					        	</a>
      						</h4>
    					</div>
    					<div id="collapseOne" class="panel-collapse collapse in">
					    	<div class="panel-body">
					        	3dorm, sala, cozinha planejada
					        	Contato: 19 33221111
					      	</div>
					    </div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
      						<h4 class="panel-title">
					        	<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
					          		vende-se apartamento
					        	</a>
      						</h4>
    					</div>
    					<div id="collapseTwo" class="panel-collapse collapse">
					    	<div class="panel-body">
					        	3dorm, sala, cozinha planejada
					        	Contato: 19 33221111
					      	</div>
					    </div>
					</div>
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
