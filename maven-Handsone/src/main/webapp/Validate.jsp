<%@ page import ="java.sql.*" %>
<%
    try{
    	String Empid = request.getParameter("Empid");
        String Empname = request.getParameter("Empname");   
        String skills = request.getParameter("skills");
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels" , "root","root@_123");    
        Statement pst = conn.createStatement();

        ResultSet rs = pst.executeQuery("Select id, name from employe where skill=java ");                        
        if(rs.next()|| Empid.equals(1)) {          
            out.println("Valid login credentials");  
            out.println(rs.getInt(1)+ "   " +rs.getString(2));
        }
         else
            out.println("Invalid login credentials");     
    }
   catch(Exception e){       
       out.println("Something went wrong !! Please try again");       
   }      
%>