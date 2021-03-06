<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
<meta charset="UTF-8" />
<title>Web Home - &Aacute;rea Administrativa</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value = "/bootstrap/css/bootstrap.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/bootstrap/css/bootstrap-responsive.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/bootstrap/assets/styles.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/admin-home.css"/>" />

<script src="<c:url value = "/js/jquery-1.10.2.min.js"/>"
	type="text/javascript"></script>
</head>

<body id="adminView">

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="/WebHomeBeta/admin">Web Home - �rea
					Administrativa</a>
				<div class="nav-collapse collapse">
					<ul class="nav pull-right">
						<li class="dropdown"><a href="#" role="button"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="icon-user"></i> <c:out value="${usuario.nome}" /> <i
								class="caret"></i>

						</a>
							<ul class="dropdown-menu">
								<li><a tabindex="-1" href="/WebHomeBeta/logout">Logout</a>
								</li>
							</ul></li>
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
						<li class="active"><a href="/WebHomeBeta/admin"><i
								class="icon-chevron-right"></i>P�gina Principal</a></li>
						<li><a href="/WebHomeBeta/admin/listaAtas"><i
								class="icon-chevron-right"></i> Listar Atas</a></li>
						<li><a href="/WebHomeBeta/admin/atas"><i
								class="icon-chevron-right"></i> Cadastrar Atas</a></li>
						<li><a href="/WebHomeBeta/admin/cadastrarBlocos"><i
								class="icon-chevron-right"></i> Cadastrar Blocos</a></li>
						<li><a href="/WebHomeBeta/admin/listarEspaco"><i
								class="icon-chevron-right"></i> Listar Espa�os</a></li>
						<li><a href="/WebHomeBeta/admin/espaco"><i
								class="icon-chevron-right"></i> Cadastrar Espa�os</a></li>
						<li><a href="/WebHomeBeta/admin/listaEnquetes"><i
								class="icon-chevron-right"></i> Listar Enquetes</a></li>
						<li><a href="/WebHomeBeta/admin/enquetes"><i
								class="icon-chevron-right"></i> Cadastrar Enquetes</a></li>
						<li><a href="/WebHomeBeta/admin/validarMoradores"><i
								class="icon-chevron-right"></i>Validar Moradores</a></li>
						<li><a href="/WebHomeBeta/admin/reservas"><i
								class="icon-chevron-right"></i>Validar Reservas</a></li>
						<li><a href="/WebHomeBeta/admin/mural"><i
								class="icon-chevron-right"></i>Mural</a></li>
						<li><a href="/WebHomeBeta/admin/gasto"><i
								class="icon-chevron-right"></i>Gasto</a></li>
						<li><a href="/WebHomeBeta/home"><i
								class="icon-chevron-right"></i>Web Home</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_FUNC')">
						<li class="active"><a href="/WebHomeBeta/admin/visitantes"><i
								class="icon-chevron-right "></i>Visitantes</a></li>
						<li><a href="/WebHomeBeta/admin/visitantes/cadastro"><i
								class="icon-chevron-right "></i>Cadastrar Visitantes</a></li>
					</sec:authorize>
				</ul>
			</div>

			<!--/span-->
			<div class="span9" id="content">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<div class="alert alert-info">
						<button class="close" data-dismiss="alert">&times;</button>
						<strong>Info!</strong> Voc� possui <b><c:out
								value="${validarMoradores}"></c:out></b> cadastros para serem
						aprovados. <a href="admin/validarMoradores">Clique aqui para
							moderar</a>
					</div>
					<div class="alert alert-info">
						<button class="close" data-dismiss="alert">&times;</button>
						<strong>Info!</strong> Voc� possui <b><c:out
								value="${reservas}"></c:out></b> reservas para serem
						aprovadas. <a href="admin/reservas">Clique aqui para
							moderar</a>
					</div>

					<div class="row-fluid">
						<!-- block -->
						<c:forEach items="${enquetes}" var="enquete">
							<div class="block">
								<div class="navbar navbar-inner block-header">
									<div class="muted pull-left">Enquetes ativas</div>
									<div class="pull-right">
										<a href="/WebHomeBeta/admin/listaEnquetes" title="Ver mais"><span
											class="badge badge-warning">Ver mais</span></a>
									</div>
								</div>

								<div class="block-content collapse in">
									<div class="list-enquete">
										<p class="perguntaEnquete">
											<b>Enquete Ativa:</b> ${enquete.enquete}
										</p>
										<div class="block-content collapse in enquetes">
											<c:forEach items="${enquete.opcoes}" var="opcao">
												<div class="span3">
													<div class="chart"
														data-percent="<c:out value="${opcao.porcentagemVotos}"></c:out>">${opcao.porcentagemVotos}%</div>
													<div class="chart-bottom-heading">
														<span class="label label-info">${opcao.opcao}</span>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_FUNC')">
					<div class="row-fluid">
						<!-- block -->
						<div class="block">
							<div class="navbar navbar-inner block-header">
								<div class="muted pull-left">Visitantes Cadastrados</div>
							</div>
							<div class="block-content collapse in">
								<div class="span12">
									<table class="table">
										<thead>
											<tr>
												<th>Nome do Visitante</th>
												<th>Placa do autom�vel</th>
												<th>Registro Geral (RG)</th>
												<th>Apartamento</th>
												<th>Bloco</th>
												<th>Data</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listaVisitantes}" var="item">
												<tr>
													<td><c:out value="${item.nomeVisitante}" /></td>
													<td><c:out value="${item.placaDoCarro}" /></td>
													<td><c:out value="${item.rg}" /></td>
													<td><c:out value="${item.ap}" /></td>
													<td><c:out value="${item.bloco}" /></td>
													<td><c:out value="${item.data}" /></td>
													<td><a
														href="/WebHomeBeta/admin/visitante/delete/id=<c:out value="${item.idVisitante}"/>"
														class="btn btn-default">Excluir</a></td>

												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!-- /block -->
					</div>
				</sec:authorize>
			</div>
		</div>
		<hr>
		<footer>
			<p>&copy; Web Home</p>
		</footer>
	</div>
	<!--/.fluid-container-->

	<script src="<c:url value = "/bootstrap/vendors/jquery-1.9.1.min.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/js/bootstrap.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/assets/scripts.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.js"/>"
		type="text/javascript"></script>

	<script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>

	<script>
		$(function() {
			// Easy pie charts
			$('.chart').easyPieChart({
				animate : 1000
			});
		});
	</script>

	<div id="jGrowl" class="top-right jGrowl">
		<div class="jGrowl-notification"></div>
	</div>
</body>
</html>
