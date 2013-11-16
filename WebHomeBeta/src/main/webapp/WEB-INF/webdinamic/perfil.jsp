<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt_BR">	
<head>
	<meta charset="UTF-8" />
	<title>Web Home - &Aacute;rea Administrativa - Validar Cadastro</title>
	 <script src="<c:url value = "/bootstrap/vendors/jquery-1.9.1.min.js"/>" type="text/javascript"></script>	
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/bootstrap.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/magic-bootstrap.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/bootstrapHealper.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/css/jquery.modal.css"/>"/>
	<link rel="stylesheet" href="<c:url value = "/css/jquery.Jcrop.min.css"/>"/>

		
		<script type="text/javascript">
			function Validate() {
				var image = document.getElementById("image").value;
				if (image != '') {
					var checkimg = image.toLowerCase();
					if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
						alert("Please enter Image File Extensions .jpg,.png,.jpeg");
						document.getElementById("image").focus();
						return false;
					}
				}
				return true;
			}
		</script>
<head>
<body id="home" class="rede-social">
	<input type="hidden" id="userSessao" value="<c:out value="${moradorControllerBean.usuario.idUser}"></c:out>" />
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
						<img src="<c:out value="${moradorControllerBean.usuario.imagem}"></c:out>" alt="..." class="img-rounded img-responsive">
					</div>
					
					<ul class="nav nav-pills nav-stacked nav-usuario">
						<li><a href="/WebHomeBeta/home">Home</a></li>
						<li><a href="/WebHomeBeta/home/atas">Atas de Assembléia</a></li>
						<li><a href="/WebHomeBeta/home/informativo">Anúncios</a></li>
						<li><a href="#">Gastos</a></li>
						<li><a href="/WebHomeBeta/home/listarEspaco">Reserva de espa&ccedil;os</a></li>
						<li><a href="#">Usu&aacute;rios</a></li>
					</ul>
				</div>
			</div>
			
			<div class="col-md-9">
			
				<!-- Modal HTML embedded directly into document -->
			  	<div id="editarFoto" style="display:none;">
			  		<div id="container-foto">
			  			<img src="img/load-login.gif" id="loadFoto" alt="carregando foto"/> 
			  		</div>
			  		<a href="#" id="cortarImagem" style="display: none">OK</a>
			  	</div>
  	
				<h3 class="text-primary"><b>Perfil</b></h3><br/>
				
				<form:form role="form" modelAttribute="uploadControllerBean" id="trocarFoto" class="form-group" action="/WebHomeBeta/perfil/upload" name="frm" method="post" enctype="multipart/form-data" onSubmit="return Validate();">
					<label for="image" class="inputFile">Alterar foto</label>
					<form:input path="fileData" id="image" type="file" style="display:none;" onchange="EDITAR_PERFIL.alterarFoto(this)" />
				</form:form>
				
				<div class="panel-group" id="accordion">
  
  					<div class="panel panel-default">
    					<div class="panel-heading">
      						<h4 class="panel-title">
      							<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
      								<span class="glyphicon glyphicon-user"></span> <b>Atualizar dados pessoais</b>
      							</a>
      						</h4>
    					</div>
    					<div id="collapseOne" class="panel-collapse collapse in">
      						<div class="panel-body">
        						<form role="form">
  									<div class="form-group">
    									<label for="exampleInputEmail1">Nome</label>
    									<input type="email" class="form-control" id="exampleInputEmail1" value="Tatiane Jayme Dias">
  									</div>
  									<fieldset disabled>
								    	<div class="form-group">
								      		<label for="disabledTextInput">E-mail</label>
								      		<input type="text" id="disabledTextInput" class="form-control" placeholder="tatianejayme@gmail.com">
								    	</div>
								    </fieldset>
								    <div class="form-group">
    									<label for="dataNascimento">Data de Nascimento</label>
    									<input type="text" class="form-control" id="dataNascimento" value="16/10/1985">
  									</div>
  									<div class="form-group">
    									<label for="dataNascimento">Estado Civil</label>
	  									<select class="form-control">
	  										<option value=""></option>
										  	<option value="solteiro">Solteiro</option>
										  	<option value="casado">Casado</option>
										  	<option value="viuvo">Viuvo</option>
										</select>
									</div>
  									<button type="submit" class="btn btn-primary">Enviar</button>
								</form>
      						</div>
    					</div>
  					</div>
  
  					<div class="panel panel-default">
    					<div class="panel-heading">
      						<h4 class="panel-title">
      							<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
      								<span class="glyphicon glyphicon-lock"></span> <b>Alterar Senha</b>
      							</a>
      						</h4>
   						</div>
    					<div id="collapseTwo" class="panel-collapse collapse">
      						<div class="panel-body">
	      						<form role="form" action="" method="POST">
  									<div class="form-group">
    									<label for="senhaAtual">Senha atual:</label>
    									<input type="password" class="form-control" id="senhaAtual">
  									</div>
  									<div class="form-group">
    									<label for="novaSenha">Nova senha:</label>
    									<input type="password" class="form-control" id="novaSenha">
  									</div>
  									<div class="form-group">
    									<label for="confNovaSenha">Confirmar nova senha:</label>
    									<input type="password" class="form-control" id="confNovaSenha">
  									</div>
  									<button type="submit" class="btn btn-primary">Alterar Senha</button>
  								</form>        						
      						</div>
    					</div>
  					</div>
  					
  					<div class="panel panel-default">
    					<div class="panel-heading">
      						<h4 class="panel-title">
        						<a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
        							<span class="glyphicon glyphicon-edit"></span> <b>Curiosidades</b>
        						</a>
      						</h4>
    					</div>
    					<div id="collapseThree" class="panel-collapse collapse">
      						<div class="panel-body">
        						<form role="form" action="" method="POST">
  									<div class="form-group">
    									<label for="filmesFavoritos">Filmes favoritos:</label>
    									<input type="text" class="form-control" id="filmesFavoritos">
  									</div>
  									<div class="form-group">
    									<label for="musicasFavoritas">Músicas favoritas:</label>
    									<input type="text" class="form-control" id="musicasFavoritas">
  									</div>
  									<div class="form-group">
    									<label for="pensamento">Pensamento:</label>
    									<input type="text" class="form-control" id="pensamento">
  									</div>
  									<button type="submit" class="btn btn-primary">Salvar</button>
  								</form>   
     						 </div>
    					</div>
  					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- <footer id="footer-site">
		</footer> -->

	<script src="<c:url value = "/bootstrap/dist/js/bootstrap.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/jquery.maskMoney.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/assets/scripts.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/jquery.maskedinput-1.3.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/jquery.form.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/jquery.modal.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/jquery.Jcrop.min.js"/>" type="text/javascript"></script>
	
	<script src="<c:url value = "/js/comment.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/editar.js"/>" type="text/javascript"></script>
	<script type="text/javascript">
		$('#sidebar').affix({
			offset : {
				top : $('header').height()
			}
		});
		
	</script>
	<script>
        	$('#dataNascimento').val('');
        	$('#dataNascimento').mask('9999');
        	
        	
        </script>
</body>
</html>
