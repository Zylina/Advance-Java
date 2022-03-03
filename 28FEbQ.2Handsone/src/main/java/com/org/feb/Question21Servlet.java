package com.org.feb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Question21Servlet
 */
@WebServlet("/Question21Servlet")
public class Question21Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String username = request.getParameter("name");   
        String password = request.getParameter("password");
        boolean valid=false;
		System.out.println(username +"  ::  "+password);
				
		Connection con = null;
		PreparedStatement pstmt = null;		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loading...");
			
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/genpact","root","root@_123");
			System.out.println(" Connecting to DB ");
			
			 pstmt = con.prepareStatement("select *from login where uName=? and password=?");
			 pstmt.setString(1, username);
		     pstmt.setString(2, password);
			System.out.println("Query exceution env is ready...");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				valid=true;
			}
	
		}catch(ClassNotFoundException e){
			System.out.println("Driver not load "+ e.getMessage());
		}catch(SQLException e){
			System.out.println("DB Error Exception "+e.getMessage());
		}
		catch(Exception e){
			
		}finally{
			if(con!=null){
				try{
					con.close(); //5
				}catch(Exception e){
					System.out.println("DB connection clossing error "+e.getMessage());
				}
			}
		}
		System.out.println(" out valid= "+valid);
		
			if(valid){
				RequestDispatcher dis= request.getRequestDispatcher("LoginSuccess.jsp");
				dis.forward(request, response);
			}else{
				response.sendRedirect("Question2.jsp");
			}
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		 String skill = request.getParameter("skill");
	       
			
					
			Connection con = null;
			PreparedStatement pstmt = null;		
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver is loading...");
				
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/genpact","root","root@_123");
				System.out.println(" Connecting to DB ");
				
				 pstmt = con.prepareStatement("select *from employee where eskill=?");
				
			        pstmt.setString(1, skill);
				System.out.println("Query exceution env is ready...");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					pw.println("<h1> EmployeeId :: "+rs.getString(1)+"  :: EmployeeName :: "+rs.getString(2)+" </h1>");
				}
		
			}catch(ClassNotFoundException e){
				System.out.println("Driver not load "+ e.getMessage());
			}catch(SQLException e){
				System.out.println("DB Error Exception "+e.getMessage());
			}
			catch(Exception e){
				
			}finally{
				if(con!=null){
					try{
						con.close(); //5
					}catch(Exception e){
						System.out.println("DB connection clossing error "+e.getMessage());
					}
				}
			}
			System.out.println(" out valid= ");
			
		
		
	}

}
