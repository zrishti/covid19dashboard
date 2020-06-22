<%@ page import="java.sql.*" %>
<%
String url="jdbc:mysql://localhost:3306/abc";
String uname="root";
String pass="";
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