<%@ include file="header.jsp" %>
<%@ include file="ConnectToDB.jsp" %> 
<%
ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
String ctryname=request.getParameter("search");

String query="select cdate,cname,tcases,ncases,tdeaths,ndeaths,trecover from cases where cname='"+ ctryname +"'";

try {
			rs = st.executeQuery(query);
			
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
%>
<html><body ><table id='cases'> <tr> 
<th>Date</th><th>Total Cases</th> <th>New Cases</th>
<th>Total Deaths</th><th>New Deaths</th><th>Total Recovered</th></tr>

<% 
while(rs.next()){
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
		
					
}
out.println("<h2>Your Search results for:"+ctryname+" </h2>");
for(int i=0;i<list.size();i++)
{
  	    			
	HashMap countryDetailsMap = list.get(i);
	
	out.write("<tr>");
	out.write("<td>"+countryDetailsMap.get("Date")+"</td>\n");
	out.write("<td>"+countryDetailsMap.get("Total Cases")+"</td>\n");
	out.write("<td>"+countryDetailsMap.get("New Cases")+"</td>\n");
	out.write("<td>"+countryDetailsMap.get("Total Deaths")+"</td>\n");
	out.write("<td>"+countryDetailsMap.get("New Deaths")+"</td>\n");
	out.write("<td>"+countryDetailsMap.get("Total Recovered")+"</td>\n");
    out.write("</tr>\n");

}		

%>

<%@ include file="Footer.jsp" %> 