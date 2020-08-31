
<%@page import="java.text.NumberFormat"%>
<%@ include file="header.jsp" %>



<%

String sdate=null; //show data based on this variable
String setdate = null;

Covid19CountryDAO cdetails=new Covid19CountryDAO();
cdetails.getConnection();

ArrayList<String> datelist=cdetails.getUniqueDates();


%>

			<div id="my_dataviz"></div>
			
			
			  
			  <div id="date">
						
   				 <form action="Action.jsp"  method="POST">
   				
   				 <select name="selecteddate" id="datep">
    			<%
    	
    			if(datelist.size()>0) {
				    setdate=datelist.get(0);//initialized default date
				}
    			
    			
    			for(int i=0;i<datelist.size();i++)
    			{
    			    				    			
    			%>
				<option value="<%=datelist.get(i)%>" ><%=datelist.get(i)%></option>
				<%} %>
				</select>
				<input type="submit"/>
				</form>
				</div>
			   <% 
			   
   				%>
				<%try{
			     sdate=session.getAttribute("sdate").toString();
			     
				// out.println("The selected date:session"+sdate);
				
				 }
			   catch(Exception e)
			   {
				   //System.out.println("NULLL...");
				   e.printStackTrace();
			   }
				%>
			
			
			<%
			try {
				String fetchDate = null;
				
				if(sdate==null)
				{
					//out.println("<h1 align=\"center\"> Today's Cases </h1>");
					out.println("<div class='subtitle'>Today's Cases</div>");
					fetchDate = setdate;		
		        } 
				else
				{
					fetchDate = sdate;
					out.println("<div class='subtitle''>Cases on " +sdate+"</div>");
					session.removeAttribute("sdate");
					sdate=null;
				}
				
				
				
				%>
				
		<table id='cases'><tr>
			
			<th>Country</th>
			<th onclick="sortTable(1)">Total Cases</th>
			<th onclick="sortTable(2)">New Cases</th>
			<th onclick="sortTable(3)">Total Deaths</th>
			<th onclick="sortTable(4)">New Deaths</th>
			<th onclick="sortTable(5)">Total Recovered</th></tr>
					
				
				<% 
			//	out.println("<h1>Cases on ->>>>" +fetchDate+"<h1>");
				
				ArrayList<Covid19Country> TDatelist=cdetails.todaysDetailsDAO(fetchDate);
				for(int i=0;i<TDatelist.size();i++)
    			{
			  	    			
    				Covid19Country countryDetailsMap = TDatelist.get(i);
    				String country=countryDetailsMap.getCountry();
    				
    				//System.out.println(country);
					out.write("<tr>");
					
					out.write("<td>"+"<a href='SearchLink.jsp?id="+country+"'>"+countryDetailsMap.getCountry()+"</a>"+"</td>\n");
					//out.write("Country:"+countryDetailsMap.getCountry());
					out.write("<td>"+NumberFormat.getInstance().format(countryDetailsMap.getTotalCases())  +"</td>\n");
					out.write("<td>"+NumberFormat.getInstance().format(countryDetailsMap.getNewCases()) +"</td>\n");
					out.write("<td>"+NumberFormat.getInstance().format(countryDetailsMap.getTotalDeaths())  +"</td>\n");
					out.write("<td>"+NumberFormat.getInstance().format(countryDetailsMap.getNewDeaths()) +"</td>\n");
					out.write("<td>"+NumberFormat.getInstance().format(countryDetailsMap.getTotalRecover()) +"</td>\n");
				    out.write("</tr>\n");
										
    			}					
				
			}
				catch (Exception e)
				{
					
					e.printStackTrace();
				}
				
%>
</table>


<script type="text/javascript">
function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("cases");
  switching = true;
  dir = "asc"; 
  
  while (switching) {
	   
	    switching = false;
	    rows = table.rows;
	      
	    for (i = 1; i < (rows.length - 1); i++) {
	      
	      shouldSwitch = false;
	      
	      x = rows[i].getElementsByTagName("td")[n];
	      y = rows[i + 1].getElementsByTagName("td")[n];
	      
	      if (dir == "asc") {
	        if (x.innerHTML> y.innerHTML) {
	          shouldSwitch= true;
	          break;
	        }
	      } else if (dir == "desc") {
	        if (x.innerHTML< y.innerHTML) {
	          shouldSwitch = true;
	          break;
	        }
	      }
	    }
	    if (shouldSwitch) {
	     
	      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
	      switching = true;
	     
	      switchcount ++;      
	    } else {
	         if (switchcount == 0 && dir == "asc") {
	        dir = "desc";
	        switching = true;
	      }
	    }
	  }
	}
	</script>
 
			
		<script>

// set the dimensions and margins of the graph
var margin = {top: 10, right: 30, bottom: 30, left: 60},
    width = 620 - margin.left - margin.right,
    height = 400 - margin.top - margin.bottom;

// append the svg object to the body of the page
var svg = d3.select("#my_dataviz")
  .append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
  .append("g")
    .attr("transform",
          "translate(" + margin.left + "," + margin.top + ")");

//Read the data
d3.csv("http://localhost:8080/resources/data.csv",

  // When reading the csv, I must format variables:
  function(d){
    return { date : d3.timeParse("%Y-%m-%d")(d.date), value : d.value }
  },

  // Now I can use this dataset:
  function(data) {

    // Add X axis --> it is a date format
    var x = d3.scaleTime()
      .domain(d3.extent(data, function(d) { return d.date; }))
      .range([ 0, width ]);
    svg.append("g")
      .attr("transform", "translate(0," + height + ")")
      .call(d3.axisBottom(x));

    // Add Y axis
    var y = d3.scaleLinear()
      .domain([0, d3.max(data, function(d) { return +d.value; })])
      .range([ height, 0 ]);
    svg.append("g")
      .call(d3.axisLeft(y));

    // Add the line
    svg.append("path")
      .datum(data)
      .attr("fill", "none")
      .attr("stroke", "steelblue")
      .attr("stroke-width", 1.5)
      .attr("d", d3.line()
        .x(function(d) { return x(d.date) })
        .y(function(d) { return y(d.value) })
        )

})

</script>
		
		
		
<%@ include file="Footer.jsp" %>


