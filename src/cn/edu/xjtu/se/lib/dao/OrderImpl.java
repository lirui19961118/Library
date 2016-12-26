package cn.edu.xjtu.se.lib.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.edu.xjtu.se.lib.entity.Book;
import cn.edu.xjtu.se.lib.entity.Order;

public class OrderImpl implements OrderDao {
	//数据库连接对象
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	@Override
	public Order addOrder(Order o) {
		// TODO Auto-generated method stub
		String idCard = o.getIdCard();
		String isbn = o.getIsbn();
		int id = o.getUserBookId();
		String status = o.getStatus();
		Date borrowTime = o.getBorrowTime();
		Date returnTime = o.getReturnTime();
		
		conn = DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return null;
		}
		try {
			String sql="" +
					"insert into user_book" +
					"(UserBookId,idCard,isbn,borrowTime,returnTime,status)" +
					"values(" +
					"?,?,?,?,?,?)";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			System.out.println(sql);
			ptmt.setInt(1, id);
			ptmt.setString(2, idCard);
			ptmt.setString(3, isbn);
			ptmt.setDate(4, borrowTime);
			ptmt.setDate(5, returnTime);
			ptmt.setString(6, status);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return o;
	}

	@Override
	public boolean removeOrder(String isbn, String idCard) {
		// TODO Auto-generated method stub
		boolean flag = true;
		Connection conn=DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return false;
		}
		
		try {
			String sql="" +
					" delete from user_book " +
					" where isbn=? and idCard=?";
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, isbn);
			ptmt.setString(2, idCard);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return flag;
	}

	@Override
	public Order searchOrder(String isbn, String idCard) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from user_book ");
		sb.append(" where isbn=?, idCard=?");
		Order o = null;
		try {
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, isbn);
			ptmt.setString(2, idCard);
			System.out.println(sb.toString());
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				o = new Order();
				o.setIsbn(rs.getString("isbn"));
				o.setStatus(rs.getString("status"));
				o.setBorrowTime(rs.getDate("borrowTime"));
				o.setIdCard(rs.getString("idCard"));
				o.setReturnTime(rs.getDate("returnTime"));
				o.setUserBookId(rs.getInt("UserBookId"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}

		return o;
	}

	@Override
	public boolean updateStatus(String isbn, String idCard, String status) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return false;
		}
		
		try {
			String sql="" +
					" update user_book " +
					" set status=? " +
					" where isbn=?, idCard=?";
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, status);
			ptmt.setString(2, isbn);
			ptmt.setString(3, idCard);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return true;
	}
	@Override
	public ArrayList<Order> searchByIdcard(String idCard) {
		// TODO 自动生成的方法存根
		ArrayList<Order> b = new ArrayList<Order>();
		String sql = "select * from user_book where idCard='"+idCard+"'";//查表查错了？？是user_book
		b = new QueryList().queryReturnList(sql);
		return b;
	}
	
	@Override
	public boolean removeOrderById(int id) {
		boolean flag = true;
		Connection conn=DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return false;
		}
		
		try {
			String sql="" +
					" delete from user_book " +
					" where UserBookId=?";
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return flag;
	}
}
