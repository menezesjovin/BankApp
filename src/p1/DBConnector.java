package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private Connection con;
	private String url="jdbc:mysql://localhost:3306/BANK";
	private String un = "welcome1";
	private String pwd = "welcome1";
	public void setCon(Connection con) {
		this.con = con;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Connection getCon() {
		return con;
	}
	public String getUrl() {
		return url;
	}
	public String getUn() {
		return un;
	}
	public String getPwd() {
		return pwd;
	}
	Connection getConnection()
	{
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
				con=DriverManager.getConnection(url, un, pwd);
				return con;
			} 
		catch (SQLException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return null;
		
	}
	
}
	

