package com.zrishti;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewEntryServlet extends PageLayoutServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		PrintWriter out=res.getWriter();
		pageheader(out);
		out.println("<h2>Report Cases</h2>");
		out.println("<div class='container'>");
		out.println("<form action=index method='get'>");
		out.println("<label for='cname'>Country Name</label>");
		out.println("<br>"+"<br>");
		out.println("<input type='text' name='cname'>"+"</input>");
		out.println("<br>"+"<br>");
		out.println("<label for='tcases'>Total Cases</label>");
		out.println("<br>"+"<br>");
		out.println("<input type='text' name='tcases'>"+"</input>");
		out.println("<br>"+"<br>");
		out.println("<label for='ncases'>New Cases</label>");
		out.println("<br>"+"<br>");
		out.println("<input type='text' name='ncases'>"+"</input>");
		out.println("<br>"+"<br>");
		out.println("<label for='tdeaths'>Total Deaths</label>");
		out.println("<br>"+"<br>");
		out.println("<input type='text' name='tdeaths'>"+"</input>");
		out.println("<br>"+"<br>");
		out.println("<label for='ndeaths'>New Deaths</label>");
		out.println("<br>"+"<br>");
		out.println("<input type='text' name='ndeaths'>"+"</input>");
		out.println("<br>"+"<br>");
		out.println("<label for='trecover'>Total Recovered</label>");
		out.println("<br>"+"<br>");
		out.println("<input type='text' name='trecover'>"+"</input>");
		out.println("<br>"+"<br>");
		out.println("<input type='submit' value='submit'>"+"</input>"+"</form>");
		out.println("</div>");
		pagefooter(out);
		
}
}
