<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="/resources/JS/SearchEmpDeptWise.js" />"></script>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include><br><br>
<div class=ViewEmpDeptWise>
  <center>
    <select name="dept" onchange="getvalue(this.value)">
      <option>Select Department Here</option>
      <c:forEach var="d" items="${deptlist}">
       <option value="${d.getId()}">${d.getName()}</option>
      </c:forEach>
    </select>
  </center>
</div>
</body>
</html>