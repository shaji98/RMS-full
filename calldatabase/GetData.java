package calldatabase;

import java.sql.*;
public class GetData {
	static Connection cn=null;
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/restaurant";
	static String user="root";
	static String pass="shajitha";
	
	public static Connection getCn()throws Exception{
		Class.forName(driver);
		cn=DriverManager.getConnection(url,user,pass);
		return cn;
	}
}
