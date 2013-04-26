<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<tr> Paises vindos da logica </tr>
<table border="1">
<c:forEach items="${stringList}" var="tarefa" varStatus="i">
    <tr bgcolor="${i.count % 2 == 0 ? '#FF7F50' : '#F0F0F0'}">
     <td>${tarefa}</td>
</c:forEach>

</table>
</body>
</html>