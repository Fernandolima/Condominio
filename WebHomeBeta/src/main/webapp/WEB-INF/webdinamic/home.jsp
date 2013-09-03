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
		<link href="http://fonts.googleapis.com/css?family=Chela+One" rel='stylesheet' type='text/css' />
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value = "/css/admin-home.css"/>"/>
		
		<script src="<c:url value = "/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
	<head>
	<body id="home" class="rede-social">
		<header id="header-site" class="connected">
			<div class="content">
				<h1><a href="index" title="Web Home">Web Home</a></h1>
				<div id="data-user">
					<p class="name-user-connected">Tatiane Jayme Dias<p>
					<span>|</span>
					<a href="#" title="Sair" class="logout-site">Sair</a>
				</div>
			</div>
		</header>
		<section id="contentSite">
			<div id="main-site">			
				<div id="leftCol">
					<div id="user-connected">
						<div id="photo-user">
							<img id="thumb-photo" src="<c:url value = "/img/foto-user.jpg"/>" />
						</div>
						<div id="nav-user">
							<h3>Categoria</h3>
							<ul class="list-nav">
								<li><a href="#">Assembleias</a></li>
								<li><a href="#">Enquetes</a></li>
								<li><a href="#">Gastos</a></li>
								<li><a href="#">Reserva de espa&ccedil;os</a></li>
								<li class="last-link"><a href="#">Usu&aacute;rios</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div id="rightCol">
					<div id="rigth-content">
						<form id="frmComment" method="POST" action="">
							<textarea type="text" name="postUser" id="txtComment" placeholder="Comentário"></textarea>
							<input type="button" id="submitComment" value="comentar" />
						</form>
						<div id="main-comments">
							
							<!-- <div class="post" data-id-user="1234">
								<a href="#" class="deletePost hidden">Excluir</a>
								<img src="img/thumb-post.jpg" class="thumb-post" />
								<div class="comments-post">
									<a href="#" class="name-user-comment">Tatiane Dias</a>
									<p class="time-comments">30/08/2013 - 18:21</p>
									<p class="comment-user">Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. </p>
								</div>
								<a href="#" class="add-comments">>> Comentar</a>
							</div>

							

							<div class="post" data-id-user="1234">
								<img src="img/thumb-post.jpg" class="thumb-post" />
								<div class="comments-post">
									<a href="#" class="name-user-comment">Tatiane Dias</a>
									<p class="time-comments">30/08/2013 - 18:21</p>
									<p class="comment-user">Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.</p>
								</div>
								<div class="comments-holder">
									<div class="comments">
										<img src="img/thumb-post.jpg" class="thumb-post" />
										<a href="#" class="name-user-comment">Tatiane Dias</a>
										<p class="time-comments">30/08/2013 - 18:21</p>
										<p>Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.</p>
									</div>
									<form class="frmCommentPost">
										<input type="text" class="inputComment" placeholder="Comentar" name="comment-post" />
									</form>
								</div>
							</div>



							<div class="post" data-id-user="1234">
								<img src="img/thumb-post.jpg" class="thumb-post" />
								<div class="comments-post">
									<a href="#" class="name-user-comment">Tatiane Dias</a>
									<p class="time-comments">30/08/2013 - 18:21</p>
									<p class="comment-user">Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.

									Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Interagi no mé, cursus quis, vehicula ac nisi. Aenean vel dui dui. Nullam leo erat, aliquet quis tempus a, posuere ut mi. Ut scelerisque neque et turpis posuere pulvinar pellentesque nibh ullamcorper. Pharetra in mattis molestie, volutpat elementum justo. Aenean ut ante turpis. Pellentesque laoreet mé vel lectus scelerisque interdum cursus velit auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ac mauris lectus, non scelerisque augue. Aenean justo massa.
									</p>
								</div>
								<a href="#" class="add-comments">>> Comentar</a>
							</div>-->
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- <footer id="footer-site">
		</footer> -->
		<script src="<c:url value = "/js/jquery.autosize.min.js"/>" type="text/javascript"></script>
		<script>
			$(document).ready(function(){
			    $('textarea').autosize();   
			});
		</script>
		<script src="<c:url value = "/js/comment.js"/>" type="text/javascript"></script>
	</body>
</html>
