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
import javax.servlet.http.*;
import javax.servlet.*;
import com.zrishti.data.*;

public class RESTIndexServlet extends HttpServlet{
							  
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		PrintWriter out=res.getWriter();



		Covid19CountryDAO cdetails=new Covid19CountryDAO();
		cdetails.getConnection();
		
		out.write(cdetails.todaysDetailsREST("2020-07-01"));
		
			
	}
		
}

		

		
		
		

