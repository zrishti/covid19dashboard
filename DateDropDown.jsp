<select name="selectdate"/>
    			<%for(int i=0;i<datelist.length();i++)
    			{%>
				<option value="date"><%=datelist.get(i)%></option>
				<%} %>
</select>