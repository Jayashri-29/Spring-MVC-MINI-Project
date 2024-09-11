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
    <form name="frm" action="editdept" method="GET">
      <c:forEach var="d" items="${dept}">
        <input type="hidden" name="id" value="${d.getId()}"/><br><br>
        <input type="text" name="name" value="${d.getName()}"/><br><br>
        <input type="submit" value="Edit Dept"/><br><br>
      </c:forEach>
     </form>
     <span>${msg}</span>
   </div>
</body>
</html>