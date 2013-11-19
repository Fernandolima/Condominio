<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt_BR">	
<head>
	<meta charset="UTF-8" />
	<title>Web Home</title>
	 <script src="<c:url value = "/bootstrap/vendors/jquery-1.9.1.min.js"/>" type="text/javascript"></script>	
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/bootstrap.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/magic-bootstrap.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/dist/css/bootstrapHealper.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/assets/styles.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.css"/>" />
	<link rel="stylesheet" href="<c:url value = "/css/jquery.Jcrop.min.css"/>"/>
	
	<script src="<c:url value = "/js/jquery.form.js"/>" type="text/javascript"></script>
		
	<script src="<c:url value = "/js/jquery.Jcrop.min.js"/>" type="text/javascript"></script>
	
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
<body id="perfilView" class="rede-social">

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
		
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				 <div class="modal-content">
				 	<button type="button" class="close" data-dismiss="modal">x</button>
				 	<div class="modal-body">
	  					<div id="container-foto">
				  			<img src="img/load-login.gif" id="loadFoto" alt="carregando foto"/> 
				  		</div>
					</div>
					<div class="modal-footer">
						<a href="#" id="cortarImagem" style="display: none">OK</a>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
				
		<div class="row">
			<div class="col-md-3">
				<div class="row" id="sidebar" style="background-color: #57acdd;">
					<div class="col-md-12" id="fotoUsuario">
						<img src="<c:out value="${usuario.imagem}"></c:out>" alt="..." class="img-rounded img-responsive">
					</div>
					
					<ul class="nav nav-pills nav-stacked nav-usuario">
						<li><a href="/WebHomeBeta/home">Home</a></li>
						<li><a href="/WebHomeBeta/home/atas">Atas de Assembléia</a></li>
						<li><a href="/WebHomeBeta/home/informativo">Anúncios</a></li>
						<li><a href="/WebHomeBeta/home/gastos">Gastos</a></li>
						<li><a href="/WebHomeBeta/home/listarEspaco">Reserva de espa&ccedil;os</a></li>
						<li><a href="/WebHomeBeta/home/mural">Mural</a></li>
					</ul>
				</div>
			</div>
			
			<div class="col-md-9">
				<!-- Modal HTML embedded directly into document 
			  	<div id="editarFoto" style="display:none;">
			  		<div id="container-foto">
			  			<img src="img/load-login.gif" id="loadFoto" alt="carregando foto"/> 
			  		</div>
			  		<a href="#" id="cortarImagem" style="display: none">OK</a>
			  	</div>-->
				<form:form role="form" modelAttribute="uploadControllerBean" id="trocarFoto" class="form-group" action="/WebHomeBeta/perfil/upload" name="frm" method="post" enctype="multipart/form-data" onSubmit="return Validate();">
					<label for="image" class="inputFile btn btn-warning btn-sm">Alterar foto</label>
					<form:input path="fileData" id="image" type="file" style="display:none;" onchange="EDITAR_PERFIL.alterarFoto(this)" />
				</form:form>
				
				<h3 class="text-primary"><b>Perfil</b></h3>
				
				<div class="panel-group" id="accordion">
  
  					<div class="panel panel-default">
    					<div class="panel-heading">
      						<h4 class="panel-title">
      							<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
      								<span class="glyphicon glyphicon-user"></span> <b>Dados Pessoais</b>
      							</a>
      						</h4>
    					</div>
    					<div id="collapseOne" class="panel-collapse collapse in">
      						<div class="panel-body">
        						<form role="form">
        							<fieldset disabled>
	  									<div class="form-group">
	    									<label for="exampleInputEmail1">Nome</label>
	    									<input type="text" id="disabledTextInput" class="form-control" placeholder="${usuario.nome}">
	  									</div>
	  								
								    	<div class="form-group">
								      		<label for="disabledTextInput">E-mail</label>
								      		<input type="text" id="disabledTextInput" class="form-control" placeholder="${usuario.email}">
								    	</div>
									    <div class="form-group">
	    									<label for="dataNascimento">Data de Nascimento</label>
	    									<input type="text" id="disabledTextInput" class="form-control" placeholder="${usuario.dt_nascimento}">
	  									</div>
	  								</fieldset>
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
	      						<form role="form" action="#" method="POST" id="frmAlterarSenha">
  									<div class="form-group">
    									<label for="senhaAtual">Senha atual:</label>
    									<input type="password" class="form-control" id="senhaAtual" name="senha">
  									</div>
  									<div class="form-group">
    									<label for="novaSenha">Nova senha:</label>
    									<input type="password" class="form-control" id="novaSenha" name="novaSenha">
  									</div>
  									<div class="form-group">
    									<label for="confNovaSenha">Confirmar nova senha:</label>
    									<input type="password" class="form-control" id="confNovaSenha" name="confNovaSenha">
  									</div>
  									<button type="submit" class="btn btn-primary alterarSenha">Alterar Senha</button>
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
        						<form:form role="form" modelAttribute="perfilControllerBean" action="/WebHomeBeta/perfil/salvar" method="POST">
  									<div class="form-group">
    									<form:label for="filmeFavorito" path="perfilTO.filme">Filme favorito:</form:label>
    									<form:input type="text" class="form-control" id="filmeFavorito" path="perfilTO.filme"></form:input>
  									</div>
  									<div class="form-group">
    									<form:label for="filmeFavorito" path="perfilTO.livros">Livro favorito:</form:label>
    									<form:input type="text" class="form-control" id="livroFavorito" path="perfilTO.livros"></form:input>
  									</div>
  									<div class="form-group">
    									<form:label for="musicaFavorita" path="perfilTO.estilosMusicais">Música favorita:</form:label>
    									<form:input type="text" class="form-control" id="musicaFavorita" path="perfilTO.estilosMusicais"></form:input>
  									</div>
  									<div class="form-group">
    									<form:label for="sobreMim" path="perfilTO.sobreMim">Sobre mim:</form:label>
    									<form:input type="text" class="form-control" id="sobreMim" path="perfilTO.sobreMim"></form:input>
  									</div>
  									<div class="form-group">
    									<form:label for="idade" path="perfilTO.idade">Idade:</form:label>
    									<form:input type="text" class="form-control" id="idade" path="perfilTO.idade"></form:input>
  									</div>
  									<div class="form-group">
    									<form:label for="profissao" path="perfilTO.profissao">Profissão:</form:label>
    									<form:input type="text" class="form-control" id="profissao" path="perfilTO.profissao"></form:input>
  									</div>
  									<button type="submit" class="btn btn-primary">Salvar</button>
  								</form:form>   
     						 </div>
    					</div>
  					</div>  					
				</div>
			</div>
			
		</div>
	</div>
	

	<script src="<c:url value = "/bootstrap/dist/js/bootstrap.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/vendors/easypiechart/jquery.easy-pie-chart.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/jquery.maskMoney.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/assets/scripts.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/bootstrap/vendors/jGrowl/jquery.jgrowl.js"/>" type="text/javascript"></script>
	<script src="<c:url value = "/js/jquery.maskedinput-1.3.min.js"/>" type="text/javascript"></script>
	
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
        
        <div id="jGrowl" class="center jGrowl">
		<div class="jGrowl-notification"></div>
	</div>
</body>
</html>
