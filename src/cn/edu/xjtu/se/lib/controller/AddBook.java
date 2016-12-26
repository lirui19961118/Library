package cn.edu.xjtu.se.lib.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.lib.dao.BookDao;
import cn.edu.xjtu.se.lib.dao.BookImpl;
import cn.edu.xjtu.se.lib.dao.UserDao;
import cn.edu.xjtu.se.lib.dao.UserImpl;
import cn.edu.xjtu.se.lib.entity.Book;
import cn.edu.xjtu.se.lib.entity.User;
import cn.edu.xjtu.se.lib.unity.StrongPsw;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		//response.setHeader("Content-Type", "text/html; charset=UTF-8");
		Book book=new Book();
		BookDao bookdao = new BookImpl();
		int num =Integer.parseInt( request.getParameter("number"));
		book.setIsbn(request.getParameter("isbn"));
		book.setBookName(request.getParameter("bookName"));
		book.setPublish(request.getParameter("publish"));
		book.setAuthor(request.getParameter("author"));
		book.setTotal_num(num);
		book.setCan_borrow(num);
		book.setDescribe(request.getParameter("describe"));
		System.out.println(book);
		bookdao.addBook(book);
	
		
		System.out.println("加入成功");
		
		ArrayList<Book> books = new ArrayList<Book>();
		books = bookdao.displayAllBook();
		
        request.setAttribute("books", books);
		
		
		request.getRequestDispatcher("views/book/bookmanager.jsp").forward(request, response);
	}

}
