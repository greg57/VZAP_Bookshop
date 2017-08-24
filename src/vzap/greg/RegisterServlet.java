package vzap.greg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vzap.greg.dao.LoginDAO;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public RegisterServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("I am in doPost(...) method register servlet");
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		System.out.println("name entered = " + name);
		String email = request.getParameter("email");
		System.out.println("email = " + email);
		String username = request.getParameter("username");
		System.out.println("username = " + username);
		String password = request.getParameter("password");
		System.out.println("password = " + password);

//		if (LoginDAO.validate(n, p))
//		{
//			RequestDispatcher rd = request.getRequestDispatcher("controller");
//			rd.forward(request, response);
//		}
//		else
//		{
//			out.print("Sorry username or password error");
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.include(request, response);
//		}
//
//		out.close();
	}

}
