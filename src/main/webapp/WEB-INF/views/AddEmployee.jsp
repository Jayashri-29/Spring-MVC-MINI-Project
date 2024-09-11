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
<jsp:include page="index.jsp"></jsp:include><br><br>
<div class="regemp">
  <form name="frm" action="registeremp" method="GET">
    <input type="text" name="ename" value="" placeholder="Enter name here"/><br><br>
     <input type="text" name="email" value="" placeholder="Enter email here"/><br><br>
      <input type="text" name="contact" value="" placeholder="Enter contact here"/><br><br>
      <select name="id">
        <option>Select department</option>
        <c:forEach var="d" items="${deptList}">
          <option value="${d.getId()}">${d.getName()}</option>
        </c:forEach>
      </select><br><br>
      <input type="submit" value="Submit here"/>
  </form>
  <span>${msg}</span>
</div>
</body>
</html>