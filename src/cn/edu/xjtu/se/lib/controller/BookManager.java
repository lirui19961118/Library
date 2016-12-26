package cn.edu.xjtu.se.lib.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.lib.dao.BookDao;
import cn.edu.xjtu.se.lib.dao.BookImpl;
import cn.edu.xjtu.se.lib.entity.Book;

/**
 * Servlet implementation class BookManager
 */
@WebServlet("/BookManager")
public class BookManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BookDao bookdao = new BookImpl();
		ArrayList<Book> books = new ArrayList<Book>();
		books = bookdao.displayAllBook();
		
        request.setAttribute("books", books);
		
		request.getRequestDispatcher("views/book/bookmanager.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
