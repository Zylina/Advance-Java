package com.org.gen;

import javax.servlet.http.HttpServlet;

import java.util.Calendar;  
import javax.servlet.jsp.JspException;  
import javax.servlet.jsp.JspWriter;  
import javax.servlet.jsp.tagext.TagSupport;  


public class MyTag extends TagSupport {
	private static final long serialVersionUID = 1L;
   
	public void doTag() {
		JspWriter out = pageContext.getOut();
		try {
			out.println("this is custom tag");
			out.println(Calendar.getInstance().getTime());
		}catch(Exception e) {
			
		}
	}
}