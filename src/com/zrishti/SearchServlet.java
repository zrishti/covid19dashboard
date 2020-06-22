package com.zrishti;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends PageLayoutServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		res.setContentType("text/html"); 
		PrintWriter out=res.getWriter();
		pageheader(out);
		String ctryname=req.getParameter("search");
		//out.println(ctryname);
		
		String url="jdbc:mysql://localhost:3306/abc";
		String uname="root";
		String pass="joann";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,uname,pass);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String query="select * from cases where cname='"+ ctryname +"'";
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		out.write("<html>" +"<body >" +"<table id='cases'>" +"<tr>" +
			       "<th>Country</th>" +"<th>Total Cases</th>" +"<th>New Cases</th>"+"<th>Total Deaths</th>"+"<th>New Deaths</th>"+"<th>Total Recovered</th></tr>");
		out.println("<h2>Your Search results: </h2>");
		try {
			while(rs.next()) {
				try {
					out.write("<tr>" +"<td>"+rs.getString("cname")+"</td>");
					out.write("<td>"+rs.getInt("tcases")+"</td>");
					out.write("<td>"+rs.getInt("ncases")+"</td>");
					out.write("<td>"+rs.getInt("tdeaths")+"</td>");
					out.write("<td>"+rs.getInt("ndeaths")+"</td>");
					out.write("<td>"+rs.getInt("trecover")+"</td>");
				}
			
				catch(Exception e)
				{
					e.printStackTrace();
				}
					out.write("</tr>");
					out.write("</table>" +"</body>" +"</html>");
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}	
}



