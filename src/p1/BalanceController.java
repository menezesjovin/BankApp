package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BalanceController
 */
@WebServlet("/BalanceController")
public class BalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest x,HttpServletResponse y) {
		try {
			
			Model m=new Model();
			
			boolean b=m.checkBalance();
			if(b==true)
			{
				HttpSession hs=x.getSession(true);
				hs.setAttribute("name",m.getCustomername());
				hs.setAttribute("accnum",m.getAccnum());
				hs.setAttribute("balance", m.getBalance());//i changed.. into session
				y.sendRedirect("/BankApp/Balance.jsp");
				
			}
			else
			{
				y.sendRedirect("/BankApp/LoginFailure.jsp");
			}
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
