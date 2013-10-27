<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt_BR">
	<head>
	<meta charset="UTF-8" />
		<title>Web Home - &Aacute;rea Administrativa</title>
		
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap-responsive.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>"/>
		
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/datepicker.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/uniform.default.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/wysiwyg/bootstrap-wysihtml5.css"/>"/>
		
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
                        <li>
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
                                <div class="muted pull-left">Editar Atas</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                	<form:form modelAttribute="editar" class="form-horizontal" action="/WebHomeBeta/admin/updateAtas" method="post" id="frmAtas" enctype="multipart/form-data">
                                      <fieldset>
                                        <legend>Atas</legend>                                        
                                        	<div class="control-group">
                                        		<form:hidden path="idAtas"/>
                                        		
	                                        	<form:label class="control-label" for="tituloAta" path="titulo">Título </form:label>
	                                          	<div class="controls">
	                                          		<form:input type="text" id="tituloAta" path="titulo" autocomplete="off" class="span6 ${(editar.titulo) ? '' : 'error'}" />
	                                            </div>
	                                        </div>
	                                        
	                                    	<div class="control-group">
                                          		<div class="controls">
                                            		<textarea class="input-xlarge textarea ${(editar.atas) ? '' : 'error'}" name="atas" placeholder="Texto da Ata" style="width: 700px; height: 200px">
                                            			<c:out value="${editar.atas}"/>
                                            		</textarea>
                                          		</div>
                                        	</div>
                                        	
                                        	<div class="control-group">
	                                        	<label class="control-label" for="fileInput">Arquivo</label>
	                                          	<div class="controls">
	                                            	<input class="input-file uniform_on" id="fileInput" name="fileData" type="file">
	                                          	</div>
	                                        </div>
	                                        
	                                        <div class="control-group">
                                          		<label class="control-label" for="date01">Data</label>
                                          		<div class="controls">
                                            		<form:input type="text" id="date01" path="dataFormat" autocomplete="off" placeholder="Data da Ata" value=" " class="input-xlarge datepicker ${(bean.dataVal) ? '' : 'error'}" />
                                            	</div>
                                        	</div>
                                        
                                        	<div class="form-actions">
                                          		<input type="submit" class="btn btn-primary" value="Enviar" />
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
		<script src="<c:url value = "/bootstrap/vendors/jquery.uniform.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/vendors/bootstrap-datepicker.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/vendors/wysiwyg/wysihtml5-0.3.0.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/vendors/wysiwyg/bootstrap-wysihtml5.js"/>" type="text/javascript"></script>
		<script src="<c:url value = "/bootstrap/vendors/wizard/jquery.bootstrap.wizard.min.js"/>" type="text/javascript"></script>
		
		
		<script src="<c:url value = "/bootstrap/assets/scripts.js"/>" type="text/javascript"></script>
		<script>
        $(function() {
            $(".datepicker").datepicker();
            $(".uniform_on").uniform();
            $('.textarea').wysihtml5();
		});
        </script>
                        
	</body>	
</html>
