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
 * Servlet implementation class ChangeNum
 */
@WebServlet("/ChangeNum")
public class ChangeNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeNum() {
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
		String isbn = request.getParameter("isbn");
		System.out.println(request.getParameter("number"));
		System.out.println(isbn);
		int num = Integer.parseInt(request.getParameter("number"));
		BookDao bookdao = new BookImpl();
		
		Book b = bookdao.searchByIsbn(isbn);
		if(num > b.getTotal_num()){
			b.setCan_borrow(b.getCan_borrow()+num-b.getTotal_num());
			b.setTotal_num(num);
		}
		else if(num < b.getTotal_num()){
			
			b.setCan_borrow(b.getCan_borrow()-b.getTotal_num()+num);
			b.setTotal_num(num);
			
		}
		
		
		bookdao.updateBook(b);
		
		
		ArrayList<Book> books = new ArrayList<Book>();
		books = bookdao.displayAllBook();
		
        request.setAttribute("books", books);
		
		request.getRequestDispatcher("views/book/bookmanager.jsp").forward(request, response);
		
		
	}

}
