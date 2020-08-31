<%@ include file="header.jsp" %>
<h2>Report Cases</h2>
		<div class='container'>
		<form action="todb" method='get'>
		<label for="cdate">Date</label>
		
		<input type="date" id="cdate" name="cdate">
		
		<label for='cname'>Country Name</label>
		
		<input type='text' name='cname'></input>
		
		<label for='tcases'>Total Cases</label>
		
		<input type='text' name='tcases'></input>
		
		<label for='ncases'>New Cases</label>
		
		<input type='text' name='ncases'></input>
		
		<label for='tdeaths'>Total Deaths</label>
		
		<input type='text' name='tdeaths'></input>
	
		<label for='ndeaths'>New Deaths</label>
	
		<input type='text' name='ndeaths'></input>
	
		<label for='trecover'>Total Recovered</label>
	
		<input type='text' name='trecover'></input>
	
		<input type='submit' value='Submit'></input></form>
		</div>

<%@ include file="Footer.jsp" %>