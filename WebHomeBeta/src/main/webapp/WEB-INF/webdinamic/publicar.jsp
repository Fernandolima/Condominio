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
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${listaPublicacao}" var="item">
		<tr>
			<td class="Publicacao: ">Publicacao: <c:out value="${item.publicacao}" /></td>
		</tr>
	</c:forEach>

	<form:form modelAttribute="publicacaoTO" action="salvarPublicacao">
		<form:label for="nome" path="publicacao">Publicacao:</form:label>
		<form:textarea type="text" id="nome" path="publicacao" rows="20"
			cols="50" />
		<input type="submit" id="btSubmitRegister" class="btSubmit"
			value="Enviar" />
	</form:form>
</body>
</html>