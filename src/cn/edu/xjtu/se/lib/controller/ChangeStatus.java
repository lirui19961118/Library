package cn.edu.xjtu.se.lib.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.lib.dao.UserDao;
import cn.edu.xjtu.se.lib.dao.UserImpl;
import cn.edu.xjtu.se.lib.entity.User;

/**
 * Servlet implementation class ChangeStatus
 */
@WebServlet("/ChangeStatus")
public class ChangeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stuid = request.getParameter("userId");
		UserDao userdao = new UserImpl();
		
		User user = userdao.searchUserByIdCard(stuid);
		
		if(user.getStatus().equals("normal"))
			user.setStatus("declined");
		else
			user.setStatus("normal");
		
		userdao.updateStatus(user);
		ArrayList<User> users = new ArrayList<User>();
		
		users = userdao.displayAllUser();
		request.getSession().setAttribute("users", users);
		request.getRequestDispatcher("views/user/manager.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
