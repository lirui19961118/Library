package cn.edu.xjtu.se.lib.dao;

import java.util.List;

import cn.edu.xjtu.se.lib.entity.Order;
import cn.edu.xjtu.se.lib.entity.User;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class UserImpl implements UserDao {

	//数据库连接对象
		private Connection conn = null;
		private Statement st = null;
		private PreparedStatement pst = null;
		private ResultSet rs = null;
	
	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		String idCard = u.getIdCard();
		String password = u.getPassword();
		String name = u.getName();
		String phone = u.getPhone();
		int total_num = u.getTotal_num();
		int already_num = u.getAlready_num();
		String status = u.getStatus();
		
		conn = DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return null;
		}
		try {
			String sql="" +
					"insert into User" +
					"(idCard,password,name,phone,total_num,already_num,status)" +
					"values(" +
					"?,?,?,?,?,?,?)";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			//System.out.println(sql);
			ptmt.setString(1, idCard);
			ptmt.setString(2, password);
			ptmt.setString(3, name);
			ptmt.setString(4, phone);
			ptmt.setInt(5, total_num);
			ptmt.setInt(6, already_num);
			ptmt.setString(7, status);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return u;
	}

	@Override
	public boolean removeUser(User u) {
		// TODO Auto-generated method stub
		boolean flag = true;
		Connection conn=DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return false;
		}
		
		try {
			String sql="" +
					" delete from User " +
					" where idCard=? ";
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, u.getIdCard());
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
	public User updatePsw(User u) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return null;
		}
		
		try {
			String sql="" +
					" update User " +
					" set password=? " +
					" where idCard=? ";
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, u.getPassword());
			ptmt.setString(2, u.getIdCard());
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return u;

	}
	
	@Override
	public User updateStatus(User u) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return null;
		}
				
		try {
			String sql="" +
					" update User " +
					" set status=? " +
					" where idCard=? ";
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, u.getStatus());
			ptmt.setString(2, u.getIdCard());
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return u;

	}
	@Override
	public User updateNum(User u) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return null;
		}
				
		try {
			String sql="" +
					" update User " +
					" set already_num=? " +
					" where idCard=? ";
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, u.getAlready_num());
			System.out.println(u.getAlready_num());
			ptmt.setString(2, u.getIdCard());
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return u;

	}
	@Override
	public User searchUserByIdCard(String idCard) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from User ");
		sb.append(" where idCard=?");
		User u = null;
		try {
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, idCard);
			
			System.out.println(sb.toString());
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				System.out.println("根据idcard找到用户");
				u = new User();
				u.setIdCard(rs.getString("idCard"));
				u.setAlready_num(rs.getInt("already_num"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getString("phone"));
				u.setStatus(rs.getString("status"));
				u.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public ArrayList<Order> searchUserByIsbn(String isbn) {
		// TODO Auto-generated method stub
		ArrayList<Order> result=new ArrayList<Order>();
		String sql = "select * from User_Book where isbn='"+isbn+"'";
		result = new QueryList().queryReturnList(sql);
		return result;
	}
	
	@Override
	public ArrayList<User> displayAllUser() {
	// TODO 自动生成的方法存根
		ArrayList<User> us = new ArrayList<User>();
		String sql = "select * from user";
		us = new QueryList().queryReturnList(sql);
		return us;
	}
	
	
	

}
