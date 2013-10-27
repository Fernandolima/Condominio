<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="pt_BR">
	<head>
	<meta charset="UTF-8" />
		<title>Web Home - &Aacute;rea Administrativa</title>
		
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap-responsive.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>"/>
		
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
                                        <a tabindex="-1" href="/WebHomeBeta/home">Ver site</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a tabindex="-1" href="WebHomeBeta/j_spring_security_logout">Logout</a>
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
                        <li>
                            <a href="/WebHomeBeta/admin"><i class="icon-chevron-right"></i> Home</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/listaAtas"><i class="icon-chevron-right"></i> Listar Atas</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/atas"><i class="icon-chevron-right"></i> Cadastrar Atas</a>
                        </li>
                        <li class="active">
                            <a href="/WebHomeBeta/admin/cadastrarBlocos"><i class="icon-chevron-right"></i> Cadastrar Blocos</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/espaco"><i class="icon-chevron-right"></i> Cadastrar Espaços</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/listaEnquetes"><i class="icon-chevron-right"></i> Listar Enquetes</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/enquetes"><i class="icon-chevron-right"></i> Cadastrar Enquetes</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/validarMoradores"><i class="icon-chevron-right"></i> Morador</a>
                        </li>
                    </ul>
                </div>
                
                <!--/span-->
                <div class="span9" id="content">
                	
                	<div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Cadastro de blocos</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form:form modelAttribute="bloco" class="form-horizontal" action="#" method="post" id="frmBlocos">
                                      <fieldset>
                                        <legend>Blocos do condimínio</legend>
                                        <div class="control-group">
                                        	<form:label class="control-label" for="bloco"  path="descricaoCondominioTO.bloco">Bloco:</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="bloco" class="input-xlarge focused" path="descricaoCondominioTO.bloco" autocomplete="off" />
	                                        </div>
                                        </div>
                                        <div class="control-group">
                                        	<form:label class="control-label" for="bloco"  path="descricaoCondominioTO.quantAp">Número de apartamentos:</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="bloco" class="input-xlarge focused" path="descricaoCondominioTO.quantAp" autocomplete="off" />
	                                        </div>
                                        </div>
                                        <div class="control-group">
                                        	<form:label class="control-label" for="bloco"  path="descricaoCondominioTO.quatApAndares">Apartamentos por andar:</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="bloco" class="input-xlarge focused" path="descricaoCondominioTO.quatApAndares" autocomplete="off" />
	                                        </div>
                                        </div>
                                        <div class="control-group">
                                        	<form:label class="control-label" for="bloco"  path="descricaoCondominioTO.numeroInicial">Início da numeração:</form:label>
	                                        <div class="controls">
	                                        	<form:input type="text" id="bloco" class="input-xlarge focused" path="descricaoCondominioTO.numeroInicial" autocomplete="off" />
	                                        </div>
                                        </div>
                                        <div class="form-actions">
                                        	<input type="button" id="btSubmitBlocos" class="btn btn-primary" value="Salvar" />
                                        </div>
                                      </fieldset>
                                    </form:form>

                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                        
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Blocos Cadastrados</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
  									<table class="table" id="listaBlocos">
						              <thead>
						                <tr>
						                  <th>Bloco</th>
						                  <th>Nº de Apartamentos</th>
						                  <th>Ap. por Andar</th>
						                  <th>Inicio da numeração</th>
						                  <th>Excluir</th>
						                </tr>
						              </thead>
						              <tbody>
						              	<c:choose>
											<c:when test="${fn:length(listaBlocos) gt 0}">
								              	<c:forEach items="${listaBlocos}" var="item" varStatus="num">
									                <tr>
									                  <td><c:out value="${item.bloco}"/></td>
									                  <td><c:out value="${item.quantAp}"/></td>
									                  <td><c:out value="${item.quatApAndares}"/></td>
									                  <td><c:out value="${item.numeroInicial}" /></td>
									                  <td><a href="#" data-id="<c:out value="${item.idbloco}"/>" class="btn btn-danger btn-delete-bloco">Delete</a></td>
									                </tr>
									            </c:forEach>	
									        </c:when>
											<c:otherwise>
												<tr>
									                  <td colspan="5"><p class="nenhumResultado">Nenhum bloco cadastrado</p></td>
									            </tr>
											</c:otherwise>	
										</c:choose>				                
						              </tbody>
						            </table>
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
		<script src="<c:url value = "/js/adicionarBlocos.js"/>" type="text/javascript"></script>
        
        <script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
                
	</body>	
</html>
</html>
