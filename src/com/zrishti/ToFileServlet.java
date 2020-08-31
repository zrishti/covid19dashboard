package com.zrishti;
import com.zrishti.utils.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToFileServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{

		PrintWriter out=res.getWriter();
		Map<String, List<String>> hmap;
		out.println("Entry Success");
		String cname=req.getParameter("cname");
		String tcases=req.getParameter("tcases");
		String ncases=req.getParameter("ncases");
		String tdeaths=req.getParameter("tdeaths");
		String ndeaths=req.getParameter("ndeaths");
		String trecover=req.getParameter("trecover");
		
		
		FileUtils utilsToFile=new FileUtils();
		hmap=utilsToFile.formtohash(cname, tcases, ncases, tdeaths, ndeaths, trecover);
		utilsToFile.hashtofile(hmap);
		//System.out.println("Hashmap values are.."+hmap.get(cname));
		//hmap.get(tdeaths);
		
		//utilsToFile.setvalue(cname,ccases);
		
}
}
