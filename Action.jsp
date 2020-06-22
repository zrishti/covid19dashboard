<%@ include file="header.jsp" %>
<%@ include file="ConnectToDB.jsp" %> 
<% 
                String s=request.getParameter("selecteddate");
                session.setAttribute("sdate", s);
                response.sendRedirect("index.jsp");
                
			    //String query="select cdate,cname,tcases,ncases,tdeaths,ndeaths,trecover from cases where cdate='"+s+"'";                    
   %>
   <!--  
   <table id='cases'><tr>
			
			<th>Country</th>
			<th>Total Cases</th><th>New Cases</th>
			<th>Total Deaths</th><th>New Deaths</th>
			<th>Total Recovered</th></tr>
			
		-->	<%--
		
			<%
			try {
				
				rs = st.executeQuery(query);
				while(rs.next())
					{
						try {
						out.write("<tr>");
						out.write("<td>"+rs.getString("cname")+"</td>\n");
						out.write("<td>"+rs.getInt("tcases")+"</td>\n");
						out.write("<td>"+rs.getInt("ncases")+"</td>\n");
						out.write("<td>"+rs.getInt("tdeaths")+"</td>\n");
						out.write("<td>"+rs.getInt("ndeaths")+"</td>\n");
						out.write("<td>"+rs.getInt("trecover")+"</td>\n");
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
						out.write("</tr>\n");
						
						
					    
					}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			%>
			</table>
			--%>