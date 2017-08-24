package vzap.greg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vzap.greg.dao.BookDAO;
import vzap.greg.model.Book;

/**
 * Servlet implementation class ControllerServlet
 */
//@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private BookDAO bookDAO;

	public void init()
	{
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("choice");//request.getServletPath();
		String id = request.getParameter("id");
		System.out.println("choice = " + action);
		System.out.println("id = " + id);
		if(action == null)
		{
			action = "";
		}
		
		System.out.println("void doGet(....) method.   action = " + action);

		try
		{
			switch (action)
			{
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertBook(request, response);
				break;
			case "delete":
				deleteBook(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateBook(request, response);
				break;
			default:
				listBook(request, response);
				break;
			}
		}
		catch (SQLException ex)
		{
			System.out.println("An SQL Exception in Controller Server....>>>>>>>>");
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			//throws SQLException, IOException, ServletException
	{
		try
		{
			System.out.println("in listBook method....>>>>>>");
			List<Book> listBook = bookDAO.listAllBooks();
			request.setAttribute("listBook", listBook);
			RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
			dispatcher.forward(request, response);
		}
		catch (SQLException e)
		{
			System.out.println("An SQL Exception in Controller Server list book....>>>>>>>>");
			e.printStackTrace();
		}
		catch (ServletException e)
		{
			System.out.println("An Servlet Exception in Controller Server list book....>>>>>>>>");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("An IO Exception in Controller Server....in list book>>>>>>>>");
			e.printStackTrace();
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Book existingBook = bookDAO.getBook(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Book newBook = new Book(title, author, price);
		bookDAO.insertBook(newBook);
		response.sendRedirect("controller");
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Book book = new Book(id, title, author, price);
		bookDAO.updateBook(book);
		response.sendRedirect("controller");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));

		Book book = new Book(id);
		bookDAO.deleteBook(book);
		response.sendRedirect("controller");

	}

}
