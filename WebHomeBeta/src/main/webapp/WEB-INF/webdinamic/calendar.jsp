<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<c:url value = "/css/fullcalendar.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value = "/css/application.css"/>"/>
         <link rel="stylesheet" type="text/css" href="<c:url value = "/css/jquery-ui-1.8.13.custom.css"/>"/>
 		
    </head>
    <body>
        <div id='calendar'></div>
        <div id='eventDialog' class='dialog ui-helper-hidden'>
            <form>
                <div>
                    <label>Title:</label>
                    <input id='title' class="field" type="text"></input>
                </div>
                <div>
                    <label>Color:</label>
                    <input id='color' class="field" type="text"></input>
                </div>
            </form>
        </div>
        <script src="<c:url value = "/js/jquery-1.5.1.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value = "/js/jquery-ui-1.8.13.custom.min.js"/>" type="text/javascript"></script>
 		<script src="<c:url value = "/js/fullcalendar.min.js"/>" type="text/javascript"></script>
 		<script src="<c:url value = "/js/underscore.js"/>" type="text/javascript"></script>
 		<script src="<c:url value = "/js/backbone.js"/>" type="text/javascript"></script>
 		<script src="<c:url value = "/js/application.js"/>" type="text/javascript"></script>
    </body>
</html>