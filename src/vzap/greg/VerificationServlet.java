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


//@WebServlet("/VerificationServlet")
public class VerificationServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public VerificationServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("I am in doGet(...) method Verification servlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("I am in doPost(...) method Verification servlet");
		// doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("username");
		String p = request.getParameter("userpass");
		System.out.println("username from index.html = " + n);
		System.out.println("password from index.html = " + p);

		if (LoginDAO.validate(n, p))
		{
			RequestDispatcher rd = request.getRequestDispatcher("controller");
			rd.forward(request, response);
		}
		else
		{
			out.print("Sorry username or password error");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}

		out.close();
	}

}
