package com.zrishti;
import com.zrishti.utils.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToDbServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{

		PrintWriter out=res.getWriter();
		out.println("Entry Success");
		String cdate=req.getParameter("cdate");
		out.println(cdate);
		String cname=req.getParameter("cname");
		String tcases=req.getParameter("tcases");
		String ncases=req.getParameter("ncases");
		String tdeaths=req.getParameter("tdeaths");
		String ndeaths=req.getParameter("ndeaths");
		String trecover=req.getParameter("trecover");
		out.println(cname);
		out.println(tcases+" "+ncases+" "+tdeaths+"  "+ndeaths+" "+trecover);
		FileUtils utils=new FileUtils();
		try {
			utils.FormToDb(cdate,cname, tcases, ncases, tdeaths, ndeaths, trecover);
			out.println("I am back");
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.sendRedirect("index.jsp");

}
}