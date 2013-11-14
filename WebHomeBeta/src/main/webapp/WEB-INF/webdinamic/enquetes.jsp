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
		
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap-responsive.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.css"/>"/>
		
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
                                <div class="muted pull-left">Cadastro de Enquetes</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                	<form:form modelAttribute="bean" action="/WebHomeBeta/admin/enquetes/salvar" class="form-horizontal" method="post" id="frmEnquetes">
                                      <fieldset>
                                        <legend>Enquete</legend>
                                        
                                        <div class="control-group">
                                        	<form:label for="tituloEnquete" path="enquetesTo.titulo" class="control-label">Título:</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="tituloEnquete" path="enquetesTo.titulo" autocomplete="off" class="input-xlarge focused" />
	                                        </div>
                                        </div>
                                        
                                        <div class="control-group">
                                        	<form:label for="tituloEnquete" path="enquetesTo.equete" class="control-label">Pergunta:</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="tituloEnquete" path="enquetesTo.equete" autocomplete="off" class="input-xlarge focused" />
	                                        </div>
                                        </div>
                                        
                                        <div id="contentOpcao">
	                                        <div class="control-group">
	                                        	<form:label for="listOpcoes" path="enquetesTo.opcoes" class="control-label">Opção 1:</form:label>
		                                        <div class="controls">
		                                        	<form:input type="text" path="listOpcoes[0]" autocomplete="off" class="input-xlarge focused opcaoEnquete" />
		                                        </div>
	                                        </div>
	                                    </div>
                                        
                                        <div class="form-actions">
                                        	<a href="#" id="btn-adiciona-opcao" class="btn btn-info">Adicionar opção</a>
                                        	<input type="submit" id="btSubmitEnquete" class="btn btn-primary" value="Salvar" />
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
        
        <script src="<c:url value = "/bootstrap/vendors/jquery-1.9.1.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/assets/scripts.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/js/adicionarBlocos.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
		
		<div id="jGrowl" class="top-right jGrowl">
			<div class="jGrowl-notification"></div>
		</div>
    </body>	
</html>
