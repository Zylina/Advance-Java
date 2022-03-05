<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="msg" items="${errormsg}">
<li>${msg}</li>
</c:forEach>
<c:if test="${param.name== 'jsp' }">
<p>Welcome to ${param.name}</p>
</c:if>
</body>
</html>