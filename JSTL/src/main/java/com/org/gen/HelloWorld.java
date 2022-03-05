package com.org.gen;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends SimpleTagSupport {
	private static final long serialVersionUID = 1L;
	  public void doTag() throws JspException, IOException {
	        final JspWriter out = getJspContext().getOut();
	        out.println( "Hello JSP Custom Tag!" );
	    }
     
}
