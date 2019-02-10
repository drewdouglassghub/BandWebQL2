<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EditBandServlet" method="post">
		Band: <input type="text" name="bandName" value="${bandToEdit.bandName}">
		Number of Members: <input type="text" name="numMembers" value="${bandToEdit.numMembers}">
		Music Style: <input type="text" name="musicStyle" value="${bandToEdit.musicStyle}">
		<input type="hidden" name="id" value="${bandToEdit.bandId}"> 
		<input type="submit" value="Save Edited Band">
	</form>
</body>
</html>