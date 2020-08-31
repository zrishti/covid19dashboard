<%@ page import = "java.io.*,java.util.*,java.sql.*,java.util.HashMap"%>


<%HashMap<String, String> covidDetails = new HashMap<String, String>(); %>
 
<%
String url="jdbc:mysql://localhost:3306/abc";
String uname="root";
String pass="joann";
Connection con =null;
Statement st = null;
ResultSet rs = null;
String driver="com.mysql.jdbc.Driver";
try {
	Class.forName(driver);
} catch (ClassNotFoundException e2) {
e2.printStackTrace();
}

try {
	con = DriverManager.getConnection(url,uname,pass);
} catch (SQLException e2) {
	
	e2.printStackTrace();
}
try {
	st = con.createStatement();
} catch (SQLException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}
%>
<%
String querybydate="select cdate,cname,tcases,ncases,tdeaths,ndeaths,trecover from cases";
rs = st.executeQuery(querybydate);
%>
<%
Map<String, List<String>> map = new LinkedHashMap <String, List<String>>();
while(rs.next()){
List<String> addvalues = new ArrayList<String>();
String tcases=String.valueOf(rs.getInt("tcases"));
String ncases=rs.getString("ncases").toString();
String tdeaths=rs.getString("tdeaths").toString();
String ndeaths=rs.getString("ndeaths").toString();
String trecover=rs.getString("trecover").toString();
addvalues.add(rs.getString("cdate"));
addvalues.add(tcases);
addvalues.add(ncases);
addvalues.add(tdeaths);
addvalues.add(ndeaths);
addvalues.add(trecover);
map.put(rs.getString("cname"), addvalues);

}

%>
<%
Set<String> keys = map.keySet();
for (String key : keys) {
   out.println("Key = " + key);
   out.println("Values = " + map.get(key));
   out.println("<br>");
}
%>
