<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Upload Example</title>
<script src="<c:url value = "/js/jquery-1.7.2.min.js"/>" type="text/javascript"></script>
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
</head>
<body>
	<div id="main-upload">
		<label>select a file to upload</label>
		<form enctype="multipart/form-data">
			<input id="instanceValue" multiple="true" name="file" type="file">
			<input type="button" id="btn-upload" value="Upload">
		</form>
		<progress></progress>
	</div>
	
	<form:form modelAttribute="uploadControllerBean"
		action="uploadImage/upload" name="frm" method="post"
		enctype="multipart/form-data" onSubmit="return Validate();">
		<fieldset>
			<legend>Upload File</legend>
			<table>
				<tr>
					<td><form:label for="fileData" path="fileData">File</form:label><br />
					</td>
					<td><form:input path="fileData" id="image" type="file" /></td>
				</tr>
				<tr>
					<td><br /></td>
					<td><input type="submit" value="Upload" /></td>
				</tr>
			</table>
		</fieldset>
	</form:form>
	<script type="text/javascript" src="<c:url value = "/js/upload.js"/>"></script>
</body>
</html>