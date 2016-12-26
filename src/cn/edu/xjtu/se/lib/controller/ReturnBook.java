package cn.edu.xjtu.se.lib.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.xjtu.se.lib.dao.BookImpl;
import cn.edu.xjtu.se.lib.dao.OrderImpl;
import cn.edu.xjtu.se.lib.dao.UserImpl;
import cn.edu.xjtu.se.lib.entity.Book;
import cn.edu.xjtu.se.lib.entity.Order;
import cn.edu.xjtu.se.lib.entity.User;

/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
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
		
		HttpSession session = request.getSession();
		
		User user=(User)session.getAttribute("user");
		User  u = new User();
		
		u.setIdCard(user.getIdCard());
		u.setAlready_num(user.getAlready_num()-1);
		
		UserImpl userdao = new UserImpl();
		userdao.updateNum(u);
		
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String isbn = request.getParameter("bookId");
		BookImpl b = new BookImpl();
		Book book = b.searchByIsbn(isbn);
		

		book.setCan_borrow(book.getCan_borrow()+1);
		//System.out.println(book);
		b.updateBook(book);
		
		User genxin = userdao.searchUserByIdCard(user.getIdCard());
		session.setAttribute("user", genxin);
		
		OrderImpl or = new OrderImpl();
		or.removeOrderById(orderId);
		
		
		ArrayList orderList = new ArrayList();
		//System.out.println(user.getIdCard());
		orderList = or.searchByIdcard(user.getIdCard());
		//System.out.println(orderList);

	    session.setAttribute("infoborrow",orderList);
		
		request.getRequestDispatcher("views/user/ReaderInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
