<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="pt_BR">
	<head>
	<meta charset="UTF-8" />
		<title>Web Home - &Aacute;rea Administrativa</title>
		<script src="<c:url value = "/bootstrap/vendors/jquery-1.9.1.min.js"/>" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap-responsive.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/datepicker.css"/>"/>
		
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
	</head>
		
	<body id="adminView">
		
		<div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="/WebHomeBeta/admin">Web Home - Área Administrativa</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> <c:out value="${usuario.nome}"/> <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="/WebHomeBeta/logout">Logout</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                
                <div class="span3" id="sidebar">
                    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                    	<sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li>
                            <a href="/WebHomeBeta/admin"><i class="icon-chevron-right"></i>Página Principal</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/listaAtas"><i class="icon-chevron-right"></i> Listar Atas</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/atas"><i class="icon-chevron-right"></i> Cadastrar Atas</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/cadastrarBlocos"><i class="icon-chevron-right"></i> Cadastrar Blocos</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/listarEspaco"><i class="icon-chevron-right"></i> Listar Espaços</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/espaco"><i class="icon-chevron-right"></i> Cadastrar Espaços</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/listaEnquetes"><i class="icon-chevron-right"></i> Listar Enquetes</a>
                        </li>
                        <li class="active">
                            <a href="/WebHomeBeta/admin/enquetes"><i class="icon-chevron-right"></i> Cadastrar Enquetes</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/validarMoradores"><i class="icon-chevron-right"></i>Validar Moradores</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/reservas"><i class="icon-chevron-right"></i>Validar Reservas</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/mural"><i class="icon-chevron-right"></i>Mural</a>
                        </li>
                        <li>
                        	 <a href="/WebHomeBeta/admin/gasto"><i class="icon-chevron-right"></i>Gasto</a>
                        </li>
                         <li>
                            <a href="/WebHomeBeta/home"><i class="icon-chevron-right"></i>Web Home</a>
                        </li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_FUNC')">
                        <li>		
                            <a href="/WebHomeBeta/admin/visitantes"><i class="icon-chevron-right "></i>Visitantes</a>
                        </li>
                        <li>		
                            <a href="/WebHomeBeta/admin/visitantes/cadastro"><i class="icon-chevron-right "></i>Cadastrar Visitantes</a>
                        </li>
                        </sec:authorize>
                    </ul>
                </div>
                
                <!--/span-->
                <div class="span9" id="content">
                	
                	<div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Cadastro de Visitantes</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                	<form:form modelAttribute="bean" action="/WebHomeBeta/admin/visitante/salvar" class="form-horizontal" method="post" id="frmVisitante">
                                      <fieldset>
                                        <legend>Visitantes</legend>
                                        
                                        <div class="control-group">
                                        	<form:label for="tituloVisitante" path="VisitanteTO.nomeVisitante" class="control-label">Nome do Visitante:</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="tituloVisitante" path="visitanteTO.nomeVisitante" autocomplete="off" class="input-xlarge focused" />
	                                        </div>
                                        </div>
                                        
                                        <div class="control-group">
                                        	<form:label for="visitantePlacadoCarro" path="VisitanteTO.placaDoCarro" class="control-label">Digite a Placa do Carro:</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="placaVisitante" path="visitanteTO.placaDoCarro" autocomplete="off" class="input-xlarge focused" />
	                                        </div>
                                        </div>
                                        
                                         <div class="control-group">
                                        	<form:label for="rgVisitante" path="VisitanteTO.rg" class="control-label">Registro Geral (RG):</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="rgVisitante" path="visitanteTO.rg" autocomplete="off" class="input-xlarge focused" />
	                                        </div>
                                        </div>
                                        
                                          <div class="control-group">
                                        	<form:label for="apVisitante" path="VisitanteTO.ap" class="control-label">Apartamento:</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="apVisitante" path="visitanteTO.ap" autocomplete="off" class="input-xlarge focused" />
	                                        </div>
                                        </div>
                                        
                                        <div class="control-group">
                                        	<form:label for="blocoVisitante" path="VisitanteTO.bloco" class="control-label">Bloco:</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="blocoVisitante" path="visitanteTO.bloco" autocomplete="off" class="input-xlarge focused" />
	                                        </div>
                                        </div>
                                        
                                        
                                          <div class="control-group">
                                          		<label class="control-label" for="date01">Data</label>
                                          		<div class="controls">
                                            		<form:input type="text" id="date01" path="visitanteTO.data" autocomplete="off" placeholder="Data da Entrada do Visitante" value=" " class="input-xlarge datepicker" />
                                            	</div>
                                        	</div>
                                      
                                        
                                                                           
                                        <div class="form-actions">
                                        	<a href="/WebHomeBeta/admin/visitante/salvar" id="btn-adiciona-visitante" class="btn btn-info">Adicionar visitante</a>
                                        </div>
                                      </fieldset>
                                    </form:form>

                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>	
                					
                </div>
            </div>
            <hr>
            <footer>
                <p>&copy; Web Home</p>
            </footer>
        </div>
        <!--/.fluid-container-->
        <script src="<c:url value = "/bootstrap/vendors/bootstrap-datepicker.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/assets/scripts.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/js/adicionarBlocos.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
		
		<div id="jGrowl" class="top-right jGrowl">
			<div class="jGrowl-notification"></div>
		</div>
		 <script>
			   $(".datepicker").datepicker();
        </script>
    </body>	
</html>
