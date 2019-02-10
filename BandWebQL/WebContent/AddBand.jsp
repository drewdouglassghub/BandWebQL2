<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddBandServlet" method="post">
		Band Name: <input type="text" name="bandName"> 
		Number of Members: <input type="text" name="numMembers"> 
		Style of Music: <input type="text" name="musicStyle">
		<input type="hidden" name="id" value="${bandToEdit.bandId}"> 
		<input type="submit" value="Add Band">
	</form>
</body>
</html>