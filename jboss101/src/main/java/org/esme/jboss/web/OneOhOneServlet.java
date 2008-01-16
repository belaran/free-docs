package org.esme.jboss.web;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



public class OneOhOneServlet extends HttpServlet
{
	protected Logger logger = Logger.getLogger("TEST");

	private static String KEY = "key";
	private static String VALUE =  "value";

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
		this.doGet(request,response);
	}
	/**
	 * Get Implementation data
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	{
		// Retrieve data from request
		for (Object key : request.getParameterMap().keySet() )
		{
			String value = request.getParameter(key.toString());
			logger.debug("key [" + key.toString() + "] associated to value :" + value);
			// Adding parameter to session
		}
		String key = request.getParameter(KEY);
		String value = request.getParameter(VALUE);
		if ( key != null && value != null && ! "".equals(key) && ! "".equals(value) )
		{
			request.getSession().setAttribute(key,value);
			logger.debug("Added key/value:[" + key + "," + value + "]");
		}
	    // Returns a writer to write to the browser
	    PrintWriter out;
		try 
		{
			logger.debug("Rendering WebSite");
			out = response.getWriter();
			//Writes the string to the browser.
		    out.println("<html>" +
		    		"<head>" +
		    		"	<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">" +
		    		"</head>" +
		    		"JBoss 101 app:[" + Calendar.getInstance().getTime() + "]<br/>");
		    out.println("<div class=\"main\">");
		    out.println("Displaying session content:<br/>");
			Enumeration attributeNames = request.getSession().getAttributeNames();
		    while ( attributeNames.hasMoreElements() )
		    {
			    String attributeName = (String) attributeNames.nextElement();
				out.println("<span class=\"session_entry\">key [" + attributeName + "] associated to value :" + request.getSession().getAttribute(attributeName) + "</span><br/>");			    	
		    }
		    out.println("</div><br/><br/>");
		    out.println("<div class=\"session_form\">");
		    out.println("Adding value to the session:");
		    out.println("<form action=\".\" method=\"post\">");
		    out.println("New key: <input type=\"text\" name=\"" + KEY + "\"/><br/>");
		    out.println("New value: <input type=\"text\" name=\"" + VALUE + "\"/><br/>");
		    out.println("New value: <input type=\"submit\"/>");
		    out.println("</form></div>");
		    out.close();
		    logger.debug("Rendering Website over.");
		} 
		catch (IOException e) 
		{
			logger.error(e.getMessage());
		}

	    
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
