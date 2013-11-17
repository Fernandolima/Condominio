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
	<script src="<c:url value = "/js/jquery-1.10.2.min.js"/>" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/bootstrap.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/magic-bootstrap.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/bootstrapHealper.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/css/morris.css"/>" />
<head>
<body id="informativoView" class="rede-social">
	<input type="hidden" id="userSessao" value="<c:out value="${usuario.idUser}"></c:out>" />
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
		<div class="row">
			<div class="col-md-3">
				<div class="row" id="sidebar" style="background-color: #57acdd;">
					<div class="col-md-12" id="fotoUsuario">
						<img src="<c:out value="${usuario.imagem}"></c:out>" alt="..." class="img-rounded img-responsive">
					</div>
					
					<ul class="nav nav-pills nav-stacked nav-usuario">
						<li><a href="/WebHomeBeta/home">Home</a></li>
						<li><a href="/WebHomeBeta/home/atas">Atas de Assembléia</a></li>
						<li class="active"><a href="/WebHomeBeta/home/informativo">Anúncios</a></li>
						<li><a href="#">Gastos</a></li>
						<li><a href="/WebHomeBeta/home/listarEspaco">Reserva de espa&ccedil;os</a></li>
						<li><a href="#">Usu&aacute;rios</a></li>
					</ul>
				</div>
			</div>
			
			<div class="col-md-9">
				<input type="hidden" id="idAno" value="${ano}" />
				<div id="topPage">
					<h3>Gastos totais do condomínio</h3>
				</div>
				<fieldset>
				<legend>Ano: <c:out value="${ano}"></c:out></legend>
					<div id="myfirstchart" style="height: 250px;"></div>
				</fieldset>
                
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
	<script src="<c:url value = "/js/raphael-2.1.0.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/morris.min.js"/>" type="text/javascript"></script>
	
	<script> 
		
		var ano = $("#idAno").val();
		var mes = new Array();
		mes[0]="Janeiro";
		mes[1]="Fevereiro";
		mes[2]="Março";
		mes[3]="Abril";
		mes[4]="Maio";
		mes[5]="Junho";
		mes[6]="Julho";
		mes[7]="Agosto";
		mes[8]="Setembro";
		mes[9]="Outubro";
		mes[10]="Novembro";
		mes[11]="Dezembro";	
		
			$.ajax({
		    	type: 'POST',
		      	url:'/WebHomeBeta/home/gastos/grafico',
		      	data: {ano : ano},
		      	success: function(data) {
		      		console.log(data);
		      		new Morris.Line({
		  			  // ID of the element in which to draw the chart.
		  			  element: 'myfirstchart',
		  			  // Chart data records -- each entry in this array corresponds to a point on
		  			  // the chart.
		  			  data: data,
		  			  // The name of the data record attribute that contains x-values.
		  			  xkey: 'data',
		  			  // A list of names of data record attributes that contain y-values.
		  			  ykeys: ['gasto'],
		  			  // Labels for the ykeys -- will be displayed when you hover over the
		  			  // chart.
		  			  labels: ['Gasto'],
		  			  preUnits: ['R$'],
		  			  	
		  			yLabelFormat: function(gasto) {
		  			    return 'R$ ' + gasto; 
		  			  },
		  			  
		  			xLabelFormat: function(d) {
		  				var data = new Date(d);
	  			    	return  mes[data.getMonth() + 1] 
		  			  },
		  			dateFormat: function (x) { 
	  					var d = new Date(x);
	  			    	return  mes[d.getMonth() + 1]  }
		  			});
				},
		      	error: function(e) {
		      		console.log('erro = ', e);
		      	}
		   });
			
 	</script>
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
