<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:include page="index.jsp"></jsp:include><br><br>
 <div class="editemp">
  <form name="frm" action="editemp" method="GET">
   <c:forEach var="e" items="${emplist}">
    <input type="hidden" name="eid" value="${e.getEid()}"/><br><br>
    <input type="text" name="ename" value="${e.getEname()}"/><br><br>
    <input type="text" name="email" value="${e.getEmail()}"/><br><br>
    <input type="text" name="contact" value="${e.getContact()}"/><br><br>
    <select name="id">
        <option>Select department</option>
        <c:forEach var="d" items="${deptList}">
          <option value="${d.getId()}">${d.getName()}</option>
        </c:forEach>
      </select><br><br>
   </c:forEach>  
   <input type="submit" value='Submit'/>
  </form> 
  <span>${msg}</span>
 </div>
</body>
</html>