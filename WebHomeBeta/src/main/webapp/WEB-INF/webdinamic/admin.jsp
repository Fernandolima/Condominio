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
                    <a class="brand" href="/WebHomeBeta/admin">Web Home - �rea Administrativa</a>
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
                        <li class="active">
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
                            <a href="/WebHomeBeta/espaco"><i class="icon-chevron-right"></i> Cadastrar Espa�os</a>
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
                	
                	<div class="alert alert-info">
						<button class="close" data-dismiss="alert">&times;</button>
						<strong>Info!</strong> Voc� possui <b><c:out value="${validarMoradores}"></c:out></b> cadastros para serem aprovados. <a href="admin/validarMoradores">Clique aqui para moderar</a>
					</div>
					
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Enquetes ativas</div>
                                <div class="pull-right"><a href="/WebHomeBeta/admin/listaEnquetes" title="Ver mais"><span class="badge badge-warning">Ver mais</span></a>

                                </div>
                            </div>
                            <div class="list-enquete">
                            	<p class="perguntaEnquete"><b>Enquete Ativa:</b> Aqui fica a pergunta da enquete</p>
	                            <div class="block-content collapse in enquetes">
	                            	<div class="span3">
	                                    <div class="chart" data-percent="100">100%</div>
	                                    <div class="chart-bottom-heading"><span class="label label-info">�timo</span>
	
	                                    </div>
	                                </div>
	                                <div class="span3">
	                                    <div class="chart" data-percent="53">53%</div>
	                                    <div class="chart-bottom-heading"><span class="label label-info">Bom</span>
	
	                                    </div>
	                                </div>
	                                <div class="span3">
	                                    <div class="chart" data-percent="83">83%</div>
	                                    <div class="chart-bottom-heading"><span class="label label-info">Ruim</span>
	
	                                    </div>
	                                </div>
	                            </div>
	                    	</div>
	                    	
	                    	<div class="list-enquete">
                            	<p class="perguntaEnquete"><b>Enquete Ativa:</b> Aqui fica a pergunta da enquete</p>
	                            <div class="block-content collapse in enquetes">
	                            	<div class="span3">
	                                    <div class="chart" data-percent="73">73%</div>
	                                    <div class="chart-bottom-heading"><span class="label label-info">�timo</span>
	
	                                    </div>
	                                </div>
	                                <div class="span3">
	                                    <div class="chart" data-percent="53">53%</div>
	                                    <div class="chart-bottom-heading"><span class="label label-info">Bom</span>
	
	                                    </div>
	                                </div>
	                                <div class="span3">
	                                    <div class="chart" data-percent="83">83%</div>
	                                    <div class="chart-bottom-heading"><span class="label label-info">Ruim</span>
	
	                                    </div>
	                                </div>
	                                <div class="span3">
	                                    <div class="chart" data-percent="13">13%</div>
	                                    <div class="chart-bottom-heading"><span class="label label-info">P�ssimo</span>
	
	                                    </div>
	                                </div>
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
		<script src="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.js"/>" type="text/javascript"></script>
        <script src="<c:url value = "/bootstrap/assets/scripts.js"/>" type="text/javascript"></script>
        
        <script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
        
        <script>
        $(function() {
            // Easy pie charts
            $('.chart').easyPieChart({animate: 1000});
        });
        </script>
        
	</body>	
</html>
</html>
