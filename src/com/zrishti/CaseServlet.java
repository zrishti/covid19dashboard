package com.zrishti;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaseServlet extends PageLayoutServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		PrintWriter out=res.getWriter();
		
		pageheader(out);
		out.println("<h2>Reported Cases and Deaths by Country, Territory, or Conveyance</h2>");
		out.println("<p>The coronavirus COVID-19 is affecting 213 countries and territories around the world and 2 international conveyances. The day is reset after midnight GMT+0.");
		
		search(out);
		
		String search=req.getParameter("search");
		//out.println(search +".....");
		String url="jdbc:mysql://localhost:3306/abc";
		String uname="root";
		String pass="joann";//should be taken from build file not hard coded
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			
			e2.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,uname,pass);
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		String query="select * from cases";
		ResultSet rs = null;
		
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		
		out.write("<table id='cases'>" +"<tr>" +
			       "<th>Country</th>" +"<th>Total Cases</th>\n" +"<th>New Cases</th>"+"<th>Total Deaths</th>"+"<th>New Deaths</th>\n"+"<th>Total Recovered</th></tr>\n");
		
		try {
			while(rs.next())
				{
					try {
					out.write("<tr>" +"<td>"+rs.getString(1)+"</td>\n");
					out.write("<td>"+rs.getInt(2)+"</td>\n");
					out.write("<td>"+rs.getInt(3)+"</td>\n");
					out.write("<td>"+rs.getInt(4)+"</td>\n");
					out.write("<td>"+rs.getInt(5)+"</td>\n");
					out.write("<td>"+rs.getInt(6)+"</td>\n");
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					out.write("</tr>\n");
					
					
				    
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		out.write("</table>");
		pagefooter(out);		
		}
		
		}

		

		
		
		

