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
		
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap-responsive.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>"/>
		
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		<script src="<c:url value = "/bootstrap/vendors/modernizr-2.6.2-respond-1.1.0.min.js"/>" type="text/javascript"></script>
	</head>
		
	<body id="adminView">
		
		<div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="/WebHomeBeta/admin">Web Home - �rea Administrativa</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> <c:out value="${usuario.nome}"/> <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
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
                            <a href="/WebHomeBeta/admin"><i class="icon-chevron-right"></i>P�gina Principal</a>
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
                            <a href="/WebHomeBeta/admin/listarEspaco"><i class="icon-chevron-right"></i> Listar Espa�os</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/espaco"><i class="icon-chevron-right"></i> Cadastrar Espa�os</a>
                        </li>
                        <li class="active">
                            <a href="/WebHomeBeta/admin/listaEnquetes"><i class="icon-chevron-right"></i> Listar Enquetes</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/enquetes"><i class="icon-chevron-right"></i> Cadastrar Enquetes</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/validarMoradores"><i class="icon-chevron-right"></i>Validar Moradores</a>
                        </li>
                        <li>
                            <a href="/WebHomeBeta/admin/reservas"><i class="icon-chevron-right"></i>Validar Reservas</a>
                        </li>
                         <li>
                            <a href="/WebHomeBeta/home"><i class="icon-chevron-right"></i>Web Home</a>
                        </li>
                    </ul>
                </div>
                
                <!--/span-->
                <div class="span9" id="content">
                	
                	<div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Enquetes Cadastradas</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
  									<table class="table">
						              <thead>
						                <tr>
						                  <th>T�tulo</th>
						                  <th>Status</th>
						                  <th>Excluir</th>
						                  <th>Visualizar</th>
						                </tr>
						              </thead>
						              <tbody>
						                <c:forEach items="${listaEnquetes}" var="item" varStatus="theCount">
						                	<tr id="listEnquete">
						                		<td><c:out value="${item.enquete}"/></td>
						                		<c:choose>
													<c:when test="${item.ativa}">
														<td>
														 <a id="${theCount.index}" href="#div${theCount.index}" data-toggle="modal" class="btn btn-inverse" data-enquete="<c:out value="${item.idEquete}"/>">Desativar</a>
                       										<div id="div${theCount.index}" class="modal hide">
																<div class="modal-header">
																	<button data-dismiss="modal" class="close" type="button">�</button>
																	<h3>Desativa��o da enquete</h3>
																</div>
																	<div class="modal-body">
																		<p>Confirma desativa��o da enquete?</p>
																	</div>
																	<div class="modal-footer">
																		<a data-dismiss="modal" class="btn desativarEnquete btn-primary" href="#" data-id="${theCount.index}" data-enquete="<c:out value="${item.idEquete}"/>">Sim</a>
																		<a data-dismiss="modal" class="btn" href="#">N�o</a>
																	</div>
																</div>
														</td>
												    </c:when>
												  	<c:otherwise>
												  		<td>
												  		<a id="${theCount.index}" href="#div${theCount.index}" data-toggle="modal" class="btn btn-success" data-enquete="<c:out value="${item.idEquete}"/>">Ativar</a>
                       										<div id="div${theCount.index}" class="modal hide">
																<div class="modal-header">
																	<button data-dismiss="modal" class="close" type="button">�</button>
																	<h3>Ativa��o da enquete</h3>
																</div>
																	<div class="modal-body">
																		<p>Confirma ativa��o da enquete?</p>
																	</div>
																	<div class="modal-footer">
																		<a data-dismiss="modal" class="btn ativarEnquete  btn-primary" href="#" data-id="${theCount.index}" data-enquete="<c:out value="${item.idEquete}"/>">Sim</a>
																		<a data-dismiss="modal" class="btn" href="#">N�o</a>
																	</div>
																</div>
												  		</td>
												  													    	
												  	</c:otherwise>
												</c:choose>
						                		<td>
						                			<a href="#div${theCount.index}Excluir" data-toggle="modal" class="btn btn-danger" id="btnExcluir" data-enquete="<c:out value="${item.idEquete}"/>">Excluir</a>
						                			<div id="div${theCount.index}Excluir" class="modal hide">
																<div class="modal-header">
																	<button data-dismiss="modal" class="close" type="button">�</button>
																	<h3>Exclus�o da enquete</h3>
																</div>
																	<div class="modal-body">
																		<p>Deseja excluir?</p>
																	</div>
																	<div class="modal-footer">
																		<a data-dismiss="modal" class="btn excluirEnquete btn-primary" href="#" data-id="${theCount.index}" data-enquete="<c:out value="${item.idEquete}"/>">Sim</a>
																		<a data-dismiss="modal" class="btn" href="#">N�o</a>
																	</div>
																</div>
						                		</td>
						                		<td><a href="#" class="visualizarEnquete btn btn-info" id="btnVisualizar" data-enquete="<c:out value="${item.idEquete}"/>">Visualizar</a></td>
						                	</tr>
						                </c:forEach>
						                
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
		<script src="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.js"/>" type="text/javascript"></script>
        <script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
                
	</body>	
</html>
