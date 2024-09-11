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
<div class="viewemp" style="margin-left:60px;margin-right: 60px;width: 90%;padding:50px 200px 50px 200px;">
 <table style="width:100%;">
   <tr>
     <td>Sr.No.</td>
     <td>Emp name</td>
     <td>Emp Email</td>
     <td>Emp Contact</td>
     <td>Emp Id</td>
     <td>Department Name</td>
     <td>UPDATE</td>
     <td>DELETE</td>
   </tr>
   <c:forEach var="d" items="${emplist}">
   <tr>
    <td><%=++count%></td>
    <td>${d.getEname()}</td>
    <td>${d.getEmail()}</td>
    <td>${d.getContact()}</td>
    <td>${d.getEid()}</td>
    <td>${d.getName()}</td>
    <td><a href="updemp?eid=${d.getEid()}" style="text-decoration: none;color:black;">Update</a></td>
    <td><a href="delemp?eid=${d.getEid()}" style="text-decoration: none;color:black;">Delete</a></td>
   </tr>
   </c:forEach>
 </table>
 <span>${msg}</span>
</div>
</body>
</html>