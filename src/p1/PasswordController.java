package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PasswordController
 */
@WebServlet("/PasswordController")
public class PasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   HttpSession hs;
		public void service(HttpServletRequest x,HttpServletResponse y)
		{
			try 
			{
				String opw=x.getParameter("opw");
				String npw=x.getParameter("npw");
				String cnpw=x.getParameter("cnpw");
				System.out.println(npw+" "+cnpw);
				HttpSession hs=x.getSession();
				int accnum=(int)hs.getAttribute("accnum");
				
				Model m=new Model();
				m.setOpw(opw);
				m.setNpw(npw);
				m.setCnpw(cnpw);
				m.setAccnum(accnum);
				if(!(npw.equals(cnpw))) {
					System.out.println("not equal");
					y.sendRedirect("/BankApp/PasswordChangeFailure.jsp");
				}
				//m.setBalance(balance);//1
				boolean b=m.changePassword();
				if(b==true)
				{
					//hs.setAttribute("balance",m.getBalance()); //1

					y.sendRedirect("/BankApp/PasswordChangeSuccess.jsp");
					
				}
				else
				{
					y.sendRedirect("/BankApp/PasswordChangeFailure.jsp");
				}
			}
		    
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
