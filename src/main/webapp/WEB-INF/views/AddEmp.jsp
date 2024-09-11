<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/style.css"/>" rel="stylesheet">
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<br><br>
 <div class="addemp">
   <form name="frm" action="saveemp" method="GET">
    <input type="text" name="name" value="" placeholder="Enter department name"/><br><br>
    <input type="submit" value="Submit"/><br><br>
   </form>
   <span>${msg}</span>
 </div>
</body>
</html>