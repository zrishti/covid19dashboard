package com.zrishti.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.zrishti.utils.ValidationDemo;


public class FileUtils extends HttpServlet{
	HashMap<String,String > hmap = new HashMap<String, String>();
	Map<String, String> myMap = new HashMap<String, String>();
	File file=new File("casefile.txt");
	
	
	public void setvalue(String cname, String ccases) throws IOException
	{
		
		String city;
		String cases;
		Boolean isInvalid = false;
		//scSysIn.useDelimiter(System.getProperty("line.separator"));
		
		
		do {
			//System.out.println("Enter the city");
			//scSysIn.nextLine();
			city=cname;
			isInvalid=ValidationDemo.isDigit(city);
			
			if(isInvalid==true)
			{
				System.out.println("Invalid entry");
			}
			}while(isInvalid);
			
			
			do {
			//System.out.println("Enter the number of cases");		
			cases=ccases;
			isInvalid=ValidationDemo.isAlphabet(cases);
			if(isInvalid==true)
			{
				System.out.println("Invalid entry");
			}
			}while(isInvalid);
			
			
		
	
		
			hmap.put(city.trim(),cases);
			//System.out.println(cases);
			
		
}

	public void getvalue()
	{
		
		for(Entry<String, String> entry:hmap.entrySet())
		{
		    System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
/*	public void showcountry()
	{
		
		System.out.println("Enter the country");
		String country = scSysIn.next();
		if(hmap.containsKey(country))
		{
			System.out.println(country + ":"+ hmap.get(country));
		}
		
	}
	
	*/
	
	
	public void FormToDb(String cdate,String cname, String tcases,String ncases,String tdeaths,String ndeaths,String trecover) throws Exception
	{
		System.out.println("hello from FormToDb");
		String url= DBUtils.DBURL;
		String uname= DBUtils.DBUSERNAME;
		String pass= DBUtils.DBPASSWORD;
		
		
		
		int totalcases=Integer.parseInt(tcases);
		int newcases=Integer.parseInt(ncases);
		int totaldeaths=Integer.parseInt(tdeaths);
		int newdeaths=Integer.parseInt(ndeaths);
		int totalrecover=Integer.parseInt(trecover);
		
		String query="insert into cases values('"+cdate+"','"+cname+"',"+totalcases+","+newcases+","+totaldeaths+","+newdeaths+","+totalrecover+")";
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		
		
		int count=st.executeUpdate(query);
		System.out.println(count +"row/s affected");

		
		
		st.close();
		con.close();
	}

	
	public Map<String, List<String>> formtohash(String cname, String tcases,String ncases,String tdeaths,String ndeaths,String trecover) 
	{
		System.out.println(cname);
		System.out.println(tcases);
		System.out.println(ncases);
		System.out.println(tdeaths);
		System.out.println(ndeaths);
		System.out.println(trecover);
		
		
		// create map to store
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		// create list one and store values
		List<String> addvalues = new ArrayList<String>();
		//addvalues.add(cname);
		addvalues.add(tcases);
		addvalues.add(ncases);
		addvalues.add(tdeaths);
		addvalues.add(ndeaths);
		addvalues.add(trecover);
		
		// put values into map
        map.put(cname, addvalues);
        
     // iterate and display values
        System.out.println("Fetching Keys and corresponding [Multiple] Values n");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> showvalues = entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Values = " + addvalues);
        }
		return map;
		
	}
public void hashtofile(Map<String, List<String>> hmap2) {
	
		try {
		if(!file.exists())
			{
				file.createNewFile();
				
			}
		FileWriter fw=new FileWriter(file,true);
		BufferedWriter bw=new BufferedWriter(fw);
		for(Entry<String, List<String>> entry:hmap2.entrySet())
			{
				bw.write(entry.getKey().trim() + "," + entry.getValue().toString().trim().replace("[", "").replace("]", ""));
			    bw.newLine();
			}
		bw.close();
		//System.out.println("Done");
		
	}catch(IOException e)
		{
		e.printStackTrace();
		}
		
}


//public void Filetohash()

	public Map<String, List<String>> Filetohash() throws IOException{
		
		Map<String, List<String>> map = new HashMap<String, List<String>>(); 
	System.out.print("Hi from Utils");
	try
	{
	  Scanner in=new Scanner(file);
	  String line;
	  if(!in.hasNextLine())
	  {
		  System.out.print("No data found...Please Choose option 1 to enter new values");
	  }
	  else {
	  do
		{
			line=in.nextLine();
			
			// System.out.println("1"+line);
			 System.out.println(line);
			//out.println(line);
			
			String[] keyvalue=line.split(",");
			String hcity=keyvalue[0].trim();
			ArrayList<String> list=new ArrayList<String>();
			
			for(int i=1;i<keyvalue.length;i++)
			{
				list.add(keyvalue[i]);
			}
			map.put(hcity, list);
			/*
			 * String hcity=keyvalue[0].trim(); //System.out.println(keyvalue[1]); String
			 * fcases=keyvalue[1]; fcases=fcases.trim();
			 */
			
			//int hcases=Integer.parseInt(fcases);
			//hmap.put(hcity,list);
			
		}while(in.hasNextLine());
	  	in.close();
	  //System.out.println("hash from file...."+ hmap.toString());
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.print("No data found ..add new entries..");
	}
	return map;
	

	}
}

	/*
	public void hashtofile(Map<String, List<String>> hmap2) {
		// TODO Auto-generated method stub
		
	}
}*/

