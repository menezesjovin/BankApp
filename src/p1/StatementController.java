package p1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StatementController
 */
@WebServlet("/StatementController")
public class StatementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest x,HttpServletResponse y) {
	HttpSession hs=x.getSession();
	int accnum=(int)hs.getAttribute("accnum");
	Model m=new Model();
	m.setAccnum(accnum);
	ArrayList al=m.miniStatement();
	hs.setAttribute("al", al);
	if(al!=null) {
		try {
			y.sendRedirect("/BankApp/StatementSuccess.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else
	{
		try {
			y.sendRedirect("/BankApp/StatementFailure.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
}
