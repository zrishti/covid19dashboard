
<%@ include file="header.jsp" %>

<%@ include file="PrintDate.jsp" %>  
<%@ include file="ConnectToDB.jsp" %> 

<%

String sdate=null;
System.out.println("Initially"+sdate);

String setdate = null;

Covid19CountryDAO cdetails=new Covid19CountryDAO();
cdetails.getConnection();

ArrayList<String> datelist=cdetails.getUniqueDates();




%>

			<div id="logo">
					<h1>
						Covid-20 Coronavirus Pandemic
					</h1>
					
					<p>Reported Cases and Deaths by Country, Territory, or Conveyance.</p>
					<p>The coronavirus COVID-19 is affecting 213 countries and territories around the world and 2 international conveyances. 
						The day is reset after midnight GMT+0
					</p>
				</div>	
			
			  <%@ include file="SearchBox.jsp" %> 
			
				
			
   				 <form action="Action.jsp"  method="POST">
   				 <label for="selectdate">Date</label>
   				 <select name="selecteddate" id="datep">
    			<%
    			
    			for(int i=0;i<datelist.size();i++)
    			{
    			    				    			
    			%>
				<option value="<%=datelist.get(i)%>" selected><%=datelist.get(i)%></option>
				<%} %>
				</select>
				<input type="submit"/>
				</form>
			   <% 
			    setdate=datelist.get(0);
   				out.println("The set date.."+setdate);
   				%>
				<%try{
			     sdate=session.getAttribute("sdate").toString();
				 out.println("The selected date:session"+sdate);
				
				 }
			   catch(Exception e)
			   {
				   //System.out.println("NULLL...");
				   e.printStackTrace();
			   }
				//cdetails.setDetailsByDate(sdate);
				%>
			<table id='cases'><tr>
			
			<th>Country</th>
			<th>Total Cases</th><th>New Cases</th>
			<th>Total Deaths</th><th>New Deaths</th>
			<th>Total Recovered</th></tr>
			
			
			<%
			//String query="select cdate,cname,tcases,ncases,tdeaths,ndeaths,trecover from cases where cdate='"+ setdate +"'";
			//String querybydate="select cdate,cname,tcases,ncases,tdeaths,ndeaths,trecover from cases where cdate='"+ sdate +"'";
			try {
				if(sdate==null)
				{
					out.println("<h1>Today's Cases<h1>");
					
					/*
					ArrayList<HashMap<String, String>> TDatelist=cdetails.todaysDetails(setdate);
					//out.println("before querybydate" +setdate);
					//out.println("Cases on" +setdate);
					for(int i=0;i<TDatelist.size();i++)
	    			{
	    			  	    			
	    				HashMap countryDetailsMap = TDatelist.get(i);
	    				
						out.write("<tr>");
						out.write("<td>"+countryDetailsMap.get("Country Name")+"</td>\n");
						out.write("<td>"+countryDetailsMap.get("Total Cases")+"</td>\n");
						out.write("<td>"+countryDetailsMap.get("New Cases")+"</td>\n");
						out.write("<td>"+countryDetailsMap.get("Total Deaths")+"</td>\n");
						out.write("<td>"+countryDetailsMap.get("New Deaths")+"</td>\n");
						out.write("<td>"+countryDetailsMap.get("Total Recovered")+"</td>\n");
					    out.write("</tr>\n");

	    			}		
						
						*/

						ArrayList<Covid19Country> TDatelist=cdetails.todaysDetailsDAO(setdate);
						for(int i=0;i<TDatelist.size();i++)
		    			{
	    			  	    			
		    				Covid19Country countryDetailsMap = TDatelist.get(i);
	    				
							out.write("<tr>");
							out.write("<td>"+countryDetailsMap.getCountry() +"</td>\n");
							out.write("<td>"+countryDetailsMap.getTotalCases()  +"</td>\n");
							out.write("<td>"+countryDetailsMap.getNewCases() +"</td>\n");
							out.write("<td>"+countryDetailsMap.getTotalDeaths()  +"</td>\n");
							out.write("<td>"+countryDetailsMap.getNewDeaths() +"</td>\n");
							out.write("<td>"+countryDetailsMap.getTotalRecover() +"</td>\n");
						    out.write("</tr>\n");

		    			}		
												
						
						
						
						
						
					
		        } 
				else
				{
				
					ArrayList<HashMap<String, String>> covByDate=cdetails.detailsByDate(sdate);
					out.println("<h1>Cases on " +sdate+"<h1>");
					session.removeAttribute("sdate");
					sdate=null;
					//out.println("after querybydate" +sdate);
					//out.println("I am back");
					
					
					for(int i=0;i<covByDate.size();i++)
	    			{
						   			
	    				HashMap countryDetailsMap = covByDate.get(i);
						out.write("<tr>");
						out.write("<td>"+countryDetailsMap.get("Country Name")+"</td>\n");
						out.write("<td>"+countryDetailsMap.get("Total Cases")+"</td>\n");
						out.write("<td>"+countryDetailsMap.get("New Cases")+"</td>\n");
						out.write("<td>"+countryDetailsMap.get("Total Deaths")+"</td>\n");
						out.write("<td>"+countryDetailsMap.get("New Deaths")+"</td>\n");
						out.write("<td>"+countryDetailsMap.get("Total Recovered")+"</td>\n");
					    out.write("</tr>\n");

	    			}	

					
				}
				
				}
				
				catch (Exception e)
				{
					
					e.printStackTrace();
				}
			
				
					 
					
				
				
				
		
		%>
		</table>
		
		

<%@ include file="Footer.jsp" %>


