<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="http://fonts.googleapis.com/css?family=Chela+One" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/webstatic/css/style.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value = "/webstatic/css/admin-home.css"/>" />
<title>Insert title here</title>
</head>
<body>

				
							<div id="tabelaBlocos">
								<div class="lineTabelaBlocos">
									<p class="itemBlocos pBloco title">Publicacao:</p>
								</div>
								<c:forEach items="${listPublicacoes}" var="item" varStatus="num">
							    	<div class="lineTabelaBlocos">
										<p class="itemBlocos pBloco"><c:out value="${item.publicacao}"/></p>
											<c:forEach items="${item.comentarios}" var="comments">
											<div>
											     <p class="itemBlocos pBloco"><c:out value="${comments.comentario}"/></p>
											</div>											
										</c:forEach>
									</div>	
							    	
							    </c:forEach>
							</div>
						


	<script src="<c:url value = "/webstatic/js/admin.js"/>" type="text/javascript"></script>
	
	<form:form modelAttribute="publicacaoTO" action="home/publicar">
		<form:label for="nome" path="publicacao">Publicacao:</form:label>
		<form:textarea type="text" id="nome" path="publicacao" rows="20"
			cols="50" />
		<input type="submit" id="btSubmitRegister" class="btSubmit"
			value="Enviar" />
	</form:form>
	
	<form:form modelAttribute="publicacaoTO" action="home/comentar">
		<form:label for="nome" path="publicacao">Publicacao:</form:label>
		<form:textarea type="text" id="nome" path="publicacao" rows="20"
			cols="50" />
		<input type="submit" id="btSubmitRegister" class="btSubmit"
			value="Enviar" />
	</form:form>
</body>
</html>