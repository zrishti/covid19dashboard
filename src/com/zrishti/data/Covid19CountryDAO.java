package com.zrishti.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
//import javax.json.*;

import com.zrishti.utils.*;

public class Covid19CountryDAO {

   Connection con =null;
   
   public void getConnection()
   {
	   String driver="com.mysql.jdbc.Driver";
	   
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(DBUtils.DBURL,DBUtils.DBUSERNAME,DBUtils.DBPASSWORD);
	    }
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	 
   }
   public ArrayList<String> getUniqueDates()
   {	
	   
	   ArrayList<String> datelist=new ArrayList<String>();
	   Statement st;
	   ResultSet rs;
	   String datequery="SELECT DISTINCT cdate FROM cases order by cdate desc";
	   try {
		   st=con.createStatement();
	       rs = st.executeQuery(datequery);
	   while(rs.next())
			{   
		datelist.add(rs.getString("cdate"));
		    }
	       }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }

	return datelist;
   }
   
   public void setDetailsByDate(String cdate)
   {
	   String querybydate="select cdate,cname,tcases,ncases,tdeaths,ndeaths,trecover from cases where cdate='"+ cdate +"'";
		  
			ResultSet rs = null;
			try {
				Statement st = con.createStatement();
				rs = st.executeQuery(querybydate);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			while(rs.next())
			 {
				String covDate = rs.getString("cdate");
				String covCountry=rs.getString("cname"); 
				String covTCases=String.valueOf(rs.getInt("tcases")); 
				int covNCases=rs.getInt("ncases"); 
				int covTDeaths =rs.getInt("tdeaths"); 
				int covNDeaths=rs.getInt("ndeaths"); 
				int covTRecover=rs.getInt("trecover"); 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
   }
   
   
   public ArrayList<HashMap<String, String>> detailsByDate(String cdate)
   {
	   //System.out.println("I am in covid19");
	   ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	   
	   String querybydate="select cdate,cname,tcases,ncases,tdeaths,ndeaths,trecover from cases where cdate='"+ cdate +"'";
		  
		ResultSet rs = null;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(querybydate);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 try {
		while(rs.next())
		 {
			HashMap<String, String> hm = new HashMap<String, String>();
			String covDate = rs.getString("cdate");
			String covCountry=rs.getString("cname"); 
			String covTCases=String.valueOf(rs.getInt("tcases")); 
			String covNCases=String.valueOf(rs.getInt("ncases")); 
			String covTDeaths =String.valueOf(rs.getInt("tdeaths")); 
			String covNDeaths=String.valueOf(rs.getInt("ndeaths")); 
			String covTRecover=String.valueOf(rs.getInt("trecover")); 
			
			hm.put("Date", covDate);
			hm.put("Country Name", covCountry);
			hm.put("Total Cases", covTCases);
			hm.put("New Cases", covNCases);
			hm.put("Total Deaths", covTDeaths);
			hm.put("New Deaths", covNDeaths);
			hm.put("Total Recovered", covTRecover);
			
			//System.out.println(hm);
			list.add(hm);
			
			System.out.println("Arraylist:..."+list);
			//System.out.println(covDate);
			
		 }
		
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
		return list;
	   
   }
   
   public ArrayList<HashMap<String, String>> todaysDetails(String tdate)
   {
	   //System.out.println("I am in covid19");
	   ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	   
	   String querytdate="select cdate,cname,tcases,ncases,tdeaths,ndeaths,trecover from cases where cdate='"+ tdate +"'";
		  
		ResultSet rs = null;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(querytdate);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 try {
		while(rs.next())
		 {
			HashMap<String, String> hm = new HashMap<String, String>();
			String covDate = rs.getString("cdate");
			String covCountry=rs.getString("cname"); 
			String covTCases=String.valueOf(rs.getInt("tcases")); 
			String covNCases=String.valueOf(rs.getInt("ncases")); 
			String covTDeaths =String.valueOf(rs.getInt("tdeaths")); 
			String covNDeaths=String.valueOf(rs.getInt("ndeaths")); 
			String covTRecover=String.valueOf(rs.getInt("trecover")); 
			
			hm.put("Date", covDate);
			hm.put("Country Name", covCountry);
			hm.put("Total Cases", covTCases);
			hm.put("New Cases", covNCases);
			hm.put("Total Deaths", covTDeaths);
			hm.put("New Deaths", covNDeaths);
			hm.put("Total Recovered", covTRecover);
			
			//System.out.println(hm);
			list.add(hm);
			
			System.out.println("Arraylist:..."+list);
			//System.out.println(covDate);
			
		 }
		
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
		return list;
	   
   }
   
   



   public ArrayList<Covid19Country> todaysDetailsDAO(String tdate)
   {
	   //System.out.println("I am in covid19");
	   ArrayList<Covid19Country> list = new ArrayList<Covid19Country>();
	   
	   String querytdate="select cdate,cname,tcases,ncases,tdeaths,ndeaths,trecover from cases where cdate='"+ tdate +"'";
		  
		ResultSet rs = null;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(querytdate);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 try {
		while(rs.next())
		 {
			Covid19Country c19 = new Covid19Country();
			HashMap<String, String> hm = new HashMap<String, String>();
			c19.setDate(rs.getString("cdate"));
			c19.setCountry(rs.getString("cname"));
			c19.setTotalCases(rs.getInt("tcases"));
			c19.setNewCases(rs.getInt("ncases"));
			c19.setTotalDeaths(rs.getInt("tdeaths")); 
			c19.setNewDeaths(rs.getInt("ndeaths")); 
			c19.setTotalRecover(rs.getInt("trecover")); 					
			
			//System.out.println(hm);
			list.add(c19);
			
//			System.out.println("Arraylist:..."+list);
			//System.out.println(covDate);
			
		 }
		
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
		return list;
	   
   }
   






   public String todaysDetailsREST(String tdate)
   {

	   /*
	   {
	     "countryinfo" :[
    
	       { "cname" : "Singapore","cdate" : "70090", "tcases" : "", "ncases" : "", "tdeaths" : "","ndeaths" : "","trecover" : "8990" } ,
    
	       { "cname" : "Italy","cdate" : "90909", "tcases" : "", "ncases" : "", "tdeaths" : "","ndeaths" : "","trecover" : "8990" } ,
    
        ]
  
	   }
	   */
	   
	   String querytdate="select cdate,cname,tcases,ncases,tdeaths,ndeaths,trecover from cases where cdate='"+ tdate +"'";
		  
		ResultSet rs = null;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(querytdate);
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	
	StringBuffer ab = new StringBuffer();
	ab.append("{ \"countryinfo\" :[ ");
	
	
	 try {
		while(rs.next())
		 {
			ab.append("{");
			ab.append("\"cname\":\"" + rs.getString("cname") + "\",");				
			ab.append("\"cdate\":\"" + rs.getString("cdate") + "\",");
			ab.append("\"tcases\":\"" + rs.getString("tcases") + "\",");				
			ab.append("\"ncases\":\"" + rs.getString("ncases") + "\",");				
			ab.append("\"tdeaths\":\"" + rs.getString("tdeaths") + "\",");				
			ab.append("\"ndeaths\":\"" + rs.getString("ndeaths") + "\",");				
			ab.append("\"trecover\":\"" + rs.getString("trecover") + "\"");				
			ab.append("}");
			if(!rs.isLast()) {
							ab.append(",");
			}
			
		 }
		 
		 	ab.append(" ] } ");
		
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 
		return ab.toString();
	   
   }
   
   
   
   public ResultSet getRS(String query)
   {	
	   
	   Statement st;
	   ResultSet rs;
	   try {
		   st=con.createStatement();
	       rs = st.executeQuery(query);
	       return rs;

	       }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return null;
   }
   
   
   
public static void main(String[] args) {
	
	   Covid19CountryDAO cdetails=new Covid19CountryDAO();
	   cdetails.getConnection();
	   cdetails.getUniqueDates();
	   //cdetails.getDetailsByDate();
	   //cdetails.cdetailsToHash("2020-06-16");
	   cdetails.todaysDetails("2020-06-16");
	   
	   
	   
	
	

}
}
