<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                    <a class="brand" href="/WebHomeBeta/admin">Web Home - �rea Administrativa</a>
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
                        <li class="active">
                            <a href="/WebHomeBeta/admin/espaco"><i class="icon-chevron-right"></i> Cadastrar Espa�os</a>
                        </li>
                        <li>
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
                                <div class="muted pull-left">Cadastro de Espa�os</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form class="form-horizontal" action="#" method="post" id="formCadEspaco" accept-charset="UTF-8">
                                      <fieldset>
                                        <legend>Espa�os do condom�nio</legend>
                                        <input type="hidden" name="idUser" id="idUser" value="<c:out value="${usuario.idUser}"/>" />
                                        
                                        <div class="control-group" data-posicao="0">
                                        	<label class="control-label">Espa�o:</label>
	                                        <div class="controls">
	                                        	<select id="comboEspacoList" class="chzn-select selectArea 0" name="espaco">
	                                        	  <option value="selecione">Selecione</option>
	                                        	  <c:forEach items="${listaEspaco}" var="item" varStatus="num">
												  	<option value="${item.key}"><c:out value="${item.key}"/></option>
												  </c:forEach>
	                                            </select>
	                                        </div>
                                        </div>
                                        
                                        <div class="control-group" id="divNovoEspaco">
                                        	<label class="control-label" id="novoEspacoLabel">Nome do espa�o:</label>
	                                        <div class="controls" id="divNovoEspaco2">
	                                        	<input type="text" id="novoEspaco" class="input-xlarge focused descricaoArea" name="espaco" autocomplete="off" />
	                                        </div>
                                        </div>
                                        
                                        <div class="control-group">
                                        	<label class="control-label">Descri��o:</label>
	                                        <div class="controls">
	                                        	<input type="text" id="descricao" class="input-xlarge focused descricaoArea" name="descricao" autocomplete="off" />
	                                        </div>
                                        </div>
                                        
                                        <div class="form-actions">
                                        	<input type="button" id="btSubmitEspacos" class="btn btn-primary" value="Salvar" />
                                        </div>
                                      </fieldset>
                                    </form>

                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                        
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Espa�os Cadastrados</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
  									<table class="table" id="listaEspacos">
						              <thead>
						                <tr>
						                  <th>Espa�o</th>
						                  <th>Descri��o</th>
						                  <th>Excluir</th>
						                </tr>
						              </thead>
						              <tbody>
						              	<c:choose>
											<c:when test="${fn:length(espacosCadastrados) gt 0}">
								              	<c:forEach items="${espacosCadastrados}" var="item" varStatus="num">
									                <tr>
									                  <td><c:out value="${item.espaco}"/></td>
									                  <td><c:out value="${item.descricao}"/></td>
									           
									                  <td>
									                  	<a href="#div${item.idEspaco}" data-toggle="modal" class="btn btn-danger btn-delete-bloco">Excluir</a>
									                  	<div id="div${item.idEspaco}" class="modal hide">
																<div class="modal-header">
																	<button data-dismiss="modal" class="close" type="button">�</button>
																	<h3>Exclus�o de espa�o</h3>
																</div>
																	<div class="modal-body">
																		<p>Essa exclus�o apagar� todas as reservas deste espa�o. Deseja prosseguir?</p>
																	</div>
																	<div class="modal-footer">
																		<a  id="aExc" data-dismiss="modal" class="btn excluirEspaco btn-primary" href="#" data-id="<c:out value="${item.idEspaco}"/>">Sim</a>
																		<a data-dismiss="modal" class="btn" href="#">N�o</a>
																	</div>
																</div>
									                  </td>
									                </tr>
									            </c:forEach>	
									        </c:when>
											<c:otherwise>
												<tr>
									                  <td colspan="5"><p class="nenhumResultado">Nenhum espa�o cadastrado</p></td>
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
		<script src="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.js"/>" type="text/javascript"></script>
		
		 <div id="jGrowl" class="top-right jGrowl">
			<div class="jGrowl-notification"></div>
		</div>
		
    </body>	
</html>
