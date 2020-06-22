<%@ include file="header.jsp" %>
<h2>Report Cases</h2>
		<div class='container'>
		<form action="todb" method='get'>
		<label for="cdate">Date</label>
		<br><br>
		<input type="date" id="cdate" name="cdate">
		<br><br>
		<label for='cname'>Country Name</label>
		<br><br>
		<input type='text' name='cname'></input>
		<br><br>
		<label for='tcases'>Total Cases</label>
		<br><br>
		<input type='text' name='tcases'></input>
		<br><br>
		<label for='ncases'>New Cases</label>
		<br><br>
		<input type='text' name='ncases'></input>
		<br><br>
		<label for='tdeaths'>Total Deaths</label>
		<br><br>
		<input type='text' name='tdeaths'></input>
		<br><br>
		<label for='ndeaths'>New Deaths</label>
		<br><br>
		<input type='text' name='ndeaths'></input>
		<br><br>
		<label for='trecover'>Total Recovered</label>
		<br><br>
		<input type='text' name='trecover'></input>
		<br><br>
		<input type='submit' value='submit'></input></form>
		</div>

<%@ include file="Footer.jsp" %>