<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>

	<head>
		<script type="text/javascript" src="<c:url value = "/js/jquery-1.7.2.js"/>"></script>
		<script type="text/javascript" src="<c:url value = "/js/jquery.atmosphere.js"/>"></script>
		<script type="text/javascript" src="<c:url value = "/js/myjquery.js"/>"></script>
	</head>
	
	<body>
		<h1>Spring MVC and Atmosphere</h1>
		<h2>The Time pushed from the Server is:</h2>
		
		<p id="transport"></p>
		<p id="time"></p>
	</body>

</html>