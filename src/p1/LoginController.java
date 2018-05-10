package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest x,HttpServletResponse y) {
		try {
			String cusid=x.getParameter("cusid");
			String cuspwd=x.getParameter("cuspwd");
			Model m=new Model();
			m.setCusid(cusid);
			m.setCuspwd(cuspwd);
			boolean b=m.validate();
			if(b==true)
			{
				HttpSession hs=x.getSession(true);
				hs.setAttribute("name",m.getCustomername());
				hs.setAttribute("accnum",m.getAccnum());
				hs.setAttribute("balance", m.getBalance());//i changed.. into session
				y.sendRedirect("/BankApp/LoginSuccess.jsp");
				
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
