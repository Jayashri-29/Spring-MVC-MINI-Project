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
<%
int count=0;
%>
  <div class="viewdept">
   <table>
    <tr>
      <th>Sr. No.</th>
      <th>Dept Id</th>
      <th>Dept Name</th>
      <th>Update</th>
      <th>Delete</th>
    </tr>
    <c:forEach var="d" items="${deptList}">
     <tr>
       <td><%=++count%></td>
       <td>${d.getId()}</td>
       <td>${d.getName()}</td>
       <td><a href="upddept?deptid=${d.getId()}" style="text-decoration: none;color: black;">Update</a></td>
       <td><a href="deldept?deptid=${d.getId()}" style="text-decoration: none;color: black;">Delete</a></td>
     </tr>
    </c:forEach>
   </table>
  <span>${msg}</span>
  </div>
</body>
</html>