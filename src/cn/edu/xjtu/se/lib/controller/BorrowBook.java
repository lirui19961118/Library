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
import javax.websocket.Session;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

import cn.edu.xjtu.se.lib.dao.BookImpl;
import cn.edu.xjtu.se.lib.dao.OrderImpl;
import cn.edu.xjtu.se.lib.entity.Book;
import cn.edu.xjtu.se.lib.entity.Order;
import cn.edu.xjtu.se.lib.entity.User;

/**
 * Servlet implementation class BorrowBook
 */
@WebServlet("/BorrowBook")
public class BorrowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBook() {
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
		
		
		long t = new java.util.Date().getTime();//得到1970-1-1 0:0:0到现在的毫秒数
		Date date = new Date(t);
		t += 1728000000;
		Date date1 = new Date(t);
		
		String isbn = request.getParameter("bookId");
		BookImpl b = new BookImpl();
		Book book = b.searchByIsbn(isbn);
		
		Order o = new Order();
		//o.setUserBookId(0);
		o.setIdCard(user.getIdCard());
		o.setIsbn(book.getIsbn());
		o.setStatus("normal");
		o.setBorrowTime(date);
		o.setReturnTime(date1);
		
		OrderImpl or = new OrderImpl();
		
		or.addOrder(o);//未加入数据库？？？？
		
		ArrayList orderList = new ArrayList();
		System.out.println(user.getIdCard());
		orderList = or.searchByIdcard(user.getIdCard());
		System.out.println(orderList);

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
