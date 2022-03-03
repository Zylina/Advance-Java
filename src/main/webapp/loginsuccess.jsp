<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="com.org.LoginDao"%>
 <!DOCTYPE html>
 <html>
 <head>
  <meta charset="ISO-8859-1">
   <title>Insert title here</title>
    </head>
	<body>
	<jsp:useBean id="login" class="com.org.LoginBean" />
	<jsp:setProperty property="*" name="login" />
	 <%
 		 LoginDao loginDao = new LoginDao();
  		 boolean status = loginDao.validate(login);
   		 if (status) {
           	out.print("<h1>You have logined successfully</h1>");
   		}
 	%>
  </body>
</html>