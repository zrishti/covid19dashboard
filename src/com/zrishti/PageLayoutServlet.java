package com.zrishti;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageLayoutServlet extends HttpServlet {

	public void pageheader(PrintWriter out) throws IOException {

		out.println("<html><head>");
		out.write("<link rel = 'stylesheet' type = 'text/css' href = 'resources/styles.css'/>");
		out.write("<title>covid19</title>");
		out.println("</head>");

		out.write("</head><body>\n");
		out.println("<div class='navbar'>");
		out.println("<ul>");
		out.println("<li><a href='index?param=index'>Data</a></li>");
		out.println("<li><a href='newentry?param=newentry'>Report Coronavirus Cases</a></li>");
		out.println("<li><a href='#news'>Map</a></li>");
		out.println("<li><a href='contact'>About</a></li>");

		out.println("</ul>");
		out.println("</div>");

		out.println("</ul>");

	}

	public void search(PrintWriter out) throws IOException {

		out.println("<div id='search'>");
		out.println("<form action='search' method='get'>");
		out.println("<input type='text' placeholder='search data' name='search'>");
		out.println("</div>");
		out.println("</form>");

	}

	public void pagefooter(PrintWriter out) throws IOException {

		out.write("</body>" + "</html>");
	}
}
