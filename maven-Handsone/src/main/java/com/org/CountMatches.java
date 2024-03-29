package com.org;

import java.io.IOException;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.lang.StringUtils;



public class CountMatches extends TagSupport {
   String inputstring;
   String lookupstring;
	     
  public String getInputstring() {
    return inputstring;
  }

  public void setInputstring(String inputstring) {
    this.inputstring = inputstring;
  }

  public String getLookupstring() {
    return lookupstring;
  }

  public void setLookupstring(String lookupstring) {
    this.lookupstring = lookupstring;
  }

  public int doStartTag() throws JspException {
    try {
      JspWriter out = pageContext.getOut();
      out.println(StringUtils.countMatches(inputstring, lookupstring));
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
    return SKIP_BODY;
  }
}

