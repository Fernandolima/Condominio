<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt_BR">
<head>
<meta charset="UTF-8" />
<title>Web Home - &Aacute;rea Administrativa - Validar Cadastro</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/bootstrap/dist/css/bootstrap.min.css"/>" />
	<link rel="stylesheet" type="text/css"
	href="<c:url value = "/bootstrap/dist/css/magic-bootstrap.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/bootstrap/dist/css/bootstrapHealper.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/bootstrap/assets/styles.css"/>" />

<script src="<c:url value = "/js/jquery-1.10.2.min.js"/>"
	type="text/javascript"></script>
<head>
<body id="home" class="rede-social">
	<input type="hidden" id="userSessao"
		value="<c:out value="${moradorControllerBean.usuario.idUser}"></c:out>" />
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Dropdown <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Dropdown <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
	

	<!-- Begin Body -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				
			
				<!-- SideBar azul -->
				<div class="row" id="sidebar" style="background-color: #57acdd;">
					
						<div class="col-md-12">
							<img src="/WebHomeBeta/img/anonimos.jpg" alt="..." class="img-rounded img-responsive">
						</div>
	
					<div class="list-group col-md-12">
                 		 <a href="#" class="list-group-item">
                  			  Link 1
                  		 </a>
		                  <a href="#" class="list-group-item">Responsive
		                  </a>
		                  <a href="#" class="list-group-item">Mobile First
		                  </a>
		                  <a href="#" class="list-group-item">CSS 3
		                  </a>
		                  <a href="#" class="list-group-item">HTML 5
                  	  	 </a>
                      </div>
				</div>
				
				<!-- SideBar azul -->
	
			</div>
			<div class="col-md-6">
				<h2>Content</h2>
				Totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et
				quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
				voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia
				cor magni dolores eos qui ratione voluptatem sequi nesciunt. Neque
				porro quisquam est, qui dolorem ipsum quia dolor sit amet,
				consectetur, adipisci velit, sed quia non numquam eius modi tempora
				incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut
				enim ad minima veniam, quis nostrum exercitationem ullam corporis
				suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?

				<hr>

				<h2>Content</h2>
				Rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
				architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
				voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia
				cor magni dolores eos qui ratione voluptatem sequi nesciunt. Neque
				porro quisquam est, qui dolorem ipsum quia dolor sit amet,
				consectetur, adipisci velit, sed quia non numquam eius modi tempora
				incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut
				enim ad minima veniam, quis nostrum exercitationem ullam corporis
				suscipit laboriosam, nisi ut

				<hr>

				<h2>Content</h2>
				Rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
				architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
				voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia
				cor magni dolores eos qui ratione voluptatem sequi nesciunt. Neque
				porro quisquam est, qui dolorem ipsum quia dolor sit amet,
				consectetur, adipisci velit, sed quia non numquam eius modi tempora
				incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut
				enim ad minima veniam, quis nostrum exercitationem ullam corporis
				suscipit laboriosam, nisi ut

				<hr>

				<h2>Content</h2>
				Sed ut perspiciatis unde omnis iste natus error sit voluptatem
				accusantium doloremque laudantium, totam rem aperiam, eaque ipsa
				quae ab illo inventore veritatis et quasi architecto beatae vitae
				dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
				aspernatur aut odit aut fugit, sed quia cor magni dolores eos qui
				ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui
				dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed
				quia non numquam eius modi tempora incidunt ut labore et dolore
				magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis
				nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut

				<h2>Content</h2>
				Sed ut perspiciatis unde omnis iste natus error sit voluptatem
				accusantium doloremque laudantium, totam rem aperiam, eaque ipsa
				quae ab illo inventore veritatis et quasi architecto beatae vitae
				dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
				aspernatur aut odit aut fugit, sed quia cor magni dolores eos qui
				ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui
				dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed
				quia non numquam eius modi tempora incidunt ut labore et dolore
				magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis
				nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut


				<hr>
					<h4>
						<a href="http://bootply.com/73864">Edit on Bootply</a>
					</h4>
				<hr>


			</div>
			
			<div class="col-md-3">
			
			<h2>Content</h2>
				Rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
				architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
				voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia
				cor magni dolores eos qui ratione voluptatem sequi nesciunt. Neque
				porro quisquam est, qui dolorem ipsum quia dolor sit amet,
				consectetur, adipisci velit, sed quia non numquam eius modi tempora
				incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut
				enim ad minima veniam, quis nostrum exercitationem ullam corporis
				suscipit laboriosam, nisi ut

				<hr>

				<h2>Content</h2>
				Sed ut perspiciatis unde omnis iste natus error sit voluptatem
				accusantium doloremque laudantium, totam rem aperiam, eaque ipsa
				quae ab illo inventore veritatis et quasi architecto beatae vitae
				dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
				aspernatur aut odit aut fugit, sed quia cor magni dolores eos qui
				ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui
				dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed
				quia non numquam eius modi tempora incidunt ut labore et dolore
				magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis
				nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut
			</div>
			
		</div>
	</div>
	<!-- <footer id="footer-site">
		</footer> -->

	<script src="<c:url value = "/bootstrap/vendors/jquery-1.9.1.min.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/dist/js/bootstrap.min.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/assets/scripts.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.js"/>"
		type="text/javascript"></script>
		
	<!-- Static -->
	<script type="text/javascript">
		$('#sidebar').affix({
			offset : {
				top : $('header').height()
			}
		});
	</script>
	
	<!-- Static -->
	<script src="<c:url value = "/js/admin.js"/>" type="text/javascript"></script>
</body>
</html>
