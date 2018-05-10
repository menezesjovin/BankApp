package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model 
{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	private String customername;
	private int accnum;
	private String cusid;
	private String cuspwd;
	private int tpaccnum;
	private int transamt;
	private int balance;
	private String opw;
	private String npw;
	private String cnpw;

	public void setOpw(String opw) {
		this.opw = opw;
	}
	public void setNpw(String npw) {
		this.npw = npw;
	}
	public void setCnpw(String cnpw) {
		this.cnpw = cnpw;
	}
	public String getOpw() {
		return opw;
	}
	public String getNpw() {
		return npw;
	}
	public String getCnpw() {
		return cnpw;
	}
	public Connection getCon() {
		return con;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public ResultSet getRes() {
		return res;
	}
	public String getCustomername() {
		return customername;
	}
	public int getAccnum() {
		return accnum;
	}
	public String getCusid() {
		return cusid;
	}
	public String getCuspwd() {
		return cuspwd;
	}
	public int getTpaccnum() {
		return tpaccnum;
	}
	public int getTransamt() {
		return transamt;
	}
	public int getBalance() {
		return balance;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	public void setRes(ResultSet res) {
		this.res = res;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public void setAccnum(int accnum) {
		this.accnum = accnum;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public void setCuspwd(String cuspwd) {
		this.cuspwd = cuspwd;
	}
	public void setTpaccnum(int tpaccnum) {
		this.tpaccnum = tpaccnum;
	}
	public void setTransamt(int transamt) {
		this.transamt = transamt;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	Model()
	{
		DBConnector db=new DBConnector();
		con=db.getConnection();
		
	}
	boolean validate()
	{
		try 
		{
			pstmt=con.prepareStatement("select * from BANK where CUSTOMERID=? and PASSWORD=?");
		    pstmt.setString(1, cusid);
		    pstmt.setString(2, cuspwd);
		    res=pstmt.executeQuery();
		    while(res.next()==true) {
				customername=res.getString(5);  //from 5th column of db
				accnum=res.getInt(1);  //from 1st column of db
				balance=res.getInt(9);//i changed
				System.out.println("inside validate"+balance);//i changed
				return true;
			}
		    
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	boolean transfer()
	{
		try 
		{
			if(balance>0 && balance>=transamt && transamt>0)
			{
				System.out.println(balance+"t1balance"+transamt+"t1transamt");
			pstmt=con.prepareStatement("update BANK set BALANCE=BALANCE-? where ACCNO=?");
		    pstmt.setInt(1, transamt);
		    pstmt.setInt(2, accnum);
		    
		    pstmt.executeUpdate();
		    pstmt=con.prepareStatement("select * from BANK where ACCNO=?");
		    pstmt.setInt(1, accnum);
		    res=pstmt.executeQuery();
		    while(res.next()==true) {
		   
			balance=res.getInt(9);
			System.out.println("inside transfer2"+balance);
		    
		    }
		    }
		    else
		    {
		    	return false;
		    }
		    pstmt=con.prepareStatement("update BANK set BALANCE=BALANCE+? where ACCNO=?");
		    pstmt.setInt(1, transamt);
		    pstmt.setInt(2, tpaccnum);
		    pstmt.executeUpdate();	
		     
		    pstmt=con.prepareStatement("insert into STATEMENT values(?,?)");
		    pstmt.setInt(1, accnum);
		    pstmt.setInt(2, transamt);
		    pstmt.executeUpdate();
		    return true;
		   
		    
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	boolean changePassword()
	{
		try 
		{
			
				
			pstmt=con.prepareStatement("update BANK set  PASSWORD=? where ACCNO=?");
		    pstmt.setString(1,npw);
		    pstmt.setInt(2,accnum);
		    
		    pstmt.executeUpdate();
		    
		   
		    return true;
			
		    
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	ArrayList miniStatement(){
		try {
			pstmt=con.prepareStatement("select * from STATEMENT where ACCNO=?");
			pstmt.setInt(1, accnum);
			res=pstmt.executeQuery();
			ArrayList al=new ArrayList();
			while(res.next()==true) {
				al.add(res.getInt(2));
			}
		return al;	
		}
		catch(Exception e) {
e.printStackTrace();
return null;
		}
	}
	boolean checkBalance() {
		try 
		{
			pstmt=con.prepareStatement("select * from BANK where ACCNO=?");
		    pstmt.setInt(1, accnum);
		    res=pstmt.executeQuery();
		    while(res.next()==true) {
		   
			balance=res.getInt(9);
			System.out.println("inside transfer2"+balance);
		    
		    
			
			}
		    return true;
		}
		    catch(Exception e) {
		    	e.printStackTrace();
		    	return false;
		    }
	}
}
