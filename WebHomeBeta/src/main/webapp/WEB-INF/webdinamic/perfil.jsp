<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>jQuery File Upload Example</title>
 
<script src="<c:url value = "/js/jquery.1.9.1.min.js"/>" type="text/javascript"></script>
 
<!-- bootstrap just to have good looking page -->

<link rel="stylesheet" type="text/css" href="<c:url value = "/bootstrap/css/bootstrap.css"/>"/>
 
<!-- we code these -->
<link rel="stylesheet" type="text/css" href="<c:url value = "/css/dropzone.css"/>"/>

</head>
 
<body>
<h1>Spring MVC - jQuery File Upload</h1>
<div style="width:500px;padding:20px">

	<input id="fileupload" type="file" name="files[]" data-url="perfil/upload" multiple>
	
	<div id="dropzone" class="fade well">Drop files here</div>
	
	<div id="progress" class="progress">
    	<div class="bar" style="width: 0%;"></div>
	</div>

	<table id="uploaded-files" class="table">
		<tr>
			<th>File Name</th>
			<th>File Size</th>
			<th>File Type</th>
			<th>Download</th>
		</tr>
	</table>
	
</div>
<script src="<c:url value = "/js/jquery.ui.widget.js"/>" type="text/javascript"></script>
<script src="<c:url value = "/js/jquery.iframe-transport.js"/>" type="text/javascript"></script>
<script src="<c:url value = "/js/jquery.fileupload.js"/>" type="text/javascript"></script>
<script src="<c:url value = "/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value = "/js/myuploadfunction.js"/>" type="text/javascript"></script>
</body> 
</html>