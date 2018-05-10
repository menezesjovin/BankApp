package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TransferController
 */
@WebServlet("/TransferController")
public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       HttpSession hs;
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		try 
		{
			int tpaccnum=Integer.parseInt(x.getParameter("tpaccnum"));
			int transamt=Integer.parseInt(x.getParameter("transamt"));
		    hs=x.getSession();
			int accnum=(int) hs.getAttribute("accnum");
			int balance=(int) hs.getAttribute("balance");//i changed
			Model m=new Model();
			m.setTpaccnum(tpaccnum);
			m.setTransamt(transamt);
			m.setAccnum(accnum);
			hs.setAttribute("balance", m.getBalance());//I CHANGED
			m.setBalance(balance);//i changed
			//m.setBalance(balance);//1
			boolean b=m.transfer();
			System.out.println("inside transfer controller"+balance);
			if(b==true)
			{
				HttpSession hs=x.getSession(true);
				//hs.setAttribute("name",m.getCustomername());
				//hs.setAttribute("accnum",m.getAccnum());
				hs.setAttribute("balance", m.getBalance());
				System.out.println(balance);
				//hs.setAttribute("balance",m.getBalance()); //1

				y.sendRedirect("/BankApp/TransferSuccess.jsp");
				
			}
			else
			{
				y.sendRedirect("/BankApp/TransferFailure.jsp");
			}
		}
	    
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
